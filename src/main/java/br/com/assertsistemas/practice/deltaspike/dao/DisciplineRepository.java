package br.com.assertsistemas.practice.deltaspike.dao;

import java.util.List;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import br.com.assertsistemas.practice.deltaspike.daoutil.AssertSistemasPracticeDeltaSpikePersistenceEMResolver;
import br.com.assertsistemas.practice.deltaspike.entity.Course;
import br.com.assertsistemas.practice.deltaspike.entity.Discipline;
import br.com.assertsistemas.practice.deltaspike.entity.Student;
import br.com.assertsistemas.practice.deltaspike.entity.Teacher;

@Repository (forEntity = Discipline.class)
@EntityManagerConfig(entityManagerResolver = AssertSistemasPracticeDeltaSpikePersistenceEMResolver.class)
public abstract class DisciplineRepository extends AbstractEntityRepository <Discipline, Long>{
	
	@Query (named = "Discipline.findByCode", singleResult = SingleResultType.ANY)
	public abstract Discipline findByCode(@QueryParam("code") Long code);

	@Query (named = "Discipline.findByTeacher", singleResult = SingleResultType.ANY)
	public abstract Discipline findByTeacher(@QueryParam("teacher") Teacher teacher);
	
	@Query (named = "Discipline.findByCourse", singleResult = SingleResultType.ANY)
	public abstract Discipline findByCourse(@QueryParam("course") Course course);

	@Query (named = "Discipline.findByStudent")
	public abstract List<Discipline> findByStudent(@QueryParam("student") Student student);

}
