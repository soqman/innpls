package ru.innopolis.vasiliev.lesson3_hw_lesson6_hw;

import java.util.HashSet;
import java.util.Iterator;

class MathBox<T extends Number> implements IMathBox {

    private HashSet<T> nums = new HashSet<>();

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
    @Override
    @ClearData
    public double summator() {
        double sum = 0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }
    @Override
    @ClearData
    public void splitter(Number divider) {
        if (divider.doubleValue() == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        for (Iterator<T> it = nums.iterator(); it.hasNext(); ) {
            T t=it.next();
            t=(T) new Double(t.doubleValue() / divider.doubleValue());
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


