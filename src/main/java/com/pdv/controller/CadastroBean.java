package com.pdv.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroBean {
	
	public void salvar() {
		throw new RuntimeException("Teste de exceção");
	}
	
	
}
