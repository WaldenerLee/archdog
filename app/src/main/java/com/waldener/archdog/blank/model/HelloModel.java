package com.waldener.archdog.blank.model;

public class HelloModel {
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        return "BlankModel{" +
                "hello='" + hello + '\'' +
                '}';
    }
}
