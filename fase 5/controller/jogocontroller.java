package com.iaragames.controllers;

import com.iaragames.models.Jogo;
import com.iaragames.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    
    @Autowired
    private JogoRepository jogoRepository;
    
    @GetMapping
    public List<Jogo> getAllJogos() {
        return jogoRepository.findAll();
    }

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @PutMapping("/{id}")
    public Jogo updateJogo(@PathVariable Long id, @RequestBody Jogo jogoDetails) {
        Jogo jogo = jogoRepository.findById(id).orElseThrow();
        jogo.setTitulo(jogoDetails.getTitulo());
        jogo.setGenero(jogoDetails.getGenero());
        return jogoRepository.save(jogo);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(@PathVariable Long id) {
        jogoRepository.deleteById(id);
    }
}
