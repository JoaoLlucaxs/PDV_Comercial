package com.pdv.model;

import com.pdv.enums.FormaPagamento;
import com.pdv.enums.StatusPedido;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao",nullable = false)
    private Date dataCriacao;
    
   
    @Column(columnDefinition = "text")
    private String observacao;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_entrega",nullable = false)
    private Date dataEntrega;
    
    @NotNull
    @Column(name = "valor_frete",nullable = false,precision = 10,scale = 2)
    private BigDecimal valorFrete;
    
    @NotNull
    @Column(name = "valor_desconto",nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDesconto;
    
    @NotNull
    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusPedido status;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false, length = 20)
    private FormaPagamento formaPagamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Usuario vendedor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @Embedded
    private EnderecoEntrega enderecoEntrega;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemPedido> itens=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
