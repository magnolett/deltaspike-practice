package br.com.assertsistemas.practice.deltaspike.dao;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import br.com.assertsistemas.practice.deltaspike.daoutil.AssertSistemasPracticeDeltaSpikePersistenceEMResolver;
import br.com.assertsistemas.practice.deltaspike.entity.Coordinator;
import br.com.assertsistemas.practice.deltaspike.entity.User;

@Repository (forEntity = Coordinator.class)
@EntityManagerConfig(entityManagerResolver = AssertSistemasPracticeDeltaSpikePersistenceEMResolver.class)
public abstract class CoordinatorRepository extends AbstractEntityRepository <Coordinator, Long>{

	@Query (named = "Coordinator.findByUser", singleResult = SingleResultType.ANY)
	public abstract Coordinator findByUser(@QueryParam ("user") User user);
	
}
