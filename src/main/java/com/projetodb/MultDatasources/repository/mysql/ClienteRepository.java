package com.projetodb.MultDatasources.repository.mysql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodb.MultDatasources.entity.mysql.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	 Optional<Cliente> findByNome(String nome);
	 
}
