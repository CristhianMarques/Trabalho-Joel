/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rest.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author CaroleCristhian
 */
@Entity
@Table(name="pessoa")
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 4, max = 255, message = "O nome deve ter no minimo  4 caracteres")
    @Column(name="nome")
    private String nome;
    @NotBlank(message= "O endereço não pode ser vazio")
    @Column(name="endereco")
    private String endereco;
    
    @NotBlank(message= "O CEP não pode ser vazio")
    @Column(name="CEP")
    private String CEP;
    
    @NotBlank(message= "O CEP não pode ser vazio")
    @Column(name="CPF", unique = true)
    @CPF(message = "CPF invalido")
    private String CPF;
    
    @Size(min = 18, message = "A idade minima e 18")
    @Column(name="idade")
    private Integer idade;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

        
}
