package br.com.poc.api.repository;
import java.util.List;

import br.com.poc.api.entity.Cliente;
 
interface CustomTodoRepository {
 
    List<Cliente> findBySearchTerm(String searchTerm);
}