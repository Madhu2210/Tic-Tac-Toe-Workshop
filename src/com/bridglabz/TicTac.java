package com.bridglabz;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TicTac {

    private static char[] element;
    private static char player;

    private  static  char computer;
    private static int moves=0;

    private static boolean winner=false;

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

    public static void winningConditions(){
            if (element[0]==element[1] && element[1]==element[2] && element[2]==player){
                winner=true;
            } else if(element[3]==element[4] && element[4]==element[5] && element[5]==player){
                winner=true;
            } else if(element[6]==element[7] && element[7]==element[8] && element[8]==player){
                winner=true;
            } else if (element[0]==element[3] && element[3]==element[6] && element[6]==player) {
                winner=true;
            } else if (element[1]==element[4] && element[4]==element[7] && element[7]==player) {
                winner=true;
            } else if (element[2]==element[5] && element[5]==element[8] && element[8]==player) {
                winner=true;
            } else if (element[0]==element[4] && element[4]==element[8] && element[8]==player) {
                winner=true;
            } else if (element[2]==element[4] && element[4]==element[6] && element[6]==player) {
                winner=true;
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
                winningConditions();
                if(winner==true){
                    System.out.println("Player has won");
                    System.exit(0);
                }
                gamePlay();
            }
            else {
                System.out.println("Invalid move");
            }
        }
    }
}



