package com.soda.magazine.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soda.magazine.model.dao.MagazineDao;
import com.soda.magazine.model.vo.MagazineFile;
import com.soda.magazine.model.vo.Magazine;
import com.soda.magazine.model.vo.PageInfo;
import com.soda.magazine.model.vo.Reply;
import com.soda.mypage.model.vo.Profile;

public class MagazineService {

	private MagazineDao magazineDao = new MagazineDao();

//	 /* 페이징 : 페이지와 게시글리스트를 리턴*/
//		public Map<String, Object> selectList(int page) {
//			Connection conn = getConnection();
//			
//			// 1. 조회할 게시글 총 개수 구하기 
//			int listCount = magazineDao.getListCount(conn);
//			// System.out.println(listCount);
//			
//			// 2. PageInfo 객체 만들기 (목록 5개씩, 한 페이지당 9개 게시글)
//			PageInfo pi = new PageInfo(page, listCount, 5, 16);
//			
//			// 3. 페이징 처리 된 게시글 목록 조회
//			List<Magazine> magazineList = magazineDao.selectList(conn, pi);
//			
//			Map<String, Object> returnMap = new HashMap<>();
//			
//			//System.out.println(pi); 
//			//System.out.println(lessonList);
//			
//			
//			returnMap.put("pi", pi);
//			returnMap.put("magazineList", magazineList);
//			
//			
//			return returnMap;
//		}

	
	// 유저 작성하기
	public int insertUser(Magazine user) {
		Connection conn = getConnection();

		/* Magazine 테이블에 삽입 */
		int UserResult = magazineDao.insertUser(conn, user);

		/* File 테이블에 삽입 */
		int fileResult = 0;
		for (MagazineFile photo : user.getPhotoList()) {
			fileResult += magazineDao.insertFile(conn, photo);
		}

		int result = 0; // 3가지 로직이 모두 잘 수행 되었음을 나타내는 변수
		if (UserResult > 0 && fileResult == user.getPhotoList().size()) {
			// fileResult = 사진 삽입(insert)이 정상 수행 된 갯수, size() = 실제 첨부 된 사진 갯수
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	// 디테일 뷰
	public Magazine selectMagazine(int nNum) {
		Connection conn = getConnection();

		/* magazine 테이블 정보 조회 */
		Magazine magazine = magazineDao.selectMagazine(conn, nNum);

		/* magazineFile 테이블 정보 조회 */
		List<MagazineFile> photoList = magazineDao.selectPhotoList(conn, nNum);
		magazine.setPhotoList(photoList);
		
		// 댓글 조회 추가
	      magazine.setReplyList(magazineDao.selectReplyList(conn, nNum));

		close(conn);
		

		return magazine;

	}

//	// 조회수 증가
//	public int increaseCount(int nNum) {
//		Connection conn = getConnection();
//
//		int result = magazineDao.increaseCount(conn, nNum);
//
//		if (result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//
//		close(conn);
//
//		return result;
//	}

	// 매거진 전체 메인 화면 불러오기
	public List<Magazine> selectUserList() {
		Connection conn = getConnection();

		List<Magazine> userList = magazineDao.selectUserList(conn);
		// System.out.println(conn);
		close(conn);

		return userList;
	}

	// 관리자 작성하기
	public int insertAdmin(Magazine admin) {
		Connection conn = getConnection();

		/* Magazine 테이블에 삽입 */
		int adminResult = magazineDao.insertAdmin(conn, admin);

		/* File 테이블에 삽입 */
		int fileResult = 0;
		for (MagazineFile photo : admin.getPhotoList()) {
			fileResult += magazineDao.insertFile(conn, photo);
		}

		int result = 0; // 3가지 로직이 모두 잘 수행 되었음을 나타내는 변수
		if (adminResult > 0 && fileResult == admin.getPhotoList().size()) {
			// fileResult = 사진 삽입(insert)이 정상 수행 된 갯수, size() = 실제 첨부 된 사진 갯수
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 관리자 메인 페이지 조회
	public List<Magazine> selectAdminList() {
		Connection conn = getConnection();

		List<Magazine> magazineAdminList = magazineDao.selectAdminList(conn);
		// System.out.println(conn);
		close(conn);

		return magazineAdminList;
	}

	// 디테일 삭제
	public List<MagazineFile> deleteMagazine(int nNum) {
		 Connection conn = getConnection();
	      
	      List<MagazineFile> deletedPhotoList = magazineDao.selectPhotoList(conn, nNum);   /* 게시물 번호에 해당하는 이미지파일을 정보 얻어옴 */
	      
	      int boardResult = magazineDao.deleteMagazine(conn, nNum);   /* 게시글 지우기 */
	      
	      int photoResult = magazineDao.deletePhoto(conn, nNum);   /* 이미지 지우기 */
	      
	      if(boardResult > 0 && photoResult == deletedPhotoList.size()) {   /* 보드테이블 삭제 & 이미지 삭제 1 ~ 3행 */
	         commit(conn);
	      } else {
	         rollback(conn);
	         deletedPhotoList = null;   /* 실패 시 이미지 삭제 방지 */
	      }
	      
	      close(conn);
	      
	      return deletedPhotoList;
	}

	public int updateMagazine(Magazine magazine) {
		 Connection conn = getConnection();
	      
	      /* Board 테이블 수정 */
	      int updateResult = magazineDao.updateMagazine(conn, magazine);
	      
	      // 실행 결과
	      int updatePhotoResult = 0;
	      int insertPhotoResult = 0;
	      // 수행 해야할 리스트 갯수
	      int updateListCount = 0;
	      int insertListCount = 0;
	      
	      /* Attachment 테이블 수정 */
	      for(MagazineFile photo : magazine.getPhotoList()) {
	         if(photo.getDeletedName() != null) {
	            /* 기존에 있던 파일을 덮어쓰기 - update */
	            updatePhotoResult += magazineDao.updatePhoto(conn, photo);
	            updateListCount++;
	         }else {
	            /* 새로 첨부 된 파일을 추가하기 - insert */
	            insertPhotoResult += magazineDao.insertAddedPhoto(conn, magazine.getnNum(), photo);
	            insertListCount++;
	         }
	      }
	      
	      int result = 0;
	      if(updateResult > 0 
	            && updatePhotoResult == updateListCount 
	            && insertPhotoResult == insertListCount) {
	         result = 1;
	         commit(conn);
	      }else {
	         rollback(conn);
	      }
	      
	      return result;
	   }

	public List<Reply> insertReply(Reply reply) {
		Connection conn = getConnection();
		List<Reply> replyList = null;
		
		// 댓글 입력
		int result = magazineDao.insertReply(conn, reply);
		
		if(result > 0) {
			commit(conn);
			// 갱신된 댓글 목록 조회
			replyList = magazineDao.selectReplyList(conn, reply.getnNum());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return replyList;
	}

	public List<Magazine> selectUserselfList() {
		Connection conn = getConnection();

		List<Magazine> userselfList = magazineDao.selectUserselfList(conn);
		close(conn);

		return userselfList;
	}


	public List<Magazine> selectOthersList(String userId) {
		Connection conn = getConnection();

		List<Magazine> othersList = magazineDao.selectOthersList(conn, userId);
		close(conn);

		return othersList;

	}

	

	

}
