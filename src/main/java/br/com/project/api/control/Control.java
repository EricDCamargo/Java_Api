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

    // It can save a new element in data-base
    @PostMapping("/api")
    public Person cadastrar(@RequestBody Person obj) {
        return action.save(obj);
    }

    // Return all elements that are saved in the data-base
    @GetMapping("/api")
    public List<Person> selecionar() {
        return action.findAll();
    }

    // Search for an especifyed id in data-base
    @GetMapping("/api/{id}")
    public Person selectById(@PathVariable int id) {
        return action.findById(id);
    }

    // It can edit
    @PutMapping("/api")
    public Person edit(@RequestBody Person obj) {
        return action.save(obj);
    }

    // It can delet the infomed id cor the data-base
    @DeleteMapping("/api/{id}")
    public void delete(@PathVariable int id) {
        Person obj = selectById(id);

        action.delete(obj);
    }

    // Search for how much elements are saved in the data-base
    @GetMapping("/api/counter")
    public long counter() {
        return action.count();
    }

    // Search for the name described
    @GetMapping("/api/orderNames")
    public List<Person> orderNames() {
        return action.findByOrderByName();
    }

    // Search for the described name and order them by the age
    @GetMapping("/api/orderNames2")
    public List<Person> orderNames2() {
        return action.findByNameOrderByAge("Luiz");
    }

    // Search for names that conteins the leather or the described term
    @GetMapping("/api/nameContens")
    public List<Person> nameContens() {
        return action.findByNameContaining("e");
    }

    // Search for a name that starts with the describe leather
    @GetMapping("/api/nameStarts")
    public List<Person> initWith() {
        return action.findByNameStartsWith("e");
    }

    // Search for a name that ends with the described leather
    @GetMapping("/api/nameEnds")
    public List<Person> endsWith() {
        return action.findByNameEndsWith("z");
    }

    // Returns the described messsege in port 8080
    @GetMapping("")
    public String messege() {
        return "Hello World!";
    }

    // Returns the described messege
    @GetMapping("/beWellcome")
    public String beWellcome() {
        return "Be wellcome!";
    }

    // Returns the described messe ans the described name in
    @GetMapping("/beWellcome/{name}")
    public String beWellcome(@PathVariable String name) {
        return "Be wellcome! " + name + "!";
    }

    // I still dont knowing what this do :C
    @PostMapping("/person")
    public Person person(@RequestBody Person p) {
        return p;
    }

}
