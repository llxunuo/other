package com.example.activitidemo.core.repo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface UserRepo {
//	@Query(value="select id from user where dept=?1 and position=?2",nativeQuery=true)
	List<BigInteger> findIdByDeptAndPosition(Long dept, Integer position);
//	@Query(value="select dept from user where id=?",nativeQuery=true)
	Long findDeptById(Long uid);
}
