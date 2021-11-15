package com.soda.order.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.soda.order.model.dao.PaymentDao;
import com.soda.order.model.vo.Payment;

public class PaymentService {
	
	private PaymentDao paymentDao = new PaymentDao();

	// 결제 insert
	public int payInsert(Payment payment) {
		Connection conn = getConnection();
		
		// 결제 후 lesson_member 테이블 insert
		int lessonMember = paymentDao.lessonMemberInsert(conn, payment);
		// 결제 후 payment 테이블 insert
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

	
	

}
