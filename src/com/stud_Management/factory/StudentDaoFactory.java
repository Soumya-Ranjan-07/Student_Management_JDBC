package com.stud_Management.factory;

import com.stud_Management.dao.StudentDao;
import com.stud_Management.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDaoImpl studentDao;
	static
	{
		studentDao = new StudentDaoImpl();
	}
	public static StudentDao getStudentDao()
	{
		return studentDao;
	}
}
