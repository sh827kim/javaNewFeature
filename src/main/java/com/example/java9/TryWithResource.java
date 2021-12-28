package com.example.java9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

    void beforeJava9() {
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
