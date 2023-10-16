package com.wenderson.java.back.end.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wenderson.java.back.end.dto.UserDTO;
import com.wenderson.java.back.end.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	public static	List<UserDTO>	usuarios= new ArrayList<UserDTO>();
	
	@PostConstruct
	public	void	initiateList() {
		UserDTO	userDTO	=	new	UserDTO();
		userDTO.setNome("Eduardo");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua	a");
		userDTO.setEmail("eduardo@email.com");
		userDTO.setTelefone("1234-3454");
		userDTO.setDataCadastro(LocalDateTime.now());
		
		UserDTO	userDTO2	=	new	UserDTO();
		userDTO2.setNome("Luiz");
		userDTO2.setCpf("456");
		userDTO2.setEndereco("Rua	b");
		userDTO2.setEmail("luiz@email.com");
		userDTO2.setTelefone("1234-3454");
		userDTO2.setDataCadastro(LocalDateTime.now());
		
		UserDTO	userDTO3	=	new	UserDTO();
		userDTO3.setNome("Bruna");
		userDTO3.setCpf("678");
		userDTO3.setEndereco("Rua	c");
		userDTO3.setEmail("bruna@email.com");
	
		userDTO3.setTelefone("1234-3454");
		userDTO3.setDataCadastro(LocalDateTime.now());
		
		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}
	
	@GetMapping
	public List<UserDTO> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/{cpf}/cpf")
	public UserDTO findByCPF(@PathVariable String cpf) {
		return userService.findByCpf(cpf);

	}
	
	@GetMapping("/{id}")
	public	UserDTO	findById(@PathVariable	Long	id) {
		return	userService.findById(id);
	}

	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	UserDTO inserirUser(@Valid @RequestBody UserDTO user) {
		return userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void  removerUser(@PathVariable Long id) {
		userService.delete(id); 
	}
	
	@GetMapping("/search")
	public	List<UserDTO> queryByName( @RequestParam(name="nome", required=true) String	nome) {
		return	userService.queryByName(nome);
	}


	
	

}
