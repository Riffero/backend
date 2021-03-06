package com.youtube.demo.service;

import java.util.List;

import com.youtube.demo.model.User;

public interface UserService {

	/**
	 * Guarda un usuario
	 * 
	 * @param user
	 * @return el usuario guardado
	 */
	User save(User user);

	/**
	 * Recupera la lista de usuarios
	 * @return lista de usuarios
	 */
	List<User> findAll();

	/**
	 * Eliminar un usuario con el ID recibido
	 * @param id
	 */
	void deleteUser(Long id);

}
