package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public Animal criarAnimal(@Valid @RequestBody Animal animal) {
        return animalService.salvar(animal);
    }

    @GetMapping
    public List<Animal> listarAnimais() {
        return animalService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarAnimal(@PathVariable Long id) {
        Animal animal = animalService.buscarPorId(id);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizarAnimal(@PathVariable Long id, @Valid @RequestBody Animal animalDetalhes) {
        Animal animalAtualizado = animalService.atualizar(id, animalDetalhes);
        return ResponseEntity.ok(animalAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
