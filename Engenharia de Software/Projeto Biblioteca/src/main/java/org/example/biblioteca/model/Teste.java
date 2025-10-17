package org.example.biblioteca.model;

public class Teste {
    private Integer id;
    private String nome;
    private String resultado;
    private Integer usuarioId; // FK opcional

    public Teste() {}

    public Teste(Integer id, String nome, String resultado, Integer usuarioId) {
        this.id = id;
        this.nome = nome;
        this.resultado = resultado;
        this.usuarioId = usuarioId;
    }

    public Teste(String nome, String resultado, Integer usuarioId) {
        this(null, nome, resultado, usuarioId);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
}
