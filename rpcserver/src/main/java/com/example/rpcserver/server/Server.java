package com.example.rpcserver.server;

import java.io.IOException;

public interface Server {
    void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();

}