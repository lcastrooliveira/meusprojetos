package br.com.eits.meusprojetos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;


@Entity
@Audited
@Table(name="users")
@DataTransferObject(javascript="User")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -213084328955666067L;

	@Id
	@Column(name="username")
	private String username;	
		
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name="email")
	private String email;
		
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}