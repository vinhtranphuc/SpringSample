package com.vinhtran.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinhtran.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@Override
	public Student updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return student;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, studentId);
		if(null != student) {
			this.sessionFactory.getCurrentSession().delete(student);
		}
	}

	@Override
	public Student getStudent(Integer studentId) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}
}
