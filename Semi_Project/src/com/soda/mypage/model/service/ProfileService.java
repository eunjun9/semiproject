package com.soda.mypage.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.soda.magazine.model.vo.MagazineFile;
import com.soda.mypage.model.dao.ProfileDao;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;

public class ProfileService {

	private ProfileDao profileDao = new ProfileDao();
	
	
	
	
	
	public int insertProfile(Profile profile, ProfileFile file) {
		Connection conn = getConnection();
	      
	      /* Board 테이블에 삽입 - 기존 메소드 활용 */
	      int insertResult = profileDao.insertProfile(conn, profile);
	      
	      /* Attachment 테이블 삽입 */
	      int attachmentResult = 0;
	         attachmentResult = profileDao.insertFile(conn, file);
	      
	      
	      int result = 0;    // 2가지 로직이 모두 잘 수행되었음을 나타내는 변수
	      if(insertResult > 0 && attachmentResult == profile.getProfileFile().size()) {
	         commit(conn);   // 2개의 모든 로직이 잘 수행되었을 때
	         result = 1;
	      } else {
	         rollback(conn);
	      }
	      
	      close(conn);
	      
	      return result;
	   }
	
	
	
	public int modifyProfile(Profile profile, ProfileFile file) {

		int insertFile = 0;
		
		Connection conn = getConnection();
		int result = profileDao.modifyProfile(conn, profile);
		
		if(result>0) {
			insertFile = profileDao.modifyFile(conn, file);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		

		close(conn);

		return insertFile;
				
		     
		}

	// myfeed에 불러오기
	public Profile selectProfile(String userId) {
		Connection conn = getConnection();

		/* Profile 테이블 정보 조회 */
		Profile profile = profileDao.selectProfile(conn, userId);
		
		List<ProfileFile> profileFile = profileDao.selectProfileFile(conn, userId);
		profile.setProfileFile(profileFile);

		close(conn);
		

		return profile;
		
	}





	

	}

