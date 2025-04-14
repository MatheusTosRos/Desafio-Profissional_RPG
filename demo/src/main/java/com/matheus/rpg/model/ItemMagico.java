package com.matheus.rpg.model;

import com.matheus.rpg.model.TipoItem;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ItemMagico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo;
    private int forca;
    private int defesa;

    public ItemMagico() {}

    public ItemMagico(String nome, TipoItem tipo, int forca, int defesa) {
        if (forca == 0 && defesa == 0) throw new IllegalArgumentException("Item não pode ter 0 de força e 0 de defesa");
        if (forca > 10 || defesa > 10) throw new IllegalArgumentException("Força ou Defesa máximas são 10");
        if (tipo == TipoItem.ARMA && defesa != 0) throw new IllegalArgumentException("Arma deve ter defesa 0");
        if (tipo == TipoItem.ARMADURA && forca != 0) throw new IllegalArgumentException("Armadura deve ter força 0");

        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public TipoItem getTipo() { return tipo; }
    public int getForca() { return forca; }
    public int getDefesa() { return defesa; }
}