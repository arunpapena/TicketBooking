package com.techouts.daoImplTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import org.springframework.jdbc.core.JdbcTemplate;
import com.techouts.dao.impl.UserCredentialsImpl;
import com.techouts.models.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class UserCredentialsImplTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private User user;
	@InjectMocks
	UserCredentialsImpl userCredentialsImpl;
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		userCredentialsImpl = new UserCredentialsImpl();
		
	}
	
	@Test
	public void isUserRegisteredTest(){
		userCredentialsImpl = Mockito.mock(UserCredentialsImpl.class);
		when(userCredentialsImpl.isUserRegistered("dinanathrai94@gmail.com")).thenReturn(true);
		when(userCredentialsImpl.isUserRegistered("")).thenReturn(false);
		when(userCredentialsImpl.isUserRegistered("asd")).thenReturn(false);
		assertEquals(true, userCredentialsImpl.isUserRegistered("dinanathrai94@gmail.com"));
		assertEquals(false, userCredentialsImpl.isUserRegistered(""));
		assertEquals(false, userCredentialsImpl.isUserRegistered("asd"));
		
	}
	
	@Test
	public void getPasswordTest(){
		userCredentialsImpl = Mockito.mock(UserCredentialsImpl.class);
		when(userCredentialsImpl.getPassword("dinanathrai94@gmail.com")).thenReturn("111111");
		when(userCredentialsImpl.getPassword("")).thenReturn("");
		when(userCredentialsImpl.getPassword("asd")).thenReturn("");
		assertEquals("111111", userCredentialsImpl.getPassword("dinanathrai94@gmail.com"));
		assertEquals("", userCredentialsImpl.getPassword(""));
		assertEquals("", userCredentialsImpl.getPassword("asd"));
		
	}
	
	@Test
	public void isNewUserTest(){
		userCredentialsImpl = Mockito.mock(UserCredentialsImpl.class);
		when(userCredentialsImpl.isUserRegistered("dinanathrai94@gmail.com")).thenReturn(false);
		when(userCredentialsImpl.isUserRegistered("")).thenReturn(true);
		when(userCredentialsImpl.isUserRegistered("asd")).thenReturn(true);
		assertEquals(false, userCredentialsImpl.isUserRegistered("dinanathrai94@gmail.com"));
		assertEquals(true, userCredentialsImpl.isUserRegistered(""));
		assertEquals(true, userCredentialsImpl.isUserRegistered("asd"));
	}
	
	@Test
	public void getUserDetailsTest(){
		userCredentialsImpl = Mockito.mock(UserCredentialsImpl.class);
		when(userCredentialsImpl.getUserDetails("dinanathrai94@gmail.com")).thenReturn(new User());
		when(userCredentialsImpl.getUserDetails("")).thenReturn(null);
		when(userCredentialsImpl.getUserDetails("asd")).thenReturn(null);
		assertNotNull(userCredentialsImpl.getUserDetails("dinanathrai94@gmail.com"));
		assertNull(userCredentialsImpl.getUserDetails(""));
		assertNull(userCredentialsImpl.getUserDetails("asd"));
	}
	
	@Test
	public void updateFlagTest(){
		userCredentialsImpl = Mockito.mock(UserCredentialsImpl.class);
		doNothing().when(userCredentialsImpl).updateFlag("111111", "dinanathrai94@gmail.com");
		userCredentialsImpl.updateFlag("111111", "dinanathrai94@gmail.com");
		verify(userCredentialsImpl, times(1)).updateFlag("111111", "dinanathrai94@gmail.com");
	}
	
	@Test
	public void updateUserDetailsTest(){
		userCredentialsImpl = Mockito.mock(UserCredentialsImpl.class);
		doNothing().when(userCredentialsImpl).updateUserDetails("Dinanath", "2255448855", "dinanathrai94@gmail.com");
		userCredentialsImpl.updateUserDetails("Dinanath", "2255448855", "dinanathrai94@gmail.com");
		verify(userCredentialsImpl, times(1)).updateUserDetails("Dinanath", "2255448855", "dinanathrai94@gmail.com");
	}

	

}
