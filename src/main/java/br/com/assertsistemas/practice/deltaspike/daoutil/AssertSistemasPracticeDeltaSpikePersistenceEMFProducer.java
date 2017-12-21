package br.com.assertsistemas.practice.deltaspike.daoutil;

import static com.google.common.base.Strings.isNullOrEmpty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class AssertSistemasPracticeDeltaSpikePersistenceEMFProducer {

	private static final String PERSISTENCE_UNIT = "ASSERTSISTEMAS_PRACTICE_DELTASPIKE";
	
	@Produces
	@AssertSistemasPracticeDeltaSpikePersistence
	@ApplicationScoped
	public EntityManagerFactory getEntityManagerFactory() {
		if (isNullOrEmpty(PERSISTENCE_UNIT)) {
			throw new Error("There's no Persistence Unit defined for this environment.");
		}
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	public void disposeEntityManagerFactory(@Disposes @AssertSistemasPracticeDeltaSpikePersistence EntityManagerFactory emf) {
		if (emf.isOpen()) {
			emf.close();
		}
	}

}
