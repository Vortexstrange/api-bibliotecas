package com.aline.apibiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aline.apibiblioteca.model.Livro;


public interface LivroRepository extends JpaRepository<Livro,Integer> {

}

