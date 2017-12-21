package br.com.assertsistemas.practice.deltaspike.test;

import java.util.List;

import javax.inject.Inject;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.com.assertsistemas.practice.deltaspike.dao.UserRepository;
import br.com.assertsistemas.practice.deltaspike.entity.User;

public class TestUser {

	@Inject
	private UserRepository userRepository;
	
	@Deprecated
	protected TestUser(){}
	
	public static void main(String[] args) {
		final Weld weld = new Weld();
		final WeldContainer container = weld.initialize();

		final RequestContext requestContext = container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
		requestContext.activate();

		final TestUser testUser = container.instance().select(TestUser.class).get();
		final User user = new User();
		user.setLogin("marcosss");
		user.setPassword("1234567890");
		
		final User registeredUser = testUser.userRepository.saveAndFlush(user);
		System.out.println("Cadastrado: " + registeredUser.getId());
		
		registeredUser.setLogin("marcos_");
		
		final User updatedUser = testUser.userRepository.saveAndFlush(registeredUser);
		System.out.println("Alterado: " + updatedUser.getId());
		
		final String login =  updatedUser.getLogin();
		final String password = registeredUser.getPassword();
		
		final User authenticatedUser = testUser.userRepository.autentication(login, password);
		System.out.println("Autenticado" + authenticatedUser.getId());

		final Long id = 03l;
		final User userById = testUser.userRepository.findBy(id);
		System.out.println("findById: " + userById.getId());
		
		final String loginFilter = "%ma%";
		final List<User> userFilterByLogin = testUser.userRepository.filterByLogin(loginFilter);
		System.out.println("usuarioFilterByLogin: " + userFilterByLogin.size());
		
		final List<User> users = testUser.userRepository.findAll();
		users.forEach(u ->{
			final StringBuilder writer = new StringBuilder();
			
			System.out.println("Com StringBuilder");
			writer.append("Id:");
			writer.append(u.getId());
			writer.append("Login");
			writer.append(u.getLogin());
			writer.append("Senha");
			writer.append(u.getPassword());
			System.out.println(writer.toString());
			System.out.println("---------------------");
			
			System.out.println("Com Format");
			final String formatUser = String.format("Id:%s - Login: %s - Senha: %s", u.getId(), u.getLogin(), u.getPassword());
			System.out.println(formatUser);
			System.out.println("---------------------");
		}); 
		
		System.out.println();
	}
	
}