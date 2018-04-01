package ru.innopolis.vasiliev.lesson3_hw;

import java.util.ArrayList;
import java.util.HashSet;

class MathBox<T extends Number> {

    private HashSet<T> nums = new HashSet<>();

    //В чем смысл использования дженериков в данном случае?
    // Я, кажется, чего то не понял. Почему нельзя хранить просто коллекцию Numbers?

    public MathBox(T[] nums) throws NotUniqueValuesException {
        for (int i = 0; i < nums.length; i++) {
            if (!this.nums.contains(nums[i])) {
                this.nums.add(nums[i]);
            } else {
                throw new NotUniqueValuesException(i);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return nums.equals(mathBox.nums);
    }

    @Override
    public int hashCode() {
        //hashCode будет меняться каждый раз при изменении ArrayList.
        //Сделать поле immutable нет возможности из за метода splitter.
        //Для использования в качестве ключа придется перед изменением поля каждый раз удалять бакет и добавлять заново измененный.
        return nums.hashCode();
    }

    public double summator() {
        double sum = 0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public void splitter(Number divider) {
        if (divider.doubleValue() == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        for (Number num : nums) {
            nums.remove(num);
            nums.add((T) new Double(num.doubleValue() / divider.doubleValue()));
        }
    }
}

class NotUniqueValuesException extends Exception {
    private int i;

    public NotUniqueValuesException(int i) {
        this.i = i;
    }

    @Override
    public String getMessage() {
        return "Значение в " + i + " элементе не является уникальным в данном массиве";
    }
}


