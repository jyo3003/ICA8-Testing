package org.example;

import java.io.*;
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
        if(str.equals(null)) return 0;
        if(str.equals("0")) return 1;
        if(str.equals("1")) return 0;
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



    public static void main(String[] args) {
        System.out.println("How do you wish to take the input?");
        System.out.println("Press 1 to use command line or 2 to use file-urinal.dat");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        //Reading from scanner
        if(input == 1) {
            System.out.println("Enter the strings");
            while (sc.hasNext()) {
                String str = sc.next();
                if (str.equals("-1")) {
                    System.exit(1);
                } else {
                    if (isValidString(str)) {
                        System.out.println(numberOfUrinals(str));
                    } else {
                        System.out.println(-1); //Invalid string input
                    }
                }
            }
        }
        //reading input from file
        else {
            BufferedReader file_buffer = null;
            String[] file_Names = new String[1000];
            for(int i=0;i<100;i++){
                if(i==0){
                    file_Names[0] = "rule.txt";
                }
                else{
                    file_Names[i] = "rule"+ i +".txt";
                }
            }
            try {
                //input file
                FileReader file = new FileReader(new File("src/main/java/org/example/urinals.dat"));
                file_buffer = new BufferedReader(file);

                //output file
                String relativePath  = "src/main/java/org/example/";
                for(int i=0;i<1000;i++){
                    File f = new File(relativePath+file_Names[i]);
                    if(f.exists() && !f.isDirectory()) {
                        continue;
                    }
                    else{
                        relativePath = relativePath + file_Names[i];
                        break;
                    }
                }
                File file1 = new File(relativePath);
                BufferedWriter output = new BufferedWriter(new FileWriter(file1));
                String str = file_buffer.readLine();
                while (str != null) {
                    if (str.equals("-1")) {
                        System.exit(1);
                    } else {
                        if (isValidString(str)) {
                            output.write(String.valueOf(numberOfUrinals(str)));
                            output.newLine();
                        } else {
                            output.write("-1");//Invalid string input
                            output.newLine();
                        }
                    }
                    str = file_buffer.readLine();
                }
                file.close();
                output.close();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (file_buffer != null) {
                        file_buffer.close();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

    }


}