package com.techouts.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.techouts.dao.ForgotPassword;
import com.techouts.models.ForgotPasswordDetails;



@Repository
public class ForgotPasswordImplimentation implements ForgotPassword {
	static JdbcTemplate template;
	
	public JdbcTemplate gettemplate(){
		return template;
	}
	
	public void settemplate(JdbcTemplate template) {
		ForgotPasswordImplimentation.template = template;
	}

	public void insert(ForgotPasswordDetails forgotPasswordDetails) {
		template.update("insert into forgotpassword(email, contact) values (?,?)", forgotPasswordDetails.getEmail().toLowerCase(), forgotPasswordDetails.getContact().toLowerCase());
	}

	public List<ForgotPasswordDetails> getAllEmployees(){  
		return template.query("select * from forgotpassword",new ResultSetExtractor<List<ForgotPasswordDetails>>(){  
			    public List<ForgotPasswordDetails> extractData(ResultSet rs) throws SQLException{  
			        List<ForgotPasswordDetails> list=new ArrayList<ForgotPasswordDetails>();  
			        while(rs.next()){  
			        ForgotPasswordDetails e=new ForgotPasswordDetails();  
			        e.setEmail(rs.getString(1));  
			        e.setContact(rs.getString(2));  
			        list.add(e);  
			        }  	 
			        return list;  
			        }  
			    });  
			  }
	
	public List<String> getAllEmails() {
		List<ForgotPasswordDetails> user=getAllEmployees();
		Iterator<ForgotPasswordDetails> itr=user.iterator();
		List<String> emails=new ArrayList<String>();
		while(itr.hasNext()){
			emails.add(itr.next().getEmail().toLowerCase());
		}
		return emails;
	}

	public List<String> getAllContacts() {
		List<ForgotPasswordDetails> user=getAllEmployees();
		Iterator<ForgotPasswordDetails> itr=user.iterator();
		List<String> contacts=new ArrayList<String>();
		while(itr.hasNext()){
			contacts.add(itr.next().getContact().toLowerCase());
		}
		return contacts;
	}

}
