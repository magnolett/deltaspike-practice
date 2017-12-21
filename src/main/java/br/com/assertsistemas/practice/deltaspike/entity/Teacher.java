package br.com.assertsistemas.practice.deltaspike.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tb_teacher")
@NamedQueries ({
	@NamedQuery(name = "Teacher.findByTitle", query = "SELECT t FROM Teacher t WHERE t.title = :title"),
	@NamedQuery(name = "Teacher.findByDiscipline", query = "SELECT t FROM Teacher t WHERE t.disciplines = :discipline"),
	@NamedQuery(name = "Teacher.findByUser", query = "SELECT t FROM Teacher t WHERE t.user = :user")
	
})
public class Teacher extends Person {

	@Column (name = "TITLE")
	private String title;

	@OneToMany
	@JoinColumn (name = "DISCIPLINES")
	private List<Discipline> disciplines;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Discipline> getDiscipline() {
		return disciplines;
	}

	public void setDiscipline(List<Discipline> discipline) {
		this.disciplines = discipline;
	}
	
	
}
