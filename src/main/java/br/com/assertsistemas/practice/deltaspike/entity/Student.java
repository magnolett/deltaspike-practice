package br.com.assertsistemas.practice.deltaspike.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "tb_student")
@NamedQueries ({
	@NamedQuery(name = "Student.findByUser", query = "SELECT s FROM Student s WHERE s.user = :user"),
	@NamedQuery(name = "Student.findByRegistration", query = "SELECT s FROM Student s WHERE s.registration = :registration"),
	@NamedQuery(name = "Student.findByDiscipline", query = "SELECT s FROM Student as s JOIN FETCH s.disciplines WHERE s.disciplines = :discipline")
	
})
public class Student extends Person{

	@Column (name = "REGISTRATION", unique = true)
	private Long registration;
	
	@Column (name = "CURRENT_SEMESTER", unique = true)
	private int semester;

	
	@ManyToMany
	private List<Discipline> disciplines;


	public Long getRegistration() {
		return registration;
	}


	public void setRegistration(Long registration) {
		this.registration = registration;
	}


	public int getSemester() {
		return semester;
	}


	public void setSemester(int semester) {
		this.semester = semester;
	}


	public List<Discipline> getDisciplines() {
		return disciplines;
	}


	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	
	
}
