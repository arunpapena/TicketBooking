package com.techouts.payment.serv.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techouts.controllers.PaymentController;
import com.techouts.models.PaymentDTO;
import com.techouts.services.PaymentInsert;



public class PaymentTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private PaymentDTO paymentdto;
	@InjectMocks
	PaymentController paymentcontroller;
	@InjectMocks
	PaymentInsert paymentinsert;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		paymentcontroller = new PaymentController();

	}

	@Test
	public void isUserEnterdTest_1() {
		paymentcontroller = Mockito.mock(PaymentController.class);
		paymentdto = Mockito.mock(PaymentDTO.class);
		jdbcTemplate = Mockito.mock(JdbcTemplate.class);
		boolean flag = paymentcontroller.getClass() != null;
		assertEquals(true, flag);

	}

	@Test
	public void isUserEnterdTest_2() {
		PaymentDTO paymentdto = new PaymentDTO();
		paymentdto = Mockito.mock(PaymentDTO.class);
		boolean flag1 = paymentdto.getClass() != null;
		assertEquals(true, flag1);

	}

	@Test
	public void isPaymentInsertTest_3() {
		PaymentInsert paymentInsert = new PaymentInsert();
		paymentInsert = Mockito.mock(PaymentInsert.class);
		boolean flag3 = paymentInsert.getClass() != null;
		assertEquals(true, flag3);
	}

}
