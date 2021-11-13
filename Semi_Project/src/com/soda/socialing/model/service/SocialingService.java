package com.soda.socialing.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soda.socialing.model.dao.SocialingDao;
import com.soda.socialing.model.vo.PageInfo;
import com.soda.socialing.model.vo.Search;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SocialingLike;
import com.soda.socialing.model.vo.SocialingMember;
import com.soda.socialing.model.vo.SodaFile;

public class SocialingService {
	
	private SocialingDao socialingDao = new SocialingDao();
	
	/* 페이징 : 페이지와 게시글리스트를 리턴 */
	public Map<String, Object> selectList(int page, Search search) {
		Connection conn = getConnection();
		
		// 1. 조회할 게시글 총 개수 구하기 
		int listCount = socialingDao.getListCount(conn, search);
		
		// 2. PageInfo 객체 만들기 (목록 5개씩, 한 페이지당 9개 게시글)
		PageInfo pi = new PageInfo(page, listCount, 5, 9);
		
		// 3. 페이징 처리 된 게시글 목록 조회
		List<Socialing> socialingList = socialingDao.selectList(conn, pi, search);
		
		// 4. 시작 임박 소셜링 목록 조회
		List<Socialing> soonSocialingList = socialingDao.selectSoonList(conn);
		
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("pi", pi);
		returnMap.put("socialingList", socialingList);
		returnMap.put("soonSocialingList", soonSocialingList);
		
		return returnMap;
	}
	
	/* 게시글 조회수 증가 */
	public int increaseCount(int nNum) {
		Connection conn = getConnection();
		
		int result = socialingDao.increaseCount(conn, nNum);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Socialing selectSocialing(int nNum) {
		Connection conn = getConnection();
		
		/* Notice + Socialing 테이블 정보 조회 */
		Socialing socialing = socialingDao.selectSocialing(conn, nNum);
		
		/* File 테이블 정보 조회 */
		List<SodaFile> photoList = socialingDao.selectPhotoList(conn, nNum);
		socialing.setPhotoList(photoList);
		
		close(conn);
		
		return socialing;
	}
	
	public List<SocialingMember> selectMember(int nNum) {
		Connection conn = getConnection();
		
		/* Socialing_member 테이블 정보 조회 */
		List<SocialingMember> socialing = socialingDao.selectMember(conn, nNum);
		
		close(conn);
		
		return socialing;
	}

	public int insertSocialing(Socialing socialing) {
		Connection conn = getConnection();
		
		/* Notice 테이블에 삽입 */
		int NoticeResult = socialingDao.insertNotice(conn, socialing);
		
		/* Socialing 테이블에 삽입 */
		int socialingResult = socialingDao.insertSocialing(conn, socialing);
		
		/* File 테이블에 삽입 */
		int fileResult = 0;
		for(SodaFile photo : socialing.getPhotoList()) {
			fileResult += socialingDao.insertFile(conn, photo);
		}
		
		int result = 0;	// 3가지 로직이 모두 잘 수행 되었음을 나타내는 변수
		if(NoticeResult > 0 && socialingResult > 0 && fileResult == socialing.getPhotoList().size()) {
			// fileResult = 사진 삽입(insert)이 정상 수행 된 갯수, size() = 실제 첨부 된 사진 갯수
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertMember(int nNum, String userId) {
		Connection conn = getConnection();
		
		// 중복참여 방지 로직 추가해야 함
		int result = socialingDao.insertMember(conn, nNum, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateMember(int nNum, String userId) {
		Connection conn = getConnection();
		
		int result = socialingDao.updateMember(conn, nNum, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateSocialing(Socialing socialing) {
		Connection conn = getConnection();
		
		/* Notice 테이블 수정 */
		int noticeResult = socialingDao.updateNotice(conn, socialing);
		
		/* Socialing 테이블 수정 */
		int socialingResult = socialingDao.updateSocialing(conn, socialing);
		
		System.out.println(noticeResult);
		System.out.println(socialingResult);
		
		/* 실제 수행 값을 담을 변수 */
		int updatePhotoResult = 0;
		/* 수행 해야 될 리스트의 갯수를 담을 변수 */
		int updateListCount = 0;
		
		/* Tbl_File 테이블 수정 및 삽입 */
		for(SodaFile photo : socialing.getPhotoList()) {
			if(photo.getDeletedName() != null) {
				/* 기존에 있던 파일을 덮어쓰기 - update */
				updatePhotoResult += socialingDao.updatePhoto(conn, photo);
				updateListCount++;
				System.out.println("update : " + photo);
				System.out.println("updatePhotoResult : " + updatePhotoResult);
			}
		}
		
		int result = 0;
		if(noticeResult > 0 && socialingResult > 0 && updatePhotoResult == updateListCount) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public List<SodaFile> deleteSocialing(int nNum) {
		Connection conn = getConnection();
		
		List<SodaFile> deletedPhotoList = socialingDao.selectPhotoList(conn, nNum); // nNum으로 조회한 사진 갯수
		
		int boardResult = socialingDao.deleteSocialing(conn, nNum); // notice 테이블 status 변경
		
		int photoResult = socialingDao.deletePhoto(conn, nNum); // file 테이블 status 변경
		
		if(boardResult > 0 && photoResult == deletedPhotoList.size()) {
			commit(conn);
		} else {
			rollback(conn);
			deletedPhotoList = null;
		}
		
		close(conn);
		
		return deletedPhotoList;
	}

	public int likeSocialing(int nNum, String userId) {
		Connection conn = getConnection();
		
		// 중복추가 방지 로직 추가해야 함
		int result = socialingDao.likeSocialing(conn, nNum, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public List<SocialingLike> selectLikedList(int nNum) {
		Connection conn = getConnection();
		
		/* Socialing_like 테이블 정보 조회 */
		List<SocialingLike> socialingLike = socialingDao.selectLikedList(conn, nNum);
		
		close(conn);
		
		return socialingLike;
	}

	public int unLikeSocialing(int nNum, String userId) {
		Connection conn = getConnection();
		
		int result = socialingDao.unLikeSocialing(conn, nNum, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public List<Socialing> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Socialing> socialinglistview() {
		Connection conn = getConnection();
		
		List<Socialing> socialingList = socialingDao.socialinglistview(conn);
		
		close(conn);
		
		return socialingList;
	}

	

	

}
