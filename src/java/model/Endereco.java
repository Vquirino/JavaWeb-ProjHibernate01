package model;

import javax.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco {
    
    @Id //primary key
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="codendereco")
    private Integer idEndereco;
    
    @Column(name="logradouro", length=50, nullable=false)
    private String logradouro;
    
    @Column(name="cidade", length=50, nullable=false)
    private String cidade;
    
    @Column(name="estado", length=35, nullable=false)
    private String estado;
    
    @OneToOne //cardinalidade
    @JoinColumn(name="codcliente", nullable=false, unique=true) //foreign key
    private Cliente morador;

    public Endereco() {
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Cliente getMorador() {
        return morador;
    }

    public void setMorador(Cliente morador) {
        this.morador = morador;
    }
    
    
    
}
