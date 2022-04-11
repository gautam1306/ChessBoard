package com.company;
import java.util.Scanner;
import java.lang.Math;
public class Main {

    public static int board[][]=new int[8][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int t=1;
            for(int j=0;j<8;j++) {
                board[7][j] = j < 3 ? t++ : t--;
                if (j == 3) {
                    t++;
                }
            }
            t=1;
            for(int j=0;j<8;j++){
                board[0][j]=j<3?t++:t--;
                if(j==3){
                    t++;
                }
            }
        for(int i=0;i<8;i++){
            board[1][i]=6;
        }
        for(int i=0;i<8;i++){
            board[6][i]=6;
        }
        board[0][4]=5;
        board[7][4]=5;

//        System.out.printf("Select the Task:\n1.Game Play\n2.Print the Board\n3.Show Recording\n4.Exit");
        int choice=sc.nextInt();
        printBoard();
//        while(true){
//            switch(choice){
//                case 1:
//                    break;
//                case 2:
//                    printBoard();
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//            }
//        }
    }

    public static void setUpBoard() {

    }
    public static void printBoard() {
        for(int i=0;i<8;i++){
            //for(int j=0;j<8;j++){
                System.out.println("_".repeat(16));
            //}
            for(int j=0;j<8;j++){
                System.out.print("|"+board[i][j]);
            }
            System.out.println("|");
        }
    }
    public static void knight(int current_x,int current_y){

    }
}
