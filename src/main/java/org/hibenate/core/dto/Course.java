package org.hibenate.core.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	private String courseName;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Collection<Student> students= new ArrayList<Student>();
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	
	
	
	
	

}
