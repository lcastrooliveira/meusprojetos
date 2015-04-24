package br.com.eits.meusprojetos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

//Lucas

@Entity
@Audited
@Table(name = "authorities")
@DataTransferObject(javascript="Authority")
public class Authority implements Serializable 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8803231432128965715L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	public Authority() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}