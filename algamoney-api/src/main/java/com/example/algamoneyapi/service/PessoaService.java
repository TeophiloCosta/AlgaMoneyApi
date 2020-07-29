package com.example.algamoneyapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
				
		if(pessoaSalva.isPresent()) {
			BeanUtils.copyProperties(pessoa, pessoaSalva.get(), "codigo");
			return pessoaRepository.save(pessoaSalva.get());	
	
		} else
			throw new EmptyResultDataAccessException(1);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		
		if(pessoaSalva.isPresent()) {
			Pessoa pessoaTemp = pessoaSalva.get();
			pessoaTemp.setAtivo(ativo);	
	
		} else
			throw new EmptyResultDataAccessException(1);
		
	}
	

}
