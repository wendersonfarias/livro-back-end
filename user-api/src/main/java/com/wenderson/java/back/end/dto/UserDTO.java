package com.wenderson.java.back.end.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private	String			nome;
	private	String			cpf;
	private	String			endereco;
	private	String			email;
	private	String			telefone;
	private	LocalDateTime	dataCadastro;
	
}
