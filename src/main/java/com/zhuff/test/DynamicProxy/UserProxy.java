package com.zhuff.test.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy {
    public Object createProxy(Object target) {
        Class<?>[] interfaces = target.getClass().getInterfaces();
        UserHandler handler = new UserHandler(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces, handler);
    }

    private class UserHandler implements InvocationHandler{
        private Object target;

        public UserHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(target.getClass().getName() + ":" + method.getName());
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        IUser user = (IUser) new UserProxy().createProxy(new User("zhuff", 32));
        user.getName();
        user.getAge();
    }
}
