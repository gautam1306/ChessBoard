package com.company;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static String position[] = {"   ", "W_R", "W_N", "W_B", "W_Q", "W_K", "W_P", " ", " ", " ", " ", "B_R", "B_N", "B_B", "B_Q", "B_K", "B_P"};
    public static int board[][]=new int[8][8];
    public static int flag=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        setUpBoard();
        //printBoard();
        int flag=0;
        while(true){
            System.out.printf("Select the Task:\n1.Game Play\n2.Printing the Board\n3.Recording\n4.Exit\n");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    gamePlay();
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

    public static void gamePlay() {
        while (true){
            if(flag==0){
                System.out.println("White Player's Turn");
            }else{
                System.out.println("Black Player's Turn");
            }
            flag=(flag==0?1:0);
            System.out.println("Enter the Position of Coin");
            Scanner sc=new Scanner(System.in);
            String key= sc.nextLine();
            char s=key.charAt(0);
            int current_y=s-'a';
            s=key.charAt(1);
            int current_x=7-(s-'1');
            System.out.println("The Current type of Coin : "+position[board[current_x][current_y]]);
            System.out.println("Enter the new Position of Coin");
            String des= sc.nextLine();
            if(des.equals("Print")){
                printBoard();
            }else  if(des.equals("exit")){
                break;
            }
            Moves moves=new Moves(key,des);
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
        System.out.print(" ");
        for(int i=0;i<8;i++) {
            System.out.printf("   %c ",i+'a');
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(8-i+"  ");

            for (int j = 0; j < 8; j++) {
                System.out.print(position[board[i][j]] + "  ");
            }
            System.out.println();
        }
    }
}
