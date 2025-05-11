package br.com.fecaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_livro;
    private String nome;
    private int numero_paginas;
    private String edicao;
    private String foto;
    private String autor;
    private String editora;
    private String categoria;


    public Integer getId_livro() {
        return id_livro;
    }

    public void setId_livro(Integer id_livro) {
        this.id_livro = id_livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}