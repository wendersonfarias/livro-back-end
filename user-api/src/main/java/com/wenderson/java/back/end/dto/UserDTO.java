package com.wenderson.java.back.end.dto;

import java.time.LocalDateTime;

import com.wenderson.java.back.end.model.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@NotBlank(message = "Nome é obrigatorio!")
	private		String			nome;
	
	@NotBlank(message = "CPF é obrigatorio!")
	private		String			cpf;
	
	private		String			endereco;
	
	@NotBlank(message = "Email é obrigatorio!")
	private		String			email;
	private		String			telefone;
	private		LocalDateTime	dataCadastro;
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());
		
		return userDTO;
	}
	
}
