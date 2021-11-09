package com.soda.mypage.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.soda.magazine.model.dao.MagazineDao;
import com.soda.magazine.model.vo.Magazine;
import com.soda.magazine.model.vo.MagazineFile;
import com.soda.mypage.model.dao.ProfileDao;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;

public class ProfileService {

	private ProfileDao profileDao = new ProfileDao();
	
	public int modifyProfile(Profile profile) {

		
			Connection conn = getConnection();
		      int result = profileDao.modifyProfile(conn, profile);
		      
		      /* File 테이블에 삽입 */
				int fileResult = 0;
				for (ProfileFile photo : profile.getPhotoList()) {
					fileResult += profileDao.insertFile(conn, photo, profile);
				}

				int realResult = 0; // 3가지 로직이 모두 잘 수행 되었음을 나타내는 변수
				if (result > 0 && fileResult == profile.getPhotoList().size()) {
					// fileResult = 사진 삽입(insert)이 정상 수행 된 갯수, size() = 실제 첨부 된 사진 갯수
					commit(conn);
					result = 1;
				} else {
					rollback(conn);
				}

				close(conn);

				return realResult;
		}

	public Profile selectProfile(String userId) {
		Connection conn = getConnection();

		/* magazine 테이블 정보 조회 */
		Profile profile = profileDao.selectProfile(conn, userId);

		
		/* magazineFile 테이블 정보 조회 */
//		List<MagazineFile> photoList = profileDao.selectPhotoList(conn, nNum);
//		magazine.setPhotoList(photoList);

		close(conn);
		

		return profile;
		
	}

	}

