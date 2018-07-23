package com.example.activitidemo.simple.listener;

import java.util.List;

import com.example.activitidemo.core.service.UserService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 领导审核监听器
 * @author anxpp.com
 * 2016年12月24日 下午12:10:01
 */
public class LeaderCheckListener implements TaskListener{
	private static final long serialVersionUID = 4285398130708457006L;
	private final static Logger log = LoggerFactory.getLogger(LeaderCheckListener.class);

	@Autowired
	UserService userService;

	@Override
	public void notify(DelegateTask task) {
		log.info("领导审核监听器...");
		//设置任务处理候选人
//		UserService userService = SpringUtil.getBean(UserService.class);
		List<String> leaders = userService.getSimpleCheckerByDept(Long.valueOf(task.getVariable("dept").toString()));
		log.info(leaders.toString());
		log.info(task.getVariable("dept").toString());
		task.addCandidateUsers(leaders);
	}
}
