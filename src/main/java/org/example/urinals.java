package org.example;

import java.util.Scanner;

public class urinals {

    //checking if the string is valid - if there is no free urinal between 2 people
    public static boolean isValidString(String str){
        if(str.contains("11")) return false;
        return true;
    }

    public static int numberOfUrinals(String str) {
        char[] persons = str.toCharArray();
        int freeUrinals = 0;

        for (int i = 0; i < persons.length - 1; i++) {
            if (i == 0) {
                if (persons[i] == '0' && persons[i + 1] == '0') {
                    persons[i] = '1';
                    freeUrinals++;
                }
            }
            if (i > 0) {
                if (persons[i] == '0' && persons[i - 1] == '0' && persons[i + 1] == '0') {
                    persons[i] = '1';
                    freeUrinals++;
                }
            }
        }
        if (persons[persons.length - 1] == '0' && persons[persons.length - 2] == '0') {
            freeUrinals++;
        }
        return freeUrinals;
    }

    public static void main(String[] args){
        System.out.println("Enter the strings");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            if(str.equals("-1")){
                System.exit(1);
            }
            else {
                if (isValidString(str)) {
                    System.out.println("Number of free Urinals : "+ numberOfUrinals(str));
                } else {
                    System.out.println(-1); //Invalid string input
                }
            }
        }
    }


}