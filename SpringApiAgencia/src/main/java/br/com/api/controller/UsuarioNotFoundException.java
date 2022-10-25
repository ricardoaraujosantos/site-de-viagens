package br.com.api.controller;

public class UsuarioNotFoundException extends RuntimeException {
	
	public UsuarioNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }

}
