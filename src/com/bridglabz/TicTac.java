package com.bridglabz;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TicTac {

    private static char[] element;
    private static char player;

    private  static  char computer;
    private static int moves=0;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game....!!!");
        board();
        userinput();
        toss();
        printBoard();
        gamePlay();
    }


    public static void board() {
        element = new char[10];
        for (int i = 0; i < 9; i++) {
            element[i] = '+';
        }
    }

    public static void userinput() {
        Scanner in = new Scanner(System.in);
        System.out.println(" Select Your Marker (O or X): ");
        player = in.next().charAt(0);
        if (player == 'X') {
            computer = 'O';
            System.out.println("User mark is :" + player);
        } else
            computer = 'X';
        System.out.println("User mark is :" + player);
    }

    public  static void toss(){
        int result=(int)Math.floor(Math.random() * 10) % 2;
        if (result==1){
            System.out.println("Player has won and he will play first");
        }
        else{
            System.out.println("Computer will play first");
        }
    }

    public static void printBoard() {
        {
            System.out.println("|---|---|---|");
            System.out.println("| " + element[0] + " | "
                    + element[1] + " | " + element[2]
                    + " |");
            System.out.println("|-----------|");
            System.out.println("| " + element[3] + " | "
                    + element[4] + " | " + element[5]
                    + " |");
            System.out.println("|-----------|");
            System.out.println("| " + element[6] + " | "
                    + element[7] + " | " + element[8]
                    + " |");
            System.out.println("|---|---|---|");
        }
    }

    public static void gamePlay(){
        while(moves < 9){
            Scanner sc=new Scanner(System.in);
            System.out.println("Please enter the position between 0-8");
            int position=sc.nextInt();
            if(element[position]=='+'){
                element[position]=player;
                printBoard();
                moves++;
                gamePlay();
            }
            else {
                System.out.println("Invalid move");
            }
        }
    }
}



