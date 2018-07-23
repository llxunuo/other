package com.example.activitidemo.core.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.activitidemo.core.entity.User;
import com.example.activitidemo.core.repo.UserRepo;
import com.example.activitidemo.core.service.UserService;
import com.example.activitidemo.simple.Config.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<String> getSimpleCheckerByDept(Long dept) {
		List<BigInteger> ids = userRepo.findIdByDeptAndPosition(dept, Constant.POSITION_LEADER);
		List<String> result = new ArrayList<>(ids.size());
		Iterator<BigInteger> iterator = ids.iterator();
		while(iterator.hasNext()){
			result.add(iterator.next().toString());
		}
		return result;
	}

	@Override
	public void save(User user) {
//		userRepo.save(user);
	}

	@Override
	public Long countUser() {
		return 1L;//userRepo.count();
	}

}
