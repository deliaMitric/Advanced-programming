/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1;

/**
 *
 * @author Delia
 */
public class compulsory {

    static int suma(int number) {
        
            int sum;
            while(number>9)
        {
           sum = 0;
           while(number != 0)
           {
               sum = sum + number%10;
               number = number/10;
           }
           number = sum;
        }
            return number;
        }
    public static void main(String[] args) {
        
        //pas 1
        System.out.println("Hello World!");
        
        //pas 2
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        
        //pas 3
        int n = (int) (Math.random() * 1_000_000);
        
        //pas 4
        n = n * 3;
        
        n = n + 0b10101;
        
        n = n + 0xFF;
        
        n = n * 6;
        
        //pas 5
        int number = suma(n);
        System.out.println(number);
        
        //pas 6
        System.out.println("Willy-nilly, this semester I will learn " + languages[number]);
    }
}
