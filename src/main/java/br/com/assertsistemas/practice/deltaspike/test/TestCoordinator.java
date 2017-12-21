package br.com.assertsistemas.practice.deltaspike.test;

import javax.inject.Inject;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.com.assertsistemas.practice.deltaspike.dao.CoordinatorRepository;
import br.com.assertsistemas.practice.deltaspike.entity.Coordinator;

public class TestCoordinator {

	
	@Inject
	private CoordinatorRepository coordinatorRepository;
	
	@Deprecated
	protected TestCoordinator(){}
	
	public static void main(String[] args) {
		final Weld weld = new Weld();
		final WeldContainer container = weld.initialize();
		
		final RequestContext requestContext = container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
		requestContext.activate();
		
		final TestCoordinator testCoordinator = container.instance().select(TestCoordinator.class).get();
		
		final Coordinator coordinator = new Coordinator();
		coordinator.setAge(20);
		coordinator.setGender('M');
		coordinator.setName("Marco");
		
		final Coordinator registeredCoordinator = testCoordinator.coordinatorRepository.saveAndFlush(coordinator);
		System.out.println("Cadastrado: " + registeredCoordinator.getId());
		
		
	}
}
