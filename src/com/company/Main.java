package com.company;
import java.util.Scanner;
import java.lang.Math;
public class Main {

    public static int board[][]=new int[8][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        setUpBoard();
        printBoard();
        while(true){
            System.out.printf("Select the Task:\n1.Game Play\n2.Print the Board\n3.Show Recording\n4.Exit\n");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    break;
                case 2:
                    printBoard();
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void setUpBoard() {
        int t=1;
        for(int j=0;j<8;j++) {
            board[7][j] = j < 3 ? t++ : t--;
            if (j == 3) {
                t++;
            }
        }
        t=11;
        for(int j=0;j<8;j++){
            board[0][j]=j<3?t++:t--;
            if(j==3){
                t++;
            }
        }
        for(int i=0;i<8;i++){
            board[1][i]=16;
        }
        for(int i=0;i<8;i++){
            board[6][i]=6;
        }
        board[0][4]=15;
        board[7][4]=5;
    }
    public static void printBoard() {
        String position[]={"   ","W_R","W_N","W_B","W_Q","W_K","W_P"," "," "," "," ","B_R","B_N","B_B","B_Q","B_K","B_P"};

        for(int i=0;i<8;i++){
            //for(int j=0;j<8;j++){
                System.out.println("_".repeat(33));
            //}
            for(int j=0;j<8;j++){
                System.out.print("|"+position[board[i][j]]);
            }
            System.out.println("|");
        }
    }
    public static void knight(int current_x,int current_y){

    }
}
