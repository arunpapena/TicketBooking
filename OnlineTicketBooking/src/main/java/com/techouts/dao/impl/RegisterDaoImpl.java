package com.techouts.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.techouts.dao.RegisterDao;
import com.techouts.models.Users;


@Repository
public class RegisterDaoImpl implements RegisterDao{

	static JdbcTemplate template;

	public JdbcTemplate gettemplate(){
		return template;
	}
	

	public void settemplate(JdbcTemplate template) {
		RegisterDaoImpl.template = template;
	}

	public void insert(Users user) {
		template.update("insert into techoutstravel(name, email, contact) values (?,?,?)", user.getName().toLowerCase(), user.getEmail().toLowerCase(), user.getContact().toLowerCase());
	}
	
public List<Users> getAllEmployees(){  
	return template.query("select * from techoutstravel",new ResultSetExtractor<List<Users>>(){  
		    public List<Users> extractData(ResultSet rs) throws SQLException {
		        List<Users> list=new ArrayList<Users>();  
		        while(rs.next()){  
		        Users e=new Users();  
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
		List<Users> user=getAllEmployees();
		Iterator<Users> itr=user.iterator();
		List<String> emails=new ArrayList<String>();
		while(itr.hasNext()){
			emails.add(itr.next().getEmail().toLowerCase());
		}
		return emails;}
	
	public List<String> getAllContacts(){
		List<Users> user=getAllEmployees();
		Iterator<Users> itr=user.iterator();
		List<String> contacts=new ArrayList<String>();
		while(itr.hasNext()){
			contacts.add(itr.next().getContact().toLowerCase());
		}
		return contacts;}

	
}
