package ru.innopolis.vasiliev.lesson9;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static Predicate<String> digitPredicate;
    public static void main(String[] args) {
        digitPredicate =(s) -> s.matches("[0-9]+");
        Scanner scanner = new Scanner(System.in);
        System.out.println("get first number");
        String first = scanner.nextLine();
        while(!digitPredicate.test(first)){
            System.out.println("get number");
            first = scanner.nextLine();
        }
        System.out.println("get second number");
        String second = scanner.nextLine();
        while(!digitPredicate.test(second)){
            System.out.println("get number");
            second = scanner.nextLine();
        }
        System.out.println("result is: "+String.valueOf(Integer.parseInt(second)+Integer.parseInt(first)));

    }
}
