package com.pdv.bean;

import com.pdv.model.Categoria;
import com.pdv.model.Produto;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "cadastroProdutoBean")
@ViewScoped
public class CadastroProdutoBean implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Inject
    private Produto produto;
    
    private List<Categoria> categoriasRaizes;

    public CadastroProdutoBean(){
        produto=new Produto();
    }
    
    public void salvar() {
    	
    }

    public Produto getProduto() {
        return produto;
    }
    		
	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}
    
}
