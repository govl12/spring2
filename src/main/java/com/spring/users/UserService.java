package com.spring.users;

public interface UserService {

	//회원 정보를 가지고 오는 메소드 : getUser(dto);
	//UserDTO = 생성된 클래스 이름임.
	UserDTO getUser(UserDTO dto);

}