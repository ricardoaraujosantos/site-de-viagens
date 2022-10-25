package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Passagem;

public interface PassagemRepository extends JpaRepository <Passagem, Long> {

}
