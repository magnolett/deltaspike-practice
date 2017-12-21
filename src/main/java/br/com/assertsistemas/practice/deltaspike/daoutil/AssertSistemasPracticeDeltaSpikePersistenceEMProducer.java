package br.com.assertsistemas.practice.deltaspike.daoutil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ApplicationScoped
public class AssertSistemasPracticeDeltaSpikePersistenceEMProducer {

    @Inject
    @AssertSistemasPracticeDeltaSpikePersistence
    private EntityManagerFactory emf;

    @Produces
    @AssertSistemasPracticeDeltaSpikePersistence
    @RequestScoped
    protected EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    protected void closeEntityManager( @Disposes @AssertSistemasPracticeDeltaSpikePersistence EntityManager entityManager ) {
        if ( entityManager.isOpen() ) {
            entityManager.close();
        }
    }

}
