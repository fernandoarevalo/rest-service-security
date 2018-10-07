package co.edu.udistrital.service.inter;

import java.util.List;

import co.edu.udistrital.entity.UserEntity;

public interface IUserService {
	
	List<UserEntity> findAll();
	
	UserEntity save(UserEntity userEntity);
	
	UserEntity update(UserEntity userEntity);
	
	Boolean delete(Long idUser);
}
