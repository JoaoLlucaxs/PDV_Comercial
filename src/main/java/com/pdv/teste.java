package com.pdv;

import com.pdv.model.Cliente;
import com.pdv.enums.TipoPessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class teste {
    public static void main(String[] args) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("commercial");
        EntityManager manager=factory.createEntityManager();

        EntityTransaction trx=manager.getTransaction();
        trx.begin();

        Cliente cliente=new Cliente();
        cliente.setNome("João Lucas");
        cliente.setEmail("joao@gmail.com");
        cliente.setDocumentoReceitaFederal("122.122.122-12");
        cliente.setTipoPessoa(TipoPessoa.FISICA);

        System.out.println(cliente.getNome());

        manager.persist(cliente);

        trx.commit();
    }
}
