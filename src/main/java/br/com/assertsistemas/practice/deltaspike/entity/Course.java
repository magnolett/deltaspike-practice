package br.com.assertsistemas.practice.deltaspike.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tb_course")
@NamedQueries ({
	@NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
	@NamedQuery(name = "Course.findByCoordinator", query = "SELECT c FROM Course c WHERE c.coordinator = :coordinator"),
	@NamedQuery(name = "Course.findByDiscipline", query = "SELECT c FROM Course as c JOIN FETCH c.disciplines WHERE c.disciplines = :discipline") 
})
public class Course {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "COORDINATOR")
	private Coordinator coordinator;
	
	@Column (name = "NAME")
	private String name;
	
	@OneToMany
	@JoinColumn (name = "DISCIPLINES")
	private List<Discipline> disciplines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
	
	
	
}
