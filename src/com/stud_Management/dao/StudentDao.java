package com.stud_Management.dao;

import com.stud_Management.dto.Student;

public interface StudentDao {
	public String add(Student student);
	public Student search(int sid);
	public String update(Student student);
	public String delete(int sid);
	
}
