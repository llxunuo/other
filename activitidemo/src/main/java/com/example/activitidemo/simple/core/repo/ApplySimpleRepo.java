package com.example.activitidemo.simple.core.repo;


import com.example.activitidemo.simple.core.entity.ApplySimple;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ApplySimpleRepo {
	/**
	 * 更新申请状态
	 * @param id
	 * @param state
	 */
//	@Query(value="update ApplySimple a set a.state = :state where a.id = :id",nativeQuery=true)
	void updateState(Long id, Integer state);
}
