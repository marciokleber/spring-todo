package com.github.marciokleber.springtodo.controller;

import com.github.marciokleber.springtodo.domain.entity.Categoria;
import com.github.marciokleber.springtodo.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findbyId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new));
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaRepository.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoriaUpdated) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(categoriaUpdated, categoria, "id");
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaRepository.save(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
