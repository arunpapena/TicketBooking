package com.tehouts.techoutstravel.mail;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mock;
import com.techouts.techoutstravel.mail.DefaultPasswordFactory;



public class DefaultPasswordFactoryTest {
	@Mock
	static StringBuilder pw;
	
	@Test
	public void testPassword(){
		assertNull(DefaultPasswordFactory.getPw());
		assertNotNull(DefaultPasswordFactory.generateRandomPassword());
		assertNotNull(DefaultPasswordFactory.getPw());
		assertNotSame(DefaultPasswordFactory.getPw(),DefaultPasswordFactory.generateRandomPassword());
		pw=DefaultPasswordFactory.generateRandomPassword();
		assertEquals(DefaultPasswordFactory.getPw(),pw);
	}
	
}
