package com.pdv.model;

import org.hibernate.validator.constraints.NotBlank;

import com.pdv.validation.SKU;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String nome;
    
    @NotBlank @SKU
    @Column(nullable = false, length = 20, unique = true)
    private String sku;
    
    @NotNull(message = "é obrigatório")
    @Column(name = "valor_unitario",nullable = false,precision = 10,scale = 2)
    private BigDecimal valorUnitario;
    
    @NotNull  @Min(0)  @Max(value=9999, message = "tem um valor muito alto")
    @Column(name="quantidade_estoque", nullable = false, length = 5)
    private Integer quantidadeEstoque;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(sku, produto.sku) && Objects.equals(valorUnitario, produto.valorUnitario) && Objects.equals(quantidadeEstoque, produto.quantidadeEstoque) && Objects.equals(categoria, produto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
