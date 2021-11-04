package com.soda.lesson.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soda.lesson.model.dao.LessonDao;
import com.soda.lesson.model.vo.Attachment;
import com.soda.lesson.model.vo.Lesson;
import com.soda.lesson.model.vo.Notice;
import com.soda.lesson.model.vo.PageInfo;
import com.soda.socialing.model.vo.File;

import static com.common.JDBCTemplate.*;


public class LessonService {
	private LessonDao lessonDao = new LessonDao();
	
	/* 페이징 : 페이지와 게시글리스트를 리턴*/
	public Map<String, Object> selectList(int page) {
		Connection conn = getConnection();
		
		// 1. 조회할 게시글 총 개수 구하기 
		int listCount = lessonDao.getListCount(conn);
		//System.out.println(listCount);
		
		// 2. PageInfo 객체 만들기 (목록 5개씩, 한 페이지당 9개 게시글)
		PageInfo pi = new PageInfo(page, listCount, 5, 9);
		
		// 3. 페이징 처리 된 게시글 목록 조회
		List<Lesson> lessonList = lessonDao.selectList(conn, pi);
		
		Map<String, Object> returnMap = new HashMap<>();
		
		//System.out.println(pi); 
		//System.out.println(lessonList);
		
		
		returnMap.put("pi", pi);
		returnMap.put("lessonList", lessonList);
		
		
		return returnMap;
	}

	// 조회수 증가
	public int increaseCount(int nNum) {
		Connection conn = getConnection();
		
		int result = lessonDao.increaseCount(conn, nNum);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	// 사진 게시판 상세페이지 조회
	public Lesson selectLesson(int nNum) {
		Connection conn = getConnection();
		
		Lesson lesson = lessonDao.selectLesson(conn, nNum);
		
		List<Attachment> photoList = lessonDao.selectPhotoList(conn, nNum);
		lesson.setPhotoList(photoList);
		
		/* 문의 사항 추가 필요 */
		
		close(conn);
		return lesson;
	}
}
