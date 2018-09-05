package rest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public  static  void  main(String[]  args) throws IOException {
        ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        //启动成功，监听端口为20880System.in.read();//按任意键退出
        System.out.println(context.getDisplayName() + ": here");
//        context.start();
        System.out.println("服务已经启动...");
        System.in.read();
    }
}
