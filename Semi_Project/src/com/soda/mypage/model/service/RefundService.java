package com.soda.mypage.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.soda.magazine.model.vo.MagazineFile;
import com.soda.mypage.model.dao.ProfileDao;
import com.soda.mypage.model.dao.RefundDao;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;
import com.soda.mypage.model.vo.Refund;

public class RefundService {

	private RefundDao refundDao = new RefundDao();

	// 환불 정보 입력
	public Refund insertRefundInfo(Refund refund) {
		Connection conn = getConnection();
		
		int result = refundDao.insertRefundInfo(conn, refund);
		
		if(result > 0) {
						commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	




	

}

