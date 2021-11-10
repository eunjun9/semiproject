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
			commit(conn);
			result = 1;
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	

}
