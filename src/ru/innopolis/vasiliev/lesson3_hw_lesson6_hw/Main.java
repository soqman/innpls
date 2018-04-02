package ru.innopolis.vasiliev.lesson3_hw_lesson6_hw;

import java.lang.reflect.Proxy;

class Main {

    public static void main(String[] args) {
        IMathBox mathBox;
        Number[] nums = {1, 2.9F, 3L, 4.9, 53f, 6, 5, 7, 8, 54};
        try {
            mathBox = new MathBox(nums);
            IMathBox mathBoxProxy = (IMathBox) Proxy.newProxyInstance(MathBoxInvocationHandler.class.getClassLoader(),
                    new Class[]{IMathBox.class}, new MathBoxInvocationHandler(mathBox));
            mathBoxProxy.summator();
        } catch (NotUniqueValuesException e) {
            e.printStackTrace();
        }
    }

    private static void checkHashCodeAndEquals(MathBox m1, MathBox m2) {
        System.out.println("m1:" + m1.hashCode());
        System.out.println("m2:" + m2.hashCode());
        System.out.println(m1.equals(m2));
    }

}
