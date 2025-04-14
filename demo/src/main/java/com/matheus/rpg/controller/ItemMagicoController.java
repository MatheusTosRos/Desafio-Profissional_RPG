package com.matheus.rpg.controller;

import com.matheus.rpg.model.ItemMagico;
import com.matheus.rpg.service.ItemMagicoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {

    private final ItemMagicoService itemMagicoService;

    public ItemMagicoController(ItemMagicoService itemMagicoService) {
        this.itemMagicoService = itemMagicoService;
    }

    @PostMapping
    public ItemMagico criar(@RequestBody ItemMagico item) {
        return itemMagicoService.criar(item);
    }

    @GetMapping
    public List<ItemMagico> listar() {
        return itemMagicoService.listar();
    }

    @GetMapping("/{id}")
    public ItemMagico buscarPorId(@PathVariable Long id) {
        return itemMagicoService.buscarPorId(id).orElseThrow();
    }
}
