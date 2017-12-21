package br.com.assertsistemas.practice.deltaspike.dao;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import br.com.assertsistemas.practice.deltaspike.daoutil.AssertSistemasPracticeDeltaSpikePersistenceEMResolver;
import br.com.assertsistemas.practice.deltaspike.entity.Coordinator;
import br.com.assertsistemas.practice.deltaspike.entity.Course;
import br.com.assertsistemas.practice.deltaspike.entity.Discipline;

@Repository (forEntity = Course.class)
@EntityManagerConfig(entityManagerResolver = AssertSistemasPracticeDeltaSpikePersistenceEMResolver.class)
public abstract class CourseRepository extends AbstractEntityRepository <Course, Long> {

	@Query (named = "Course.findByName", singleResult = SingleResultType.ANY)
	public abstract Course findByName(@QueryParam("name") String name);

	@Query (named = "Course.findByCoordinator")
	public abstract Course findByCoordinator(@QueryParam("coordinator") Coordinator coordinator);
	
	@Query (named = "Course.findByDiscipline")
	public abstract Course findByDiscipline(@QueryParam("discipline") Discipline discipline);
	
}
