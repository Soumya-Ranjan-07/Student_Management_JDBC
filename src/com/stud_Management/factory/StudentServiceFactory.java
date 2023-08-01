package com.stud_Management.factory;

import com.stud_Management.service.StudentService;
import com.stud_Management.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	static
	{
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService()
	{
		return studentService;
	}
}
