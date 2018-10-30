package com.techouts.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.techouts.techoutstravel.dao.RegisterDao;
import com.techouts.techoutstravel.model.User;


@Repository
public class RegisterDaoImpl implements RegisterDao{

	static JdbcTemplate template;

	public JdbcTemplate gettemplate(){
		return template;
	}
	

	public void settemplate(JdbcTemplate template) {
		RegisterDaoImpl.template = template;
	}

	public void insert(User user) {
		template.update("insert into techoutstravel(name, email, contact) values (?,?,?)", user.getName().toLowerCase(), user.getEmail().toLowerCase(), user.getContact().toLowerCase());
	}
	
public List<User> getAllEmployees(){  
	return template.query("select * from techoutstravel",new ResultSetExtractor<List<User>>(){  
		    public List<User> extractData(ResultSet rs) throws SQLException {
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User e=new User();  
		        e.setName(rs.getString(1));  
		        e.setEmail(rs.getString(2));  
		        e.setContact(rs.getString(3));  
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  }  
	public List<String> getAllEmails(){
		List<User> user=getAllEmployees();
		Iterator<User> itr=user.iterator();
		List<String> emails=new ArrayList<String>();
		while(itr.hasNext()){
			emails.add(itr.next().getEmail().toLowerCase());
		}
		return emails;}
	
	public List<String> getAllContacts(){
		List<User> user=getAllEmployees();
		Iterator<User> itr=user.iterator();
		List<String> contacts=new ArrayList<String>();
		while(itr.hasNext()){
			contacts.add(itr.next().getContact().toLowerCase());
		}
		return contacts;}

	
}
