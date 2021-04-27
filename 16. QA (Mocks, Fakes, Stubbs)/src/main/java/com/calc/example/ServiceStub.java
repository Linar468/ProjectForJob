package com.calc.example;

interface  Service{
    String doSomething();
}

public class ServiceStub implements Service{
    @Override
    public String doSomething() {
        return "myStubbedReturn";
    }
}

class ServiceRealUsing implements Service{

    @Override
    public String doSomething() {
        return "myRealUsingFunctional";
    }
}
