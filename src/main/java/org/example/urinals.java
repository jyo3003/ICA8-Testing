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

    public static String getFileName(String fileName){
        File file = new File(fileName);

        if(file.exists()) {
            int dot = fileName.lastIndexOf('.');
            int open = fileName.lastIndexOf('(');
            int incr = 0;
            boolean validNum = false;

            if(fileName.charAt(dot-1) == ')' && open != -1){
                String n = fileName.substring(open+1, dot-1);
                try {
                    incr = Integer.parseInt(n);
                    validNum = true;
                } catch(NumberFormatException e) {
                    validNum = false;
                }
            }

            if(validNum) {
                String pre = fileName.substring(0, open+1), post = fileName.substring(0, dot-1);
                while(new File(pre + ++incr + post).exists());
                fileName = pre + incr + post;
            } else {
                fileName = fileName.substring(0, dot) + "(1)" + fileName.substring(dot);
            }
        }
        return fileName;
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
            try {
                FileReader file = new FileReader(new File("src/main/java/org/example/urinals.dat"));
                file_buffer = new BufferedReader(file);
                File file1 = new File(getFileName("src/main/java/org/example/rule.txt"));
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