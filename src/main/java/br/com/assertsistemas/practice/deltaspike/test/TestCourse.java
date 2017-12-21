package br.com.assertsistemas.practice.deltaspike.test;

import javax.inject.Inject;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.com.assertsistemas.practice.deltaspike.dao.CourseRepository;
import br.com.assertsistemas.practice.deltaspike.entity.Course;

public class TestCourse {

	
	@Inject
	private CourseRepository courseRepository;
	
	@Deprecated
	protected TestCourse(){}
	
	public static void main(String[] args) {
		final Weld weld = new Weld();
		final WeldContainer container = weld.initialize();
		
		final RequestContext requestContext = container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
		requestContext.activate();
		
		final TestCourse testCourse = container.instance().select(TestCourse.class).get();
		
		final Course course = new Course();
		course.setName("Sistemas de Informação");
		
		final Course registeredCourse= testCourse.courseRepository.saveAndFlush(course);
		System.out.println("Cadastrado: " + registeredCourse.getId());
	}
}
