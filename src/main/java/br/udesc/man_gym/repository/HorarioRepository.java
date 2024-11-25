package br.udesc.man_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.udesc.man_gym.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
