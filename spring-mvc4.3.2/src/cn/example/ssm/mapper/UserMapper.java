package cn.example.ssm.mapper;

import org.springframework.stereotype.Repository;

import cn.example.ssm.po.User;

@Repository
public interface UserMapper {
	public User findUsersByUsername(String username);
	public int addUser(User user);
	public int modifyPasswordByUsername(User user);
}
