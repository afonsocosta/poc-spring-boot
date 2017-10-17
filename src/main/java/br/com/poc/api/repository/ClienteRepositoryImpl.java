package br.com.poc.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.poc.api.entity.Cliente;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom{

	 @PersistenceContext
	 private EntityManager em;

	 @Override
	 public Cliente customMethod(String nome) {
		 StringBuilder search = new StringBuilder();
		 search.append("select cliente ");
		 search.append(" from ").append(Cliente.class.getName());
		 search.append(" cliente ");
		 search.append(" where cliente.nome = :nome ");
		 
		 Query query = em.createQuery(search.toString());
		 query.setParameter("nome", nome);
		 
		 Cliente cliente = null;
		 
		 try{
			 cliente = (Cliente) query.getSingleResult();
		 }catch (Exception e) {
			 cliente = null;
		}
		 
		 return cliente;
		
	 }
	
	
	
}
