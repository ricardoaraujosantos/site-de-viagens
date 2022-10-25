package br.com.api.controller;


public class HospedagemNotFoundException extends RuntimeException {
	
	 public HospedagemNotFoundException(Long id){
	        super("Could not found the user with id "+ id);
	    }
}
