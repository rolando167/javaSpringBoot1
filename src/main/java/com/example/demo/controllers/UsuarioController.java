package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario") 
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ArrayList<UserModel> obtenerUsuarios(){
		/* http://localhost:8080/api/usuario */
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping("/save")
	public UserModel guardarUsuario(@RequestBody UserModel usuario){
		/* POST -  http://localhost:8080/api/usuario */
		return this.usuarioService.guardarUsuario(usuario);
	}
	
	/* @GetMapping("/customers/{id}") */
	@GetMapping( path = "/{id}")
	public Optional<UserModel> obtenerUsuariPor(@PathVariable("id") Long id){
		// http://localhost:8080/api/usuario/3
		return this.usuarioService.obtenerPorId(id);
	}
	
	@GetMapping("/query")
	public ArrayList<UserModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		// http://localhost:8080/api/usuario/query?prioridad=6
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	@DeleteMapping( path = "/{id}" )
	public String eliminarPorId(@PathVariable("id") Long id) {
		// http://localhost:8080/api/usuario/5
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "Se eliminó el usaurio con id = " + id;
		}else {
			return "No Pudo eliminar el usaurio con id = " + id;
		}
	}
	
}
