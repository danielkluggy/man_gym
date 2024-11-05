package br.udesc.man_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.udesc.man_gym.model.DobraCutanea;

@Repository
public interface DobraCutaneaRepository extends JpaRepository<DobraCutanea, Long>{
	
	@Query("select d from DobraCutanea d where d.cliente.matricula=:idCliente")
	public DobraCutanea buscaPorAluno(@Param("idCliente") Long idCliente);
}
