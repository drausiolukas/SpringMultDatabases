package com.projetodb.MultDatasources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodb.MultDatasources.entity.mysql.Cliente;
import com.projetodb.MultDatasources.repository.mysql.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	

}
