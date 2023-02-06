package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.projeto.api.modelo.Pessoa;

public interface Repository extends CrudRepository<Pessoa, Integer> {

  List<Pessoa> findAll();

  Pessoa findById(int codigo);
}
