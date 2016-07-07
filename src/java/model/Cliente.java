package model;

import javax.persistence.*;

@Entity
@Table (name="cliente")
public class Cliente {
    
    @Id //primary key
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="codcliente")
    private Integer idCliente;
    
    @Column(name="nome", length=50, nullable=false)
    private String nome;
    
    @Column(name="email", length=35, nullable=false)
    private String email;

    public Cliente() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
