package com.stud_Management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.stud_Management.dto.Student;
import com.stud_Management.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		String status = "";
		
		try {
			Connection con = ConnectionFactory.getConObj();
			Statement st = con.createStatement();
			Student std = search(student.getSid());
			if(std == null)
			{
				String query="";
				query = query+String.format("insert into student values(%s,'%s',%s,'%s')",student.getSid(),student.getSname(),student.getStmark(),student.getSaddr());
				int rowCount = st.executeUpdate(query);
				if (rowCount ==1)
				{
					status = "success";
				}
				else {
					status = "failure";
				}				
			}
			else {
				status = "Existed";
			}
			
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(int sid) {
		Student student = null;
		try {
			Connection con = ConnectionFactory.getConObj();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from student where Sid = "+sid);
			boolean b = rs.next();
			
			if (b)
			{
				student = new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setStmark(rs.getFloat(3));
				student.setSaddr(rs.getString(4));
			}
			else
			{
				student = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		String status = "";
		
		try {
			Connection con = ConnectionFactory.getConObj();
			Statement st = con.createStatement();
			String query="";
			query = query+String.format("Update student set sname = '%s', stmark = %s, saddr = '%s' where sid = %s",student.getSname(),student.getStmark(),student.getSaddr(),student.getSid());
			int rowCount = st.executeUpdate(query);
			
			if (rowCount ==1)
			{
				status = "success";
			}
			else {
				status = "failure";
			}
		}
		catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int sid) {
		String status = "";
		
		try {
			Connection con = ConnectionFactory.getConObj();
			Statement st = con.createStatement();			
			Student student = search(sid);
			if(student == null)
			{
				status = "NotExisted";
			}
			else
			{
				int rowCount = st.executeUpdate("Delete from student where SID = "+sid);
				if (rowCount == 1)
				{
					status="Success";
				}
				else
					status="failure";
			}	
		}
		catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}		
		return status;
	}

}
