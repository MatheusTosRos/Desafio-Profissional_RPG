package com.matheus.rpg.service;

import com.matheus.rpg.model.ItemMagico;
import com.matheus.rpg.model.Personagem;
import com.matheus.rpg.repository.PersonagemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public Personagem criar(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> listar() {
        return personagemRepository.findAll();
    }

    public Optional<Personagem> buscarPorId(Long id) {
        return personagemRepository.findById(id);
    }

    public Personagem atualizarNomeAventureiro(Long id, String novoNome) {
        Personagem personagem = personagemRepository.findById(id).orElseThrow();
        personagem.setNomeAventureiro(novoNome);
        return personagemRepository.save(personagem);
    }

    public void remover(Long id) {
        personagemRepository.deleteById(id);
    }

    public Personagem adicionarItem(Long idPersonagem, ItemMagico item) {
        Personagem personagem = personagemRepository.findById(idPersonagem).orElseThrow();
        personagem.adicionarItem(item);
        return personagemRepository.save(personagem);
    }

    public Personagem removerItem(Long idPersonagem, Long idItem) {
        Personagem personagem = personagemRepository.findById(idPersonagem).orElseThrow();
        personagem.removerItem(idItem);
        return personagemRepository.save(personagem);
    }

    public Optional<ItemMagico> buscarAmuleto(Long idPersonagem) {
        Personagem personagem = personagemRepository.findById(idPersonagem).orElseThrow();
        return personagem.getAmuleto();
    }

    public List<ItemMagico> listarItens(Long idPersonagem) {
        Personagem personagem = personagemRepository.findById(idPersonagem).orElseThrow();
        return personagem.getItens();
    }
}

