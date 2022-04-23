package com.designPattern.structure.adapter.one;

public class CDAdaptor extends CD implements ITarget {
    @Override
    public void function1() {
        staticFunction1();
    }

    @Override
    public void function2() {
        super.uglyNamingFunction2();
    }

    @Override
    public void fucntion3(ParamsWrapperDefinition paramsWrapper) {
        super.tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
    }

    @Override
    public void function4() {
        super.lowPerformanceFunction4();
    }

    public static void main(String[] args) {
        ITarget target = new CDAdaptor();
        target.function1();
        target.function2();
        target.fucntion3(new ParamsWrapperDefinition(1,2));
        target.function4();
    }
}
