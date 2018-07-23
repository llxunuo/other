package com.example.activitidemo.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfig {


    @Bean
    public ProcessEngine createByConfig(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml")
                .buildProcessEngine();
        return  processEngine;
    }

    @Bean
    @Autowired
    public Deployment deploymentProcessDefinition_classpath(ProcessEngine processEngine){
        Deployment deployment = processEngine.getRepositoryService() // 与流程定义和部署对象相关的Service
                .createDeployment() // 创建一个部署对象
                .name("流程定义") // 设置对应流程的名称
                .addClasspathResource("diagrams/hello.bpmn") // 从Classpath的资源中加载，一次只能加载一个文件(windows与linux下面要区分)
                .addClasspathResource("diagrams/hello.bpmn") // 从Classpath的资源中加载，图片
                .deploy(); // 完成部署

        System.out.println("部署Id："+deployment.getId()); // 部署Id：20001
        System.out.println("部署名称："+deployment.getName()); // 部署名称：流程定义
        return deployment;
    }



}
