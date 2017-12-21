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
import br.com.assertsistemas.practice.deltaspike.entity.Teacher;
import br.com.assertsistemas.practice.deltaspike.entity.User;

@Repository (forEntity = Teacher.class)
@EntityManagerConfig(entityManagerResolver = AssertSistemasPracticeDeltaSpikePersistenceEMResolver.class)
public abstract class TeacherRepository extends AbstractEntityRepository <Teacher, Long> {

	@Query (named = "Teacher.findByTitle", singleResult = SingleResultType.ANY)
	public abstract Teacher findByTitle(@QueryParam("title") String title);

	@Query (named = "Teacher.findByDiscipline")
	public abstract List<Teacher> findByDiscipline(@QueryParam("discipline") Discipline discipline);
	
	@Query (named = "Teacher.findByUser", singleResult = SingleResultType.ANY)
	public abstract Teacher findByUser(@QueryParam("user") User user);
	
	
	
}
