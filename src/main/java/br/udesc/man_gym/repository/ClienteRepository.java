package br.udesc.man_gym.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.udesc.man_gym.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("select c from Cliente c where email like :email")
	public Cliente buscaPorEmail(@Param("email") String email);

	@Query("select c from Cliente c where nome = :nome")
	public Cliente buscaPorNomeCliente(@Param("nome") String nome);
	
	@Query("select c from Cliente c")
	public List<Cliente> buscarTodos();
	
}
