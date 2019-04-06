package br.com.lvdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lvdc.domain.modelo.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
