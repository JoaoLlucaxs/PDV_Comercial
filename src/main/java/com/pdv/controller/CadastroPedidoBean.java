package com.pdv.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pdv.model.EnderecoEntrega;
import com.pdv.model.Pedido;
import com.pdv.serviceException.NegocioException;


@Named(value = "cadastroPedidoBean")
@ViewScoped
public class CadastroPedidoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;


	private Pedido pedido;
	
	private List<Integer> itens;
	
	public CadastroPedidoBean() {
		pedido=new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		
		itens=new ArrayList<Integer>();
		itens.add(1);
	}
	
	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo");
	}

	public Pedido getPedido() {
		return pedido;
	}

	public List<Integer> getItens() {
		return itens;
	}

	
}
