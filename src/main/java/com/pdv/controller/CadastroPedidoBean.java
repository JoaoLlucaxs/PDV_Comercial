package com.pdv.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pdv.model.EnderecoEntrega;
import com.pdv.model.Pedido;


@Named(value = "cadastroPedidoBean")
@ViewScoped
public class CadastroPedidoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Pedido pedido;
	
	private List<Integer> itens;
	
	public CadastroPedidoBean() {
		pedido=new Pedido();
		
		
		itens=new ArrayList<Integer>();
		itens.add(1);
	}
	
	public void salvar() {
		
	}

	public Pedido getPedido() {
		return pedido;
	}

	public List<Integer> getItens() {
		return itens;
	}
	
}
