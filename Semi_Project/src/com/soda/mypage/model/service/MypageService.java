package com.soda.mypage.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soda.lesson.model.vo.Lesson;
import com.soda.lesson.model.vo.PageInfo;
import com.soda.mypage.model.dao.MypageDao;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;
import com.soda.socialing.model.vo.Socialing;

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
	
	// 관심 소셜링 가져오기
	public Map<String, Object> likeSocialingList(int page, Socialing socialing) {
		Connection conn = getConnection();
		
		// 게시글 총 개수 
		int listCount = mypageDao.getSocialingListCount(conn, socialing);
		
		// 페이지 객체
		PageInfo pi = new PageInfo(page, listCount, 3, 6);
		
		// 목록 조회
		List<Socialing> socialingList = mypageDao.selectSocialingList(conn, pi);
		//System.out.println(listCount);
		
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("pi", pi);
		returnMap.put("socialingList", socialingList);
		
		close(conn);
		
		return returnMap;
	}

	// 소셜링 내역 - 참여 완료
	public List<Socialing> socialingListAfter(String userId) {
		Connection conn = getConnection();
		
		List<Socialing> socialingListAfter = mypageDao.selectMySocialingListAfter(conn,userId);
		
		close(conn);
		
		return socialingListAfter;
	}

	public List<Socialing> socialingListBefore(String userId) {
		Connection conn = getConnection();
		
		List<Socialing> socialingListBefore = mypageDao.selectMySocialingListBefore(conn,userId);
		
		close(conn);
		
		return socialingListBefore;
	}

}
