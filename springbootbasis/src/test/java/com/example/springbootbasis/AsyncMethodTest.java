package com.example.springbootbasis;

import com.example.springbootbasis.service.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncMethodTest {

    private Logger logger = LoggerFactory.getLogger(AsyncMethodTest.class);

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        Future<String> page1 = asyncTaskService.helloUser("zhangsan");
        Future<String> page2 = asyncTaskService.helloUser("lisi");
        Future<String> page3 = asyncTaskService.helloUser("wangwu");

        while(!(page1.isDone() && page2.isDone() && page3.isDone())){
            Thread.sleep(10);
        }

        logger.info("Elapsed time: "+(System.currentTimeMillis() - start));
        logger.info("------> " + page1.get());
        logger.info("------> " + page2.get());
        logger.info("------> " + page3.get());
    }
}
