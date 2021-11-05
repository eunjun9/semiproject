package com.soda.order.model.service;

import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.soda.member.model.vo.Member;
import com.soda.order.model.dao.WishListDao;
import com.soda.order.model.vo.WishList;

public class WishListService {
	
	private WishListDao wishListDao = new WishListDao();

	// 장바구니 중복 체크
	public int wishListCheck(int nNum, String userId) {
		Connection conn = getConnection();
		
		int result = wishListDao.wishListCheck(conn, nNum, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 클래스를 장바구니에 추가
	public int wishListAdd(WishList lessonAdd) {
		Connection conn = getConnection();
		
		int result = wishListDao.wishListAdd(conn, lessonAdd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public List<WishList> wishlistList(String userId) {
		Connection conn = getConnection();
		
		List<WishList> wishlist = wishListDao.wishlistList(conn, userId);
		
		close(conn);
		
		return wishlist;
	}

}
