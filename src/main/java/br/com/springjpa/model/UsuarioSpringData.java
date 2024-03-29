package br.com.springjpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UsuarioSpringData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private int idade;
    @OneToMany(mappedBy = "usuarioSpringData", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Telefone> telefones;

    public UsuarioSpringData() {
    }

    public UsuarioSpringData(String login, String senha, String nome, String email, int idade) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    @Override
    public String toString() {
        return "UsuarioSpringData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
