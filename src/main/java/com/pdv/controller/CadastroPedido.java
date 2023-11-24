package com.pdv.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.pdv.service.NegocioException;

@Named
@RequestScoped
public class CadastroPedido {
	
	public void salva() {
		throw new NegocioException("Não há como cadastrar pedido");
	}
}
