package ru.innopolis.vasiliev.lesson3_hw;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        MathBox mathBox;
        MathBox mathBox2;
        Number[] nums = {1,2.9F,3L,4.9,53f,6,5,7,8,54};
        Number[] nums2 = {2,44.124F,343L,4.93,53d,0,-232,-0.33,-2,22,3,4,1};
        try {
            mathBox=new MathBox(nums);
            //mathBox2=new MathBox(nums2);

            //System.out.println(mathBox.summator());

            mathBox.splitter(1.2);
            mathBox2=mathBox;

            checkHashCodeAndEquals(mathBox,mathBox2);
        } catch (NotUniqueValuesException e) {
            e.printStackTrace();
        }
    }

    private static void checkHashCodeAndEquals(MathBox m1, MathBox m2){
        System.out.println("m1:"+m1.hashCode());
        System.out.println("m2:"+m2.hashCode());
        System.out.println(m1.equals(m2));
    }

}
