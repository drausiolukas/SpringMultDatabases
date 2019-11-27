package com.projetodb.MultDatasources.repository.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetodb.MultDatasources.entity.postgresql.PostgreSQLCliente;
	
@Repository
public interface PostgreSQLClienteRepository extends JpaRepository<PostgreSQLCliente, Long>{
	 
	 
}
