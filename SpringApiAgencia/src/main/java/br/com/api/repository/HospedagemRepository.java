package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Hospedagem;

public interface HospedagemRepository extends JpaRepository <Hospedagem, Long> {

}
