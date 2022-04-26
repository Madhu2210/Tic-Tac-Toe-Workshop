package com.bridglabz;

import java.util.Scanner;

public class TicTac {

    private static char[] element;
    private static char player;

    private  static  char computer;
    private static int moves=0;
    private static int flag=0;
    private static boolean winner=false;
    private static int block=0;

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
            element[i] = ' ';
        }
    }

    public static void userinput() {
        Scanner in = new Scanner(System.in);
        System.out.println(" Select Your Marker (O or X): ");
        player = in.next().charAt(0);
        if (player == 'x') {
            computer = 'o';
            System.out.println("User mark is :" + player);
        } else{
            computer='x';
            player='o';
            System.out.println("Computer mark is:"+computer);
        }
    }

    public  static void toss(){
        int result=(int)Math.floor(Math.random() * 10) % 2;
        if (result==1){
            flag=0;
            System.out.println("Player has won and he will play first");
        }
        else{
            flag=1;
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

    public static void winningConditions(char playerletter){
            if (element[0]==element[1] && element[1]==element[2] && element[2]==playerletter){
                winner=true;
            } else if(element[3]==element[4] && element[4]==element[5] && element[5]==playerletter){
                winner=true;
            } else if(element[6]==element[7] && element[7]==element[8] && element[8]==playerletter){
                winner=true;
            } else if (element[0]==element[3] && element[3]==element[6] && element[6]==playerletter) {
                winner=true;
            } else if (element[1]==element[4] && element[4]==element[7] && element[7]==playerletter) {
                winner=true;
            } else if (element[2]==element[5] && element[5]==element[8] && element[8]==playerletter) {
                winner=true;
            } else if (element[0]==element[4] && element[4]==element[8] && element[8]==playerletter) {
                winner=true;
            } else if (element[2]==element[4] && element[4]==element[6] && element[6]==playerletter) {
                winner=true;
            }
    }

    public static void checkWinComputer(){
        for (int i = 0; i < 9; i++) {
            if (element[i] == ' ') {
                element[i] = computer;
                winningConditions(computer);
                if (winner == false) {
                    element[i]=' ';
                }
                else{
                    printBoard();
                    if(winner==true){
                        System.out.println("Computer has won");
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static void checkBlockComputer(){
        for (int i = 0; i < 9; i++) {
            if (element[i] == ' ') {
                element[i] = player;
                winningConditions(player);
                if (winner == true) {
                    element[i]=computer;
                    printBoard();
                    block=1;
                    winner=false;
                    if(winner==true){
                        System.out.println("Computer has won");
                        System.exit(0);
                    }
                }
                else{
                    element[i]=' ';
                }
            }
            if (block==1){
                break;
            }
        }
    }

    public static void gamePlay(){
        while(moves < 9){
            if(flag==0){
                Scanner sc=new Scanner(System.in);
                System.out.println("Please enter the position between 0-8");
                int position=sc.nextInt();
                if(element[position]==' '){
                    element[position]=player;
                    printBoard();
                    moves++;
                    winningConditions(player);
                    if(winner==true){
                        System.out.println("Player has won");
                        System.exit(0);
                    }
                    flag=1;
                    gamePlay();
                }
                else {
                    System.out.println("Invalid move");
                }
            } else if (flag==1) {
                System.out.println("Computer turn");
                checkWinComputer();
                checkBlockComputer();
                if (block==1){
                    moves++;
                    flag=0;
                }
                block=0;
                if (flag==1) {
                    int position = (int) Math.floor(Math.random() * 10) % 9;
                    if (element[position] == ' ') {
                        element[position] = computer;
                        printBoard();
                        moves++;
                        winningConditions(computer);
                        if (winner == true) {
                            System.out.println("Computer has won");
                            System.exit(0);
                        }
                        flag = 0;
                        gamePlay();
                    } else {
                        System.out.println("Invalid move");
                    }
                }
            }
        }
        if (moves==9 && winner==false){
            System.out.println("It is a Draw");
            System.exit(0);
        }
    }
}



