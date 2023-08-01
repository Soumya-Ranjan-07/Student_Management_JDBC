package com.stud_Management.service;

import com.stud_Management.dto.Student;

public interface StudentService {
	public String addStudent(Student student);
	public Student searchStudent(int sid);
	public String updateStudent(Student student);
	public String deleteStudent(int sid);
}
