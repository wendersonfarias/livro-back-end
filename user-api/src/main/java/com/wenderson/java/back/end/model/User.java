package com.wenderson.java.back.end.model;

import java.time.LocalDateTime;

import com.wenderson.java.back.end.dto.UserDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	private 	Long id;
	private 	String nome;
	private		String	cpf;								
	private		String	endereco;
	private		String	email;
	private		String	telefone;
	private		LocalDateTime	dataCadastro;
	
	public User convert(UserDTO userDTO) {
		User user = new User();
		user.setNome(userDTO.getNome());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setEndereco(userDTO.getEndereco());
		user.setTelefone(userDTO.getTelefone());
		user.setDataCadastro(userDTO.getDataCadastro());
		
		return user;
	}

}
