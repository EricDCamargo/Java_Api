package br.com.project.api.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.api.model.Person;
import br.com.project.api.repository.Repository;

@RestController
public class Control {

    @Autowired
    private Repository action;

    @PostMapping("/api")
    public Person cadastrar(@RequestBody Person obj) {
        return action.save(obj);
    }

    @GetMapping("/api")
    public List<Person> selecionar() {
        return action.findAll();
    }

    @GetMapping("/api/{id}")
    public Person selectById(@PathVariable int id) {
        return action.findById(id);
    }

    @PutMapping("/api")
    public Person edit(@RequestBody Person obj) {
        return action.save(obj);
    }

    @DeleteMapping("/api/{id}")
    public void delete(@PathVariable int id) {
        Person obj = selectById(id);

        action.delete(obj);
    }

    @GetMapping("")
    public String messege() {
        return "Hello World!";
    }

    @GetMapping("/beWellcome")
    public String beWellcome() {
        return "Be wellcome!";
    }

    @GetMapping("/beWellcome/{nome}")
    public String beWellcome(@PathVariable String nome) {
        return "Be wellcome! " + nome + "!";
    }

    @PostMapping("/person")
    public Person person(@RequestBody Person p) {
        return p;
    }

}
