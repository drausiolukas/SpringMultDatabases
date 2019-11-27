package com.projetodb.MultDatasources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodb.MultDatasources.entity.postgresql.PostgreSQLCliente;
import com.projetodb.MultDatasources.service.PostgreSQLClienteService;

/**
 * 
 * @author Drausio
 * @since 20-09-2019
 * @apiNote nada
 *
 */
@RestController
@RequestMapping(value="/postgres")
public class PostgreSQLController {
	
	@Autowired
	private PostgreSQLClienteService clienteService;
	
	/**
	 * @see Este endpoint mostra todos os clientes
	 * @param null 
	 * @return User
	 */
	@RequestMapping(value="/cliente")
	public ResponseEntity<List<PostgreSQLCliente>> findAll(){
		List<PostgreSQLCliente> personList = clienteService.findAll();
		return ResponseEntity.ok().body(personList);
	}


}
