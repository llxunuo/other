package com.example.activitidemo.core.service;

import com.example.activitidemo.core.entity.User;

import java.util.List;

public interface UserService {
	/**
	 * 通过部门获取领导ID
	 * @param dept
	 * @return
	 */
	List<String> getSimpleCheckerByDept(Long dept);
	Long countUser();
	void save(User user);
}
