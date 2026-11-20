package com.biblioteca.projetomvc2.Model;

import java.util.ArrayList;

public class Categoria {
    private String nome;
    private ArrayList<Livro> livrosGenero = new ArrayList<>();
    private ArrayList<Livro> livrosArea = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Livro> getLivrosGenero() {
        return livrosGenero;
    }

    public void setLivrosGenero(ArrayList<Livro> livrosGenero) {
        this.livrosGenero = livrosGenero;
    }

    public ArrayList<Livro> getLivrosArea() {
        return livrosArea;
    }

    public void setLivrosArea(ArrayList<Livro> livrosArea) {
        this.livrosArea = livrosArea;
    }
}
