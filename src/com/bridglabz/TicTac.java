package com.bridglabz;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TicTac {

    private static char[] element;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game....!!!");
        board();
        userinput();
    }
        public static void board() {
            element = new char[10];
            for(int i=1; i<10; i++) {
                element[i]=' ';
            }
        }
    public static void userinput() {
        Scanner in=new Scanner(System.in);
        System.out.println(" Select Your Marker (O or X): ");
        char player=in.next().charAt(0);
        char computer;
        if (player=='X') {
            computer='O';
            System.out.println("User mark is :" +player);}

        else
            computer='X';
        System.out.println("User mark is :" +player);
    }
}



