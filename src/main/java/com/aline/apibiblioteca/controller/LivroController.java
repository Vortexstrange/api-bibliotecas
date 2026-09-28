package com.aline.apibiblioteca.controller;

import com.aline.apibiblioteca.model.Livro;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.aline.apibiblioteca.servise.LivroService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
   private LivroService livroService;

    @GetMapping
    public List<Livro> listarTodos()
    {return livroService.listarTodos();
    }
    @PostMapping
    public Livro salvar(@Valid @RequestBody Livro livro) {
        return livroService.salvar(livro);
    }
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Integer id) {
        return livroService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        livroService.excluir(id);
    }
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Integer id, @Valid @RequestBody Livro livro){
        return livroService.atualizar(id,livro);
    }
}
