package com.example.mybatisplusdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xmlunit.util.Mapper;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class hashMapTest {

    @Test
    public void hashMapTestMethod(){

        Map<String, String> map = new HashMap<>();
        
        map.put("haha","123");

        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        
    }
}
