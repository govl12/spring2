package com.spring.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")	// Spring Framework�� Bean ��� : userService
public class UserServiceImpl implements UserService {

	
	//����Ͻ� ������ ó���ϴ� Ŭ����
	
	@Autowired // Ȱ��ȭ. ��ü ���� ��. @Autowired = Spring Framework�� ������ 
			//Bean�� Ÿ���� ã�Ƽ� ���� (DI) 
	UserDAO userDAO;
	
	
	@Override
	public UserDTO getUser(UserDTO dto) {
	
	//	userDAO.getUser(dto);
		//return null;
//	
		System.out.println(dto.getId());

		System.out.println(dto.getPassword());
		
		return userDAO.getUser(dto);
		
	}

}
