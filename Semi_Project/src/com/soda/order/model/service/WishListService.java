package com.soda.order.model.service;

import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.soda.order.model.dao.WishListDao;
import com.soda.order.model.vo.WishList;

public class WishListService {
	
	private WishListDao wishListDao = new WishListDao();


	// 클래스를 장바구니에 추가
	public List<WishList> wishListAdd(WishList wishlist) {
		Connection conn = getConnection();
		List<WishList> listResult = null;
		
		// 장바구니에 클래스 insert 결과
		int result = wishListDao.wishListAdd(conn, wishlist);
		
		if(result > 0) {
			commit(conn);
			listResult = wishListDao.wishlistList(conn, wishlist.getUserId());
		} else {
			rollback(conn);
		}
		close(conn);
		
		return listResult;
	}

	// 장바구니 조회
	public List<WishList> wishlistList(String userId) {
		Connection conn = getConnection();
		
		List<WishList> wishlist = wishListDao.wishlistList(conn, userId);
		
		close(conn);
		
		return wishlist;
	}

	// 장바구니 삭제
	public int deleteWishlist(int deleteList, String userId) {
		Connection conn = getConnection();
		int result = wishListDao.deleteWishlist(conn, deleteList, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	// 결제 화면 조회
		public List<WishList> whsilistPay(int nNum,  String selDate) {
			Connection conn = getConnection();

			List<WishList> wishlist = wishListDao.wishlistPay(conn, nNum, selDate);

			close(conn);

			return wishlist;


		}

	



}
