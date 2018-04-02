package ru.innopolis.vasiliev.lesson3_hw_lesson6_hw;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxInvocationHandler implements InvocationHandler {
    IMathBox mathBox;

    public MathBoxInvocationHandler(IMathBox mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = mathBox.getClass();
        if (mathBox.getClass().getAnnotation(Logged.class)!=null){
            long startTime = System.currentTimeMillis();
            System.out.println("We call method " + method.getName());
            Object result = method.invoke(mathBox, args);
            System.out.println(" with time "+(startTime-System.currentTimeMillis()));
            return result;
        } else {
            return method.invoke(mathBox, args);
        }
    }
}
