package com.soda.magazine.model.service;

import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soda.lesson.model.vo.Lesson;
import com.soda.lesson.model.vo.PageInfo;
import com.soda.magazine.model.dao.MagazineDao;
import com.soda.magazine.model.vo.Notice;

public class MagazineService {

	 private MagazineDao magazineDao = new MagazineDao();
	   
	 /* 페이징 : 페이지와 게시글리스트를 리턴*/
		public Map<String, Object> selectList(int page) {
			Connection conn = getConnection();
			
			// 1. 조회할 게시글 총 개수 구하기 
			int listCount = magazineDao.getListCount(conn);
			// System.out.println(listCount);
			
			// 2. PageInfo 객체 만들기 (목록 5개씩, 한 페이지당 9개 게시글)
			PageInfo pi = new PageInfo(page, listCount, 5, 9);
			
			// 3. 페이징 처리 된 게시글 목록 조회
			List<Notice> noticeList = magazineDao.selectList(conn, pi);
			
			Map<String, Object> returnMap = new HashMap<>();
			
			//System.out.println(pi); 
			//System.out.println(lessonList);
			
			
			returnMap.put("pi", pi);
			returnMap.put("noticeList", noticeList);
			
			
			return returnMap;
		}
}
