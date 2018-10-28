package com.vinhtran.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vinhtran.model.Student;
import com.vinhtran.service.StudentService;

@Controller
public class StudentController {
	
    private static final Logger logger = Logger
            .getLogger(StudentController.class);

	public StudentController() {
		System.out.println("--------------------StudentController--------------------");
	}
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/")
	private ModelAndView studentList(ModelAndView model){
		
		List<Student> studentList = studentService.getAllStudents();
		model.addObject("studentList",studentList);
		model.setViewName("list");	
		return model;
	}
	
	@RequestMapping(value = "/newStudent")
	private ModelAndView newStudent(ModelAndView model){

		Student student = new Student();
		model.addObject("student",student);
		model.setViewName("detail");

		return model;
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	private ModelAndView editStudent(HttpServletRequest request){

		int studentId = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.getStudent(studentId);
		
		ModelAndView model = new ModelAndView("detail");
		model.addObject(student);
		
		return model;
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	private ModelAndView deleteStudent(HttpServletRequest request){

		int studentId = Integer.parseInt(request.getParameter("id"));
		studentService.deleteStudent(studentId);
		
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	private ModelAndView saveStudent(@ModelAttribute Student student){
		if(student.getId() == 0) {
			studentService.addStudent(student);
		} else {
			studentService.updateStudent(student);
		}
		return new ModelAndView("redirect:/");
	}

}
