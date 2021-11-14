package com.soda.order.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.soda.order.model.dao.PaymentDao;
import com.soda.order.model.vo.Payment;

public class PaymentService {
	
	private PaymentDao paymentDao = new PaymentDao();

	public int payInsert(Payment payment) {
		Connection conn = getConnection();
		
		int lessonMember = paymentDao.lessonMemberInsert(conn, payment);
		int payInsert = paymentDao.payInsert(conn, payment);
		int result = 0;
		
		if( lessonMember > 0 && payInsert > 0) {
			// 결제 후 insert까지 완료되면 장바구니에서 동일한 클래스 삭제하기
			paymentDao.wishlistEnd(conn, payment);
			commit(conn);
			result = 1;
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 결제 완료된 클래스 장바구니에서 삭제
//	public int wishlistEnd(Payment payment) {
//		Connection conn = getConnection();
//		
//		int result = paymentDao.wishlistEnd(conn, payment);
//		
//		if(result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		close(conn);
//		
//		return result;
//		
//	}
	
	
	

}
