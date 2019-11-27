package com.projetodb.MultDatasources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodb.MultDatasources.entity.mysql.MySQLCliente;
import com.projetodb.MultDatasources.repository.mysql.MySQLClienteRepository;

@Service
public class MySQLClienteService {

	@Autowired
	private MySQLClienteRepository clienteRepository;

	public List<MySQLCliente> findAll() {
		return clienteRepository.findAll();
	}

	

}
