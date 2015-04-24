package meusprojetos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import br.com.eits.meusprojetos.model.Atividade;
import br.com.eits.meusprojetos.model.Authority;
import br.com.eits.meusprojetos.model.Projeto;
import br.com.eits.meusprojetos.model.User;
import br.com.eits.meusprojetos.service.ProjetoService;
import br.com.eits.meusprojetos.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/test-services-config.xml" })
public class ServicesTest {
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private UserService userService;

	@Test
	public void helloWorldTest() {
		String hello = "hello world";
	}
	
	@Test
	public void addProjectMustPass() {
		Projeto projeto = new Projeto();
		projeto.setNomeProjeto("Projeto 3");
		projeto.setResponsavel("fernando");		
		Atividade atividade = new Atividade();
		atividade.setResponsavel("fernando");
		atividade.setDescricao("comer pizza");
		
		List<Atividade> atividades = new ArrayList<Atividade>();
		
		atividades.add(atividade);
		projeto.setAtividade(atividades);
		
		Projeto novoProjeto = projetoService.add(projeto);
	}
	
	@Test
	public void addAtividadeMustPass() {
		Projeto projeto = projetoService.findById(3L);
		Atividade atividade = new Atividade();
		atividade.setResponsavel("fernando");
		atividade.setDescricao("comer X bacon");
		
		List<Atividade> atividades = projeto.getAtividade();
		
		atividades.add(atividade);
		Projeto novoProjeto = projetoService.edit(projeto);
		System.out.println("tamanho: "+novoProjeto.getAtividade().size());
	}
	
	@Test
	public void addUserMustPass() {
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("lucas.oliveira@eits.com.br");
		admin.setEnabled(true);
		
		Authority authAdmin = new Authority();
		Authority authUser = new Authority();
		authAdmin.setAuthority("ROLE_ADMIN");
		authAdmin.setUser(admin);
		
		authUser.setAuthority("ROLE_USER");
		authUser.setUser(admin);
		
		List<Authority> roles = new ArrayList<Authority>();
		roles.add(authAdmin);
		roles.add(authUser);
		
		User newUser = userService.addUserAndRole(admin,roles);
		Assert.notNull(newUser, "Usuario nulo");
	}
	
}
