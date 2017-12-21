package br.com.assertsistemas.practice.deltaspike.dao;

import java.util.List;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import br.com.assertsistemas.practice.deltaspike.daoutil.AssertSistemasPracticeDeltaSpikePersistenceEMResolver;
import br.com.assertsistemas.practice.deltaspike.entity.User;

@Repository (forEntity = User.class)
@EntityManagerConfig(entityManagerResolver = AssertSistemasPracticeDeltaSpikePersistenceEMResolver.class)
public abstract class UserRepository extends AbstractEntityRepository<User, Long> {

	@Query (named = "User.autentication", singleResult = SingleResultType.ANY)
	public abstract User autentication(@QueryParam("login") String login, @QueryParam("password") String password);

	@Query (named = "User.filterByLogin")
	public abstract List<User> filterByLogin(@QueryParam("login") String login);
	
}
