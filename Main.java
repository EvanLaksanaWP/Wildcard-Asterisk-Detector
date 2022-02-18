package com.tutorial;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inputPattern = cin.next();
        char [] pattern = new char[inputPattern.length()];
        int n = cin.nextInt();
        int indexBintang = 0;
        int frontChar = 0;
        int backChar = 0;
        int poin = 0;
        String kata = "";
        String [] hasilKata = new String[n];

        for (int i = 0 ; i < inputPattern.length() ; i++){
            pattern[i] = inputPattern.charAt(i);
        }
        for (int i = 0 ; i<pattern.length ; i++) {
            if(pattern[i]=='*'){
                indexBintang = i;
            }
        }
        for (int i = 0 ; i<pattern.length ; i++) {
            if (i<indexBintang){
                if (pattern[i]!='*'){
                    frontChar++;
                }
            }
            else if(i>indexBintang){
                if (pattern[i]!='*'){
                    backChar++;
                }
            }
        }
        int indexHasilKata = 0;
        for(int i = 0 ; i<n ; i++){
            kata = cin.next();
            for (int j = 0 ; j < frontChar ; j++){
                if (kata.charAt(j)==pattern[j]){
                    poin++;
                }
            }
            int buffer = pattern.length-1;
            for (int j = kata.length()-1 ; j >= kata.length()-backChar ; j--){
                if (kata.charAt(j) == pattern[buffer]){
                    poin++;
                }
                buffer--;
            }

            if (poin==backChar+frontChar){
                hasilKata[indexHasilKata] = kata;
                indexHasilKata++;
            }
            poin = 0;
        }
        for (String i:hasilKata) {
            if (i!=null) {
                System.out.println(i);
            }
        }
    }
}
