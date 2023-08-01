package com.stud_Management.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.stud_Management.dto.Student;
import com.stud_Management.factory.ConnectionFactory;
import com.stud_Management.factory.StudentServiceFactory;
import com.stud_Management.service.StudentService;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int sid = 0;
			String sname = "";
			float stmark = 0.0f;
			String saddr = "";
			String status = "";
			Student student = null;
			StudentService studentService = StudentServiceFactory.getStudentService();
			System.out.println("===================================================");
			System.out.println("*******Student Management System********");
			System.out.println("===================================================");
			while (true)
			{
				System.out.println();
				System.out.println("1. ADD Student");
				System.out.println("2. Search Student");
				System.out.println("3. UPDATE Student");
				System.out.println("4. DELETE Student");
				System.out.println("5. EXIT");
				System.out.print("Select from Above OPTION   : ");
				int option = Integer.parseInt(br.readLine());
				
				switch (option)
				{
					case 1:
						System.out.println("You Selected ADD Module");
						System.out.print("Enter Student Id                   : ");
						sid = Integer.parseInt(br.readLine());
						System.out.print("Enter Student Name                 : ");
						sname = br.readLine();
						System.out.print("Enter Student Total marks secured[out of 1000]  : ");
						stmark = Float.parseFloat(br.readLine());
						System.out.print("Enter Student Address              : ");
						saddr = br.readLine();
						
						student = new Student();
						student.setSid(sid);
						student.setSname(sname);
						student.setStmark(stmark);
						student.setSaddr(saddr);
						
						status = studentService.addStudent(student);
						
						if (status.equalsIgnoreCase("Success"))
						{
							System.out.println("Status : Student Added Successfully");
						}
						if (status.equalsIgnoreCase("existed"))
						{
							System.out.println("Status : Student Existed Already");
						}
						if (status.equalsIgnoreCase("Failure"))
						{
							System.out.println("Status : Student Insertion Failure");
						}
						
						break;
					case 2:
						System.out.println("You Selected SEARCH Module");
						System.out.print("Enter Student Id                   : ");
						sid = Integer.parseInt(br.readLine());
						
						student = studentService.searchStudent(sid);
						
						if(student == null)
						{
							System.out.println("\nStatus : Student NOT EXISTED");
						}
						else {
							System.out.println("\nStatus : Student EXISTED");
							System.out.println("Student Details");
							System.out.println("------------------------------");
							System.out.println("Student Id    : "+student.getSid());
							System.out.println("Student Name    : "+student.getSname());
							System.out.println("Student Total Marks Secured    : "+student.getStmark());
							System.out.println("Student Address    : "+student.getSaddr());
						}
						
						break;
					case 3:
						System.out.println("You Selected UPDATE Module");
						System.out.print("Enter Student Id                   : ");
						sid = Integer.parseInt(br.readLine());
						
						student = studentService.searchStudent(sid);
						
						if(student == null)
						{
							System.out.println("\nStatus : Student NOT EXISTED");
						}
						else 
						{
							System.out.print("Student Name [old:"+student.getSname()+"] New : ");
							sname = br.readLine();
							System.out.print("Student Total Mark Secured{out of 1000}[old:"+student.getStmark()+"] New : ");
							stmark = Float.parseFloat(br.readLine());
							System.out.print("Student Address [old:"+student.getSaddr()+"] New : ");
							saddr = br.readLine();
							
							Student newStudent = new Student();
							
							
							newStudent.setSid(sid);
							newStudent.setSname(sname);
							newStudent.setStmark(stmark);
							newStudent.setSaddr(saddr);
							
							status = studentService.updateStudent(newStudent);
							
							if (status.equalsIgnoreCase("Success"))
							{
								System.out.println("Status : Student Updated Successfully");
							}
							if (status.equalsIgnoreCase("failure"))
							{
								System.out.println("Status : Student Updation Failure");
							}
						}
						
						break;
					case 4:
						System.out.println("You Selected DELETE Module");
												
						System.out.print("Enter Student Id                   : ");
						sid = Integer.parseInt(br.readLine());
						
						status = studentService.deleteStudent(sid);
						
						if (status.equalsIgnoreCase("Success"))
						{
							System.out.println("Status : Student DELETED Successfully");
						}
						if (status.equalsIgnoreCase("notexisted"))
						{
							System.out.println("Status : Student NOT Existed");
						}
						if (status.equalsIgnoreCase("Failure"))
						{
							System.out.println("Status : Student Deletion Failure");
						}
						
						break;
					case 5:
						System.out.println("******** THANK YOU for Using STUDENT MANAGEMENT SYSTEM ******");						
						return;
					default:
						System.out.println("INVALID OPTION : Choose between [1,2,3,4 and 5]");
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();	
				ConnectionFactory.getClose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
