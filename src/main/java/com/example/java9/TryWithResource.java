package com.example.java9;

import java.io.*;
import java.util.Scanner;

public class TryWithResource {

    void beforeJava9() throws FileNotFoundException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/hello.txt"))) {
            String line;
            while(null!=(line = bufferedReader.readLine())) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void afterJava9() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/hello.txt"));
        try (bufferedReader){
            String line;
            while(null!=(line = bufferedReader.readLine())) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
