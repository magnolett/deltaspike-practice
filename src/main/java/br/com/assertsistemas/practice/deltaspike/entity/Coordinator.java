package br.com.assertsistemas.practice.deltaspike.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "tb_coordinator")
@NamedQueries ({
	@NamedQuery (name = "Coordinator.findByUser", query = "SELECT c FROM Coordinator c WHERE c.user = :user")
})
public class Coordinator extends Person {

	
}
