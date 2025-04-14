package com.matheus.rpg.model;

import com.matheus.rpg.model.Classe;
import com.matheus.rpg.model.ItemMagico;
import com.matheus.rpg.model.TipoItem;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Personagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private Classe classe;
    private int level;
    private int forcaBase;
    private int defesaBase;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemMagico> itens = new ArrayList<>();

    public Personagem() {}

    public Personagem(String nome, String nomeAventureiro, Classe classe, int forcaBase, int defesaBase) {
        if (forcaBase + defesaBase != 10) throw new IllegalArgumentException("Distribua exatamente 10 pontos entre força e defesa");

        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = 1;
        this.forcaBase = forcaBase;
        this.defesaBase = defesaBase;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getNomeAventureiro() { return nomeAventureiro; }
    public Classe getClasse() { return classe; }
    public int getLevel() { return level; }
    public int getForcaTotal() {
        return forcaBase + itens.stream().mapToInt(ItemMagico::getForca).sum();
    }
    public int getDefesaTotal() {
        return defesaBase + itens.stream().mapToInt(ItemMagico::getDefesa).sum();
    }
    public List<ItemMagico> getItens() { return itens; }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public void adicionarItem(ItemMagico item) {
        if (item.getTipo() == TipoItem.AMULETO && possuiAmuleto())
            throw new IllegalArgumentException("Personagem já possui um amuleto");
        itens.add(item);
    }

    public void removerItem(Long idItem) {
        itens.removeIf(item -> item.getId().equals(idItem));
    }

    public boolean possuiAmuleto() {
        return itens.stream().anyMatch(item -> item.getTipo() == TipoItem.AMULETO);
    }

    public Optional<ItemMagico> getAmuleto() {
        return itens.stream().filter(item -> item.getTipo() == TipoItem.AMULETO).findFirst();
    }
}