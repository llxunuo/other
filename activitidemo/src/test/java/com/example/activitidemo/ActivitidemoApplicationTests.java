package com.example.activitidemo;

import com.example.activitidemo.core.entity.User;
import com.example.activitidemo.core.service.UserService;
import com.example.activitidemo.simple.Config.Constant;
import com.example.activitidemo.simple.core.entity.ApplySimple;
import com.example.activitidemo.simple.core.service.ApplySimpleService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitidemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    /** 使用代码创建工作流需要的28张表 */
    @Test
    public void createTable(){
        // 获取流程引擎配置(创建一个单例子的流程引擎)
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        // 设置数据库信息
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEndocing=utf8");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("root");
        /**
         *  processEngineConfiguration 中的配置
         *  DB_SCHEMA_UPDATE_FALSE = "false"; // 不能自动创建表（能够使用脚本创建）
         *    DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop"; // 先删除再更新
         *  DB_SCHEMA_UPDATE_TRUE = "true"; // 如果表不存在我就自动创建表
         */
        // 设置数据库操作的设置
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取工作流的核心对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        Assert.assertNotNull(processEngine);
    }

    /** 使用配置文件创建流程引擎 */
//    @Test
//    public void createByConfig(){
//        ProcessEngine processEngine = ProcessEngineConfiguration
//                .createProcessEngineConfigurationFromResource("activiti.cfg.xml")
//                .buildProcessEngine();
//        Assert.assertNotNull(processEngine);
//    }

    @Autowired
    ProcessEngine processEngine;
//    /**部署流程定义*/
//    @Test
//    public void deploymentProcessDefinition_classpath(){
//        Deployment deployment = processEngine.getRepositoryService() // 与流程定义和部署对象相关的Service
//                .createDeployment() // 创建一个部署对象
//                .name("流程定义") // 设置对应流程的名称
//                .addClasspathResource("diagrams/helloworld.bpmn") // 从Classpath的资源中加载，一次只能加载一个文件(windows与linux下面要区分)
//                .addClasspathResource("diagrams/helloworld.bpmn") // 从Classpath的资源中加载，图片
//                .deploy(); // 完成部署
//
//        System.out.println("部署Id："+deployment.getId()); // 部署Id：20001
//        System.out.println("部署名称："+deployment.getName()); // 部署名称：流程定义
//    }

    /** 启动流程实例 */
    @Test
    public void startProcessInstance(){
        String processDefinitionKey = "myProcess_1"; // 使用Key的启动，默认按照对心版本的流程定义启动
        ProcessInstance pi = processEngine.getRuntimeService() // 与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey); // 使用流程定义的Key启动流程实例，key对应helloworld.bpmn文件中的流程名称

        System.out.println("流程实例Id"+pi.getId()); // 流程实例Id：57501
        System.out.println("流程定义Id"+pi.getProcessDefinitionId()); // 流程定义Id：psocessVariables:1:55004
    }


    @Autowired
    private UserService userService;

    @Autowired
    ApplySimpleService simpleService;

    private static Long DEPT_TINY_SOFTWARE_STUDIO = 1L;
    private static Long DEPT_OTHER = 2L;


    /**
     * 测试简单流程
     */
    @Test
    public void testSimpleActiviti(){
        long startAt = System.currentTimeMillis();
        //添加申请用户
        User user = new User();
        user.setName("anxpp");
        user.setDept(DEPT_TINY_SOFTWARE_STUDIO);
        user.setPosition(Constant.POSITION_GENERAL);
        userService.save(user);
        //添加审核用户
        User userLeader1 = new User();
        userLeader1.setName("anxpp1");
        userLeader1.setDept(DEPT_TINY_SOFTWARE_STUDIO);
        userLeader1.setPosition(Constant.POSITION_LEADER);
        userService.save(userLeader1);
        User userLeader2 = new User();
        userLeader2.setName("anxpp2");
        userLeader2.setDept(DEPT_OTHER);
        userLeader2.setPosition(Constant.POSITION_LEADER);
        userService.save(userLeader2);
        Long countHis = simpleService.countProcess();
        Long countLeader1Task = simpleService.countTask(userLeader1.getId());
        Long countLeader2Task = simpleService.countTask(userLeader2.getId());
        //创建请假申请
        ApplySimple applySimple = new ApplySimple();
        applySimple.setInsertBy(user.getId());
        applySimple.setComtent("有事请假...");
        //启动请假流程
        simpleService.startProcess(applySimple);
        /**断言历史流程+1*/
        Assert.assertEquals(simpleService.countProcess(), new Long(countHis+1));
        /**断言领导任务变化*/
        Assert.assertEquals(simpleService.countTask(userLeader1.getId()), new Long(countLeader1Task+1));
        Assert.assertEquals(countLeader2Task, simpleService.countTask(userLeader2.getId()));
        //获取用户任务
        List<Task> taskUserLeader1 = simpleService.getTaskByUid(userLeader1.getId());
        //处理任务
        Iterator<Task> iterator = taskUserLeader1.iterator();
        while(iterator.hasNext()){
            Task task = iterator.next();
            /**断言任务节点名称*/
            Assert.assertEquals("领导审批", task.getName());
            simpleService.completeSimpleCheck(task.getId(), ApplySimpleService.STATE_PASS);
        }
        /**断言领导任务变化*/
        Assert.assertEquals(countLeader1Task, simpleService.countTask(userLeader1.getId()));
        Assert.assertEquals(countLeader2Task, simpleService.countTask(userLeader2.getId()));
        System.err.println("asdf");
//        log.info("测试完成，花费时间："+(System.currentTimeMillis()-startAt));
    }
}
