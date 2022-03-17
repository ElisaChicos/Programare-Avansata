package com.company;

public class Router extends Node implements Identifiable {
    private String addr;

    public Router() {
        this.addr = "";
    }

    public Router(String addr) {
        this.addr = addr;
    }

    @Override
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Router{" +
                "address='" + addr + '\'' +
                '}';
    }
}
