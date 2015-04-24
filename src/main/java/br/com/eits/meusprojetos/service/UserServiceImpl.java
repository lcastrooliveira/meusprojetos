package br.com.eits.meusprojetos.service;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eits.meusprojetos.model.Authority;
import br.com.eits.meusprojetos.model.User;
import br.com.eits.meusprojetos.repository.AuthorityRepository;
import br.com.eits.meusprojetos.repository.UserRepository;

@Service
@Transactional
@RemoteProxy(name="userService")
public class UserServiceImpl implements UserService {

	private static String EMAIL_FAKE = "eits_fake@yahoo.com.br";
	private static String EMAIL_PASSWORD_FAKE = "fakefakefake";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.UserService#addUser(br.com.eits.meusprojetos.model.User)
	 */
	@Override
	public User addUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		return userRepository.save(user);
	}
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public void removeUser(String userName) {
		authorityRepository.removeAuthoritiesbyUsername(userName);
		userRepository.delete(userName);
	}
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.UserService#updateUser(br.com.eits.meusprojetos.model.User)
	 */
	@Override
	public User updateUser(User user,List<Authority> roles) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		authorityRepository.removeAuthoritiesbyUsername(user.getUsername());
		authorityRepository.save(roles);
		return userRepository.save(user);
	}
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.UserService#findaAll()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<User> findaAll() {
		return userRepository.findAll();
	}

	@Override
	public User addUserAndRole(User user, List<Authority> roles) {
		try {
			User newUser = this.addUser(user);
			authorityRepository.save(roles);
			Thread notificacaoThread = new Thread(new NotificacaoRunnable(newUser));
			notificacaoThread.start();
			return newUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findOne(username);
	}

	@Override
	public List<Authority> findRolesByUsername(String username) {
		return authorityRepository.findAllRolesByUsername(username);
	}
	
	class NotificacaoRunnable implements Runnable {

		private User user;
		
		private void notificarUsuario() {
			try {
				SimpleEmail email = new SimpleEmail();

				try {
					email.setHostName("smtp.googlemail.com");
					email.setSmtpPort(465);
					email.setAuthenticator(new DefaultAuthenticator("postmastereits@gmail.com", "12441212"));
					email.setSSLOnConnect(true);
					email.setFrom("postmastereits@gmail.com");
					email.setSubject("Sistema de Cadastro de Projetos");
					email.setMsg("Teste Email Desafio Cadastro Projetos");
					email.addTo(user.getEmail());
					email.send();
				} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public NotificacaoRunnable(User user) {
			this.user = user;
		}
		
		@Override
		public void run() {
			this.notificarUsuario();
		}
		
	}
}
