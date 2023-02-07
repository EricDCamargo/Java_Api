package br.com.project.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.project.api.repository.Repository;
import br.com.project.api.model.Messege;
import br.com.project.api.model.Person;

@org.springframework.stereotype.Service
public class Service {

  @Autowired
  private Messege messege;

  @Autowired
  private Repository action;

  // Register persons method
  public ResponseEntity<?> register(Person obj) {
    if (obj.getName().equals("")) {
      messege.setMessege("O nome precisa ser preenchido");
      return new ResponseEntity<>(messege, HttpStatus.BAD_REQUEST);
    } else if (obj.getAge() < 0) {
      messege.setMessege("Informe uma idade valida");
      return new ResponseEntity<>(messege, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
    }

  }

  // Select persons method
  public ResponseEntity<?> select() {
    return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
  }

  // Select persons through id
  public ResponseEntity<?> selectThroughId(int id) {
    if (action.countById(id) == 0) {
      messege.setMessege("Não foi encontrada nenhuma pessoa.");
      return new ResponseEntity<>(messege, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
    }
  }

  // Data edition method
  public ResponseEntity<?> edit(Person obj) {
    if (action.countById(obj.getId()) == 0) {
      messege.setMessege("O codigo informado não existe");
      return new ResponseEntity<>(messege, HttpStatus.NOT_FOUND);
    } else if (obj.getName().equals("")) {
      messege.setMessege("É necessario informar um nome");
      return new ResponseEntity<>(messege, HttpStatus.BAD_REQUEST);
    } else if (obj.getAge() < 0) {
      messege.setMessege("Informe uma idade válida");
      return new ResponseEntity<>(messege, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
    }
  }

  // Delete elements method
  public ResponseEntity<?> delete(int id) {

    if (action.countById(id) == 0) {
      messege.setMessege("O código informado não existe");
      return new ResponseEntity<>(messege, HttpStatus.NOT_FOUND);
    } else {

      Person obj = action.findById(id);
      action.delete(obj);

      messege.setMessege("Pessoa removida com sucesso!");
      return new ResponseEntity<>(messege, HttpStatus.OK);
    }

  }
}
