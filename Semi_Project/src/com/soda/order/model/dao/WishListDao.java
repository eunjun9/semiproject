package com.soda.order.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;

import com.soda.member.model.dao.MemberDao;
import com.soda.order.model.vo.WishList;

public class WishListDao {

	private Properties wishlistQuery = new Properties();
	
	public WishListDao() {
		wishlistQuery = new Properties();
		String fileName = MemberDao.class.getResource("/com/sql/wishlist/wishlist-query.xml").getPath();
		try {
			wishlistQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 장바구니 중복 체크
	public int wishListCheck(Connection conn, int nNum, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = wishlistQuery.getProperty("wishListCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, nNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	// 클래스를 장바구니에 추가
	public int wishListAdd(Connection conn, WishList lessonAdd) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = wishlistQuery.getProperty("wishListAdd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lessonAdd.getnNum());
			pstmt.setString(2, lessonAdd.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public List<WishList> wishlistList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<WishList> wishlist = new ArrayList<>();
		String sql = wishlistQuery.getProperty("wishlist");
		
		
		
		
		
		return null;
	}
	
}
