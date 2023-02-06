package br.com.projeto.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repository.Repository;

@RestController
public class Controle {

    @Autowired
    private Repository action;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return action.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return action.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selectById(@PathVariable int codigo) {
        return action.findById(codigo);
    }

    @PutMapping("/api")
    public Pessoa edit(@RequestBody Pessoa obj) {
        return action.save(obj);
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
    public Pessoa person(@RequestBody Pessoa p) {
        return p;
    }

}
