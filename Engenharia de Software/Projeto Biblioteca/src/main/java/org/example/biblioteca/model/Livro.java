package org.example.biblioteca.model;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer bibliotecaId; // FK opcional

    public Livro() {}

    public Livro(Integer id, String titulo, String autor, String isbn, Integer bibliotecaId) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.bibliotecaId = bibliotecaId;
    }

    public Livro(String titulo, String autor, String isbn, Integer bibliotecaId) {
        this(null, titulo, autor, isbn, bibliotecaId);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getBibliotecaId() { return bibliotecaId; }
    public void setBibliotecaId(Integer bibliotecaId) { this.bibliotecaId = bibliotecaId; }
}
