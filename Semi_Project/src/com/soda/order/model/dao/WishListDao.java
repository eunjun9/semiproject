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


	// 클래스를 장바구니에 추가
	public int wishListAdd(Connection conn, WishList wishlist) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		String sql = wishlistQuery.getProperty("wishListAdd");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, wishlist.getnNum());
				pstmt.setString(2, wishlist.getUserId());
				
				result = pstmt.executeUpdate();
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(rset);
				close(pstmt);
			}
		
		return result;
	}

	// 장바구니 리스트 조회
	public List<WishList> wishlistList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<WishList> wishlist = new ArrayList<>();
		String sql = wishlistQuery.getProperty("wishlist");
		
		
		
		
		
		return null;
	}
	
}
