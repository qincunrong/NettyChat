package com.ysten.netty.bean;

public class HostInfo {
    private String ip;
    private String port;
    private String name;

    public HostInfo(String ip, String port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }
}
