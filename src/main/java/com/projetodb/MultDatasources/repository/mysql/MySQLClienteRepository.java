package com.projetodb.MultDatasources.repository.mysql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetodb.MultDatasources.entity.mysql.MySQLCliente;

@Repository
public interface MySQLClienteRepository extends JpaRepository<MySQLCliente, Long>{
	 Optional<MySQLCliente> findByNome(String nome);
	 
}
