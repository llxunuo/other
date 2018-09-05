package test;

import api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer {
    public  static  void  main(String[]  args) throws IOException {
        ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();

        HelloService helloService = (HelloService)context.getBean("helloService");
        //getserviceinvocationproxy
        String hello=helloService.sayHello("world2");
        //doinvoke!
        System.out.println(hello);
        //cool,howareyou~
        System.in.read();
    }
}
