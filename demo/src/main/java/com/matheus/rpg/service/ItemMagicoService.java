package com.matheus.rpg.service;

import com.matheus.rpg.model.ItemMagico;
import com.matheus.rpg.repository.ItemMagicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemMagicoService {

    private final ItemMagicoRepository itemMagicoRepository;

    public ItemMagicoService(ItemMagicoRepository itemMagicoRepository) {
        this.itemMagicoRepository = itemMagicoRepository;
    }

    public ItemMagico criar(ItemMagico item) {
        return itemMagicoRepository.save(item);
    }

    public List<ItemMagico> listar() {
        return itemMagicoRepository.findAll();
    }

    public Optional<ItemMagico> buscarPorId(Long id) {
        return itemMagicoRepository.findById(id);
    }
}

