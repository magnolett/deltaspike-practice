package br.com.assertsistemas.practice.deltaspike.test;

import javax.inject.Inject;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.com.assertsistemas.practice.deltaspike.dao.StudentRepository;

public class TestStudent {
	
	
	@Inject
	private StudentRepository studentRepository;
	
	@Deprecated
	protected TestStudent(){}
	
	public static void main(String[] args) {
		final Weld weld = new Weld();
		final WeldContainer container = weld.initialize();
		
		final RequestContext requestContext = container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
		requestContext.activate();
	}

}
