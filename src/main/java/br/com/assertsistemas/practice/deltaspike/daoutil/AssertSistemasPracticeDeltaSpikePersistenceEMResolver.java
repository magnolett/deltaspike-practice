package br.com.assertsistemas.practice.deltaspike.daoutil;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.data.api.EntityManagerResolver;

public class AssertSistemasPracticeDeltaSpikePersistenceEMResolver implements EntityManagerResolver {

	@Inject
	@AssertSistemasPracticeDeltaSpikePersistence
	private EntityManager entityManager;

	public EntityManager resolveEntityManager() {
		return entityManager;
	}

}
