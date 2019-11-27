package com.projetodb.MultDatasources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodb.MultDatasources.entity.postgresql.PostgreSQLCliente;
import com.projetodb.MultDatasources.repository.postgresql.PostgreSQLClienteRepository;

@Service
public class PostgreSQLClienteService {

	@Autowired
	private PostgreSQLClienteRepository clienteRepository;

	public List<PostgreSQLCliente> findAll() {
		return clienteRepository.findAll();
	}

	

}
