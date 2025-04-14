package com.matheus.rpg.controller;

import com.matheus.rpg.model.ItemMagico;
import com.matheus.rpg.model.Personagem;
import com.matheus.rpg.service.PersonagemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem) {
        return personagemService.criar(personagem);
    }

    @GetMapping
    public List<Personagem> listar() {
        return personagemService.listar();
    }

    @GetMapping("/{id}")
    public Personagem buscarPorId(@PathVariable Long id) {
        return personagemService.buscarPorId(id).orElseThrow();
    }

    @PutMapping("/{id}/nomeAventureiro")
    public Personagem atualizarNome(@PathVariable Long id, @RequestBody String nomeAventureiro) {
        return personagemService.atualizarNomeAventureiro(id, nomeAventureiro);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        personagemService.remover(id);
    }

    @DeleteMapping("/{id}/item/{itemId}")
    public Personagem removerItem(@PathVariable Long id, @PathVariable Long itemId) {
        return personagemService.removerItem(id, itemId);
    }

    @GetMapping("/{id}/itens")
    public List<ItemMagico> listarItens(@PathVariable Long id) {
        return personagemService.listarItens(id);
    }

    @GetMapping("/{id}/amuleto")
    public ItemMagico buscarAmuleto(@PathVariable Long id) {
        return personagemService.buscarAmuleto(id).orElseThrow();
    }
}

