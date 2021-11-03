package com.soda.socialing.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soda.socialing.model.dao.SocialingDao;
import com.soda.socialing.model.vo.PageInfo;
import com.soda.socialing.model.vo.Socialing;

public class SocialingService {
	
	private SocialingDao socialingDao = new SocialingDao();
	
	/* 페이징 : 페이지와 게시글리스트를 리턴*/
	public Map<String, Object> selectList(int page) {
		Connection conn = getConnection();
		
		// 1. 조회할 게시글 총 개수 구하기 
		int listCount = socialingDao.getListCount(conn);
		
		// 2. PageInfo 객체 만들기 (목록 5개씩, 한 페이지당 9개 게시글)
		PageInfo pi = new PageInfo(page, listCount, 5, 9);
		
		// 3. 페이징 처리 된 게시글 목록 조회
		List<Socialing> socialingList = socialingDao.selectList(conn, pi);
		
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("pi", pi);
		returnMap.put("socialingList", socialingList);
		
		return returnMap;
	}

//	public List<Socialing> selectList() {
//		Connection conn = getConnection();
//		
//		List<Socialing> socialingList = socialingDao.selectList(conn);
//		
//		close(conn);
//		
//		return socialingList;
//	}

}
