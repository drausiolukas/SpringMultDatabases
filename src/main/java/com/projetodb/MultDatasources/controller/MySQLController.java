package com.projetodb.MultDatasources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodb.MultDatasources.entity.mysql.Cliente;
import com.projetodb.MultDatasources.service.ClienteService;
/**
 * 
 * @author Drausio
 * @since 20-09-2019
 * @apiNote nada
 *
 */
@RestController
@RequestMapping(value="/cliente")
public class MySQLController {
	
	@Autowired
	private ClienteService clienteService;
	
	/**
	 * @see Este endpoint mostra todos os clientes
	 * @param null 
	 * @return User
	 */
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> personList = clienteService.findAll();
		return ResponseEntity.ok().body(personList);
	}


}
