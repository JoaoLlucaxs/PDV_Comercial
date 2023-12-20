package com.pdv.controller;

import com.pdv.serviceException.NegocioException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


@ManagedBean
@RequestScoped
public class CadastroPedidoBean {
	
	public void salvar() {
		throw new NegocioException("Não há como cadastrar pedido no momento");
	}
}
