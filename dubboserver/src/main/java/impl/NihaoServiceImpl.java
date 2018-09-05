package impl;

import api.HelloService;

public class NihaoServiceImpl implements HelloService {
    @Override
    public String sayHello(String s) {
        return "你好 "+ s;
    }
}
