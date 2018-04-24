package ru.innopolis.vasiliev.lesson11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<SomePOJO> myCollection=new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
        for(int i=0;i<1_000_000;i++){
            myCollection.add(new SomePOJO());
        }
        scanner.nextLine();
    }
}
