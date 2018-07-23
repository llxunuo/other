package com.example.springbootbasis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ELKTest {

    @Test
    public void contextLoads() {
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() throws Exception {

        for(int i=0;i<100;i++) {
            logger.info("输出info  ");
            logger.debug("输出debug+skkkw嗡嗡嗡kw");
            logger.error("输出error  嗡嗡嗡我");
        }
    }
}
