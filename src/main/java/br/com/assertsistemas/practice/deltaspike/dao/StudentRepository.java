package br.com.assertsistemas.practice.deltaspike.dao;

import java.util.List;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import br.com.assertsistemas.practice.deltaspike.daoutil.AssertSistemasPracticeDeltaSpikePersistenceEMResolver;
import br.com.assertsistemas.practice.deltaspike.entity.Discipline;
import br.com.assertsistemas.practice.deltaspike.entity.Student;
import br.com.assertsistemas.practice.deltaspike.entity.User;

@Repository (forEntity = Student.class)
@EntityManagerConfig(entityManagerResolver = AssertSistemasPracticeDeltaSpikePersistenceEMResolver.class)
public abstract class StudentRepository extends AbstractEntityRepository <Student, Long>{

	@Query (named = "Student.findByUser", singleResult = SingleResultType.ANY)
	public abstract Student findByUser(@QueryParam("user") User user);
	
	@Query (named = "Student.findByRegistration", singleResult = SingleResultType.ANY)
	public abstract Student findByRegistration(@QueryParam("registration") Long registration);

	@Query (named = "Student.findByDiscipline")
	public abstract List<Student> findByDiscipline(@QueryParam("discipline") Discipline discipline);
	
}
