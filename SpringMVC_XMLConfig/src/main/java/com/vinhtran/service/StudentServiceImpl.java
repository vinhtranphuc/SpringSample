package com.vinhtran.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinhtran.dao.StudentDAO;
import com.vinhtran.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDAO.updateStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudent(Integer studentId) {
		studentDAO.deleteStudent(studentId);
	}

	@Override
	public Student getStudent(Integer studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
