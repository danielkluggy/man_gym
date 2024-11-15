package br.udesc.man_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.udesc.man_gym.model.Medida;

public interface VendaRepository extends JpaRepository<Medida, Long> {

}
