package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

@Service
public class UsuarioService {
	@Autowired
	UserRepository usuarioRepository;
	
	public ArrayList<UserModel> obtenerUsuarios(){
		return (ArrayList<UserModel>) usuarioRepository.findAll();
	}
	
	public UserModel guardarUsuario(UserModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UserModel> obtenerPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UserModel> obtenerPorPrioridad(Integer prioridad){
		return usuarioRepository.findByPrioridad(prioridad);
	}
	
	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}

}
