package co.edu.udistrital.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.entity.UserEntity;
import co.edu.udistrital.repo.UserRepository;
import co.edu.udistrital.service.inter.IUserService;

@Service("userService")
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public Boolean delete(Long idUser) {
		userRepository.deleteById(idUser);
		return Boolean.TRUE;
	}

}
