package com.tehouts.techoutstravel.mail;

import static org.junit.Assert.*;
import java.util.Properties;
import org.junit.Test;
import org.mockito.Mock;
import com.techouts.techoutstravel.mail.PropertiesFactory;


public class PropertiesFactoryTest {
	@Mock
	Properties props=new Properties();

@Test
public void testResult(){
	PropertiesFactory propertiesFactory=new PropertiesFactory();
assertSame(props.getClass().getName(),propertiesFactory.getProperties().getClass().getName());
assertNotNull(propertiesFactory.getProperties());
assertEquals("root",propertiesFactory.getProperties().get("user"));
assertEquals("true",propertiesFactory.getProperties().get("mail.smtp.auth"));
assertEquals("false",propertiesFactory.getProperties().get("useSSL"));
assertEquals("true",propertiesFactory.getProperties().get("autoReconnect"));
assertEquals("true",propertiesFactory.getProperties().get("mail.smtp.starttls.enable"));
assertEquals("smtp.gmail.com",propertiesFactory.getProperties().get("mail.smtp.host"));
assertEquals("587",propertiesFactory.getProperties().get("mail.smtp.port"));
}
}
