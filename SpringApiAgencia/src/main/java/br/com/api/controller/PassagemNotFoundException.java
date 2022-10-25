package br.com.api.controller;

public class PassagemNotFoundException extends RuntimeException {
	
	public PassagemNotFoundException(Long id){
	        super("Could not found the user with id "+ id);
	    }

}
