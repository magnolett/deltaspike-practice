package br.com.assertsistemas.practice.deltaspike.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "tb_discipline")
@NamedQueries ({
	@NamedQuery(name = "Discipline.findByCode", query = "SELECT d FROM Discipline d WHERE d.code = :code"),
	@NamedQuery(name = "Discipline.findByTeacher", query = "SELECT d FROM Discipline d WHERE d.teacher = :teacher"),
	@NamedQuery(name = "Discipline.findByCourse", query = "SELECT d FROM Discipline d WHERE d.courses = :course"),
	@NamedQuery(name = "Discipline.findByStudent", query = "SELECT d FROM Discipline as d JOIN FETCH d.students WHERE d.students = :student")
	
	
})
public class Discipline {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	private Long id;
	
	@Column (name = "CODE", unique = true)
	private Long code;
	
	@Column (name = "WORKLOAD")
	private double workload;
	
	@Column (name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn (name = "COURSES")
	private Course courses;
	
	
	@ManyToMany
	@JoinTable(name = "DISCIPLINE_STUDENT", joinColumns = @JoinColumn(name = "discipline_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_Id", referencedColumnName = "id"))
	private List<Student> students;
	
	@ManyToOne
	private Teacher teacher;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public double getWorkload() {
		return workload;
	}


	public void setWorkload(double workload) {
		this.workload = workload;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Course getCourses() {
		return courses;
	}


	public void setCourses(Course courses) {
		this.courses = courses;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
