package com.vinhtran.dao;

import java.util.List;

import com.vinhtran.model.Student;

public interface StudentDAO {

	public void addStudent(Student student);
	
	public Student updateStudent(Student student);

	public void deleteStudent(Integer studentId);
	
	public Student getStudent(Integer studentId);
	
	public List<Student> getAllStudents();
}
