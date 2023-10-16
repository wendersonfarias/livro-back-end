package com.wenderson.java.back.end.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wenderson.java.back.end.dto.UserDTO;
import com.wenderson.java.back.end.model.User;
import com.wenderson.java.back.end.repository.UserRepository;

@Service

public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserDTO> getAll(){
		List<User> listUser= userRepository.findAll();
		List<UserDTO> listUserDTO= new ArrayList<UserDTO>();
		
		for (User user : listUser) {
			listUserDTO.add(UserDTO.convert(user));
		}
		return listUserDTO;
	}
	
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> 
							new RuntimeException("Usuario nao encontrado"));
		
		return UserDTO.convert(user);
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf).orElseThrow(() -> 
							new RuntimeException("Usuario nao encontrado"));

		return UserDTO.convert(user);
	}
	
	public UserDTO save(UserDTO userDTO) {
		User user = User.convert(userDTO);
		return UserDTO.convert(userRepository.save(user));
	}
	
	public UserDTO delete(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> 
					new RuntimeException("Usuario nao encontardo!"));
		
		return UserDTO.convert(user);
	}
	
	public List<UserDTO> queryByName(String nome){
		List<User> listUser =  userRepository.queryByNomeLike(nome);
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		
		for (User user : listUser) {
			listUserDTO.add(UserDTO.convert(user));
		}
		
		return listUserDTO;
	}
	
	public UserDTO editUser(Long userId, UserDTO userDTO) {
		User user = userRepository
					.findById(userId).orElseThrow(() ->	new	RuntimeException( ));
	
		if(userDTO.getEmail() != null && !user.getEmail().equals(userDTO.getEmail())) {
			user.setEmail(userDTO.getEmail());
		}
		
		if(userDTO.getTelefone() != null && !user.getTelefone().equals(userDTO.getTelefone())) {
			user.setTelefone(userDTO.getTelefone());
		}
		
		if(userDTO.getEndereco() != null && !user.getEndereco().equals(userDTO.getEndereco())) {
			user.setEndereco(userDTO.getEndereco());
		}
		
		user =  userRepository.save(user);
		return UserDTO.convert(user);
	
	}
	
	public	Page<UserDTO>	getAllPage(Pageable	page) {
		Page<User>	users	=	userRepository.findAll(page);
		return	users.map(UserDTO::convert);
	}

	
	
	
}
