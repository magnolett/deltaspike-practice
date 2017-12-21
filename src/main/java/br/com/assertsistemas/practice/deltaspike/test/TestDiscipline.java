package br.com.assertsistemas.practice.deltaspike.test;

import javax.inject.Inject;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.com.assertsistemas.practice.deltaspike.dao.DisciplineRepository;
import br.com.assertsistemas.practice.deltaspike.entity.Discipline;

public class TestDiscipline {

	
	@Inject
	private DisciplineRepository disciplineRepository;
	
	@Deprecated
	protected TestDiscipline(){}
	
	public static void main(String[] args) {
		final Weld weld = new Weld();
		final WeldContainer container = weld.initialize();
		
		final RequestContext requestContext = container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
		requestContext.activate();
		
		final TestDiscipline testDiscipline= container.instance().select(TestDiscipline.class).get();
		
		
		final Discipline discipline = new Discipline();
		discipline.setCode(9213812l);
		discipline.setName("Português");
		discipline.setWorkload(80.0);
		
		final Discipline registeredDiscipline= testDiscipline.disciplineRepository.saveAndFlush(discipline);
		System.out.println("Cadastrado: " + registeredDiscipline.getId());
	}
}
