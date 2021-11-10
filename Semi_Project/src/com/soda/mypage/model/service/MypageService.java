package com.soda.mypage.model.service;

import java.sql.Connection;
import java.util.List;

import com.soda.lesson.model.vo.Lesson;
import com.soda.mypage.model.dao.MypageDao;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;

import static com.common.JDBCTemplate.*;

public class MypageService {
	private MypageDao mypageDao = new MypageDao();
	
	// 강사가 작성한 클래스 조회
	public List<Lesson> selectLessonList(String user) {
		Connection conn = getConnection();
		
		List<Lesson> lessonList = mypageDao.selectLessonList(conn, user);
		
		close(conn);
		
		return lessonList;
	}
	
	// 마이페이지 프로필 가져오기
	public Profile selectProfile(String userId) {
		Connection conn = getConnection();
		
		Profile profile = mypageDao.selectProfile(conn, userId);
		
		List<ProfileFile> profileFile = mypageDao.selectProfileFile(conn, userId);
		
		profile.setProfileFile(profileFile);
		
		close(conn);

		return profile;
	}

}
