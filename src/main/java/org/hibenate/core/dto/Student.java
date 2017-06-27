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
public class Student {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private String studentName;
	@ManyToMany(mappedBy="students", cascade=CascadeType.PERSIST)
	private Collection<Course> courses = new ArrayList<Course>();
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Collection<Course> getCourse() {
		return courses;
	}
	public void setCourse(Collection<Course> courses) {
		this.courses = courses;
	}
	
	
	

}
