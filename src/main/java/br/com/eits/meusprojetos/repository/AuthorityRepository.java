package br.com.eits.meusprojetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.eits.meusprojetos.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	@Query("Select auth.authority from Authority auth where auth.user.username = :username")
	public List<Authority> findAllRolesByUsername(@Param("username") String username);
	
	@Modifying
	@Query("Delete from Authority a where a.user.username = :username")
	public void removeAuthoritiesbyUsername(@Param("username") String username);
}
