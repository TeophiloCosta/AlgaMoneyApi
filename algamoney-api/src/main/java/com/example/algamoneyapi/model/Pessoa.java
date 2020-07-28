package com.example.algamoneyapi.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "pessoa")

public class Pessoa {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private long codigo;

@NotNull
@Size(min = 3, max = 50)
private String nome;

@Embedded
private Endereco endereco;

private boolean ativo;


public long getCodigo() {
	return codigo;
}
public void setCodigo(long codigo) {
	this.codigo = codigo;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}

public Endereco getEndereco() {
	return endereco;
}
public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
}

public boolean isAtivo() {
	return ativo;
}
public void setAtivo(boolean ativo) {
	this.ativo = ativo;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (codigo ^ (codigo >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pessoa other = (Pessoa) obj;
	if (codigo != other.codigo)
		return false;
	return true;
}

	
	
}
