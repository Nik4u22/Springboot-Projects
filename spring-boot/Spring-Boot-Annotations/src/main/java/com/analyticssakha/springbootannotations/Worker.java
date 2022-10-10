package com.analyticssakha.springbootannotations;


public class Worker {
    public String name;

    Worker(){

    }
    public Worker(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work(){
        System.out.println(name+ " is working");
    }

}
