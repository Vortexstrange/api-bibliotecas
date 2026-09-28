package com.aline.apibiblioteca.servise;

import com.aline.apibiblioteca.model.Livro;
import com.aline.apibiblioteca.exception.LivroNaoEncontradoException;
import com.aline.apibiblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro buscarPorId(Integer id){
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado"));
    }

    public void excluir(Integer id) {

        if (!livroRepository.existsById(id)) {
            throw new LivroNaoEncontradoException("Livro não encontrado");
        }

        livroRepository.deleteById(id);
    }
    public Livro atualizar(Integer id, Livro livro) {
        livro.setId(id);
        return livroRepository.save(livro);
    }
}
