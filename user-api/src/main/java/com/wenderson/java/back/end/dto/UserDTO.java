package com.wenderson.java.back.end.dto;

import java.time.LocalDateTime;

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
	
}
