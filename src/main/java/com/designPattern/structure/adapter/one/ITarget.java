package com.designPattern.structure.adapter.one;

/**
 * 使用适配器模式进行重构
 */
public interface ITarget {
    void function1();
    void function2();
    void fucntion3(ParamsWrapperDefinition paramsWrapper);
    void function4();
}
