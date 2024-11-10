package com.example.demo.service;

import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal atualizar(Long id, Animal animalAtualizado) {
        Animal animal = buscarPorId(id);
        return animalRepository.save(animal);
    }

    public void deletar(Long id) {
        Animal animal = buscarPorId(id);
        animalRepository.delete(animal);
    }
}
