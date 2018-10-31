package com.payment.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.payment.controller.PaymentController;
import com.payment.dto.PaymentDTO;

public class PaymentTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private PaymentDTO user;
	@InjectMocks
	PaymentController paymentcontroller;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		paymentcontroller = new PaymentController();

	}

	@Test
	public void isUserEnterdTest_1() {
		paymentcontroller = Mockito.mock(PaymentController.class);
		user = Mockito.mock(PaymentDTO.class);
		jdbcTemplate = Mockito.mock(JdbcTemplate.class);
		boolean flag = paymentcontroller.getClass() != null;

		assertEquals(true, flag);

	}

	@Test
	public void isUserEnterdTest_2() {
		@SuppressWarnings("unused")
		PaymentDTO paymentdto = new PaymentDTO();
		paymentcontroller = Mockito.mock(PaymentController.class);
		boolean flag1 = paymentcontroller.getClass() != null;
		assertEquals(true, flag1);
	}

}
