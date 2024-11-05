package br.udesc.man_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.udesc.man_gym.model.Medida;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Long>{
	
	@Query("select m from Medida m where m.cliente.matricula=:idcliente")
	public Medida buscarMedida(@Param("idcliente")Long idcliente);
	
	
	
}
