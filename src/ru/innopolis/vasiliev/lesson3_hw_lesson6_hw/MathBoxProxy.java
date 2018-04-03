package ru.innopolis.vasiliev.lesson3_hw_lesson6_hw;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;

public class MathBoxProxy implements InvocationHandler {
    IMathBox mathBox;

    public MathBoxProxy(IMathBox mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = mathBox.getClass();
        if(clazz.getMethod(method.getName(),method.getParameterTypes()).getAnnotation(ClearData.class)!=null){
            Object result = method.invoke(mathBox, args);
            Field field = clazz.getDeclaredField("nums");
            field.setAccessible(true);
            HashSet nums=(HashSet) field.get(mathBox);
            nums.clear();
            System.out.println("We call method " + method.getName() + " and clear data");
            return result;
        }
        if (clazz.getAnnotation(Logged.class)!=null){
            long startTime = System.currentTimeMillis();
            System.out.println("We call method " + method.getName());
            Object result = method.invoke(mathBox, args);
            System.out.println(" with time "+(startTime-System.currentTimeMillis()));
            return result;
        }


        return method.invoke(mathBox, args);
    }
}
