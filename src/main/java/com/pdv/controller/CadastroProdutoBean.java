package com.pdv.controller;

import com.pdv.model.Produto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class CadastroProdutoBean implements Serializable {
    private static final long serialVersionUID=1L;
    @Inject
    private Produto produto;

    public CadastroProdutoBean(){
        produto=new Produto();
    }
    public void salvar() {

    }

    public Produto getProduto() {
        return produto;
    }
}
