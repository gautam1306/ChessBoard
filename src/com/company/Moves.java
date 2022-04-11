package com.company;
public class Moves extends Main{
    public static String key,des;
    Moves(String key,String des){
        this.key=key;
        this.des=des;
        char s=key.charAt(0);
        int current_y=s-'a';
        s=key.charAt(1);
        int current_x=7-(s-'1');
        s=des.charAt(0);
        int move_y=s-'a';
        s=des.charAt(1);
        int move_x=7-(s-'1');
        findPiece(current_x,current_y,move_x,move_y);
    }

    private void findPiece(int current_x,int current_y,int move_x,int move_y) {
        boolean s=true;
        switch(board[current_x][current_y]%10){
            case 1:
                s=Rook(current_x,current_y,move_x,move_y);
                break;
            case 2:
                s=Knight(current_x,current_y,move_x,move_y);
                break;
            case 3:
                s=Bishop(current_x,current_y,move_x,move_y);
                break;
            case 4:
                s=Queen(current_x,current_y,move_x,move_y);
                break;
            case 5:
                s=King(current_x,current_y,move_x,move_y);
                break;
            case 6:
                s=Pawn(current_x,current_y,move_x,move_y);
                break;

        }
        if(!s){
            flag=(flag==0)?1:0;
        }
    }

    public static boolean Knight(int current_x,int current_y,int move_x,int move_y){
        if(Checkmove(move_x,move_y)){
            if((Math.abs(current_x-move_x)==1&&Math.abs(move_y-current_y)==2)||(Math.abs(current_x-move_x)==2&&Math.abs(move_y-current_y)==1)){
                boolean c=(board[move_x][move_y]/10!=board[current_x][current_y]/10 && board[move_x][move_y]!=0 && board[current_x][current_y]!=0);
                if(c){
                    System.out.println("The Piece have been captured");
                }
                board[move_x][move_y]=board[current_x][current_y];
                board[current_x][current_y]=0;
                System.out.println("the move had been made");
                return true;
            }
            else{
                System.out.println("Invalid Move\nPlease Move again");
                return false;
            }
        }
        else{
            System.out.println("It is an Invalid move!\nPlease Try Again");
            return false;
        }
    }
    public static boolean Rook(int current_x,int current_y,int move_x,int move_y){
        if(Checkmove(move_x,move_y)) {
            if ((move_x==current_x && move_y!=current_y)||(move_x!=current_x && move_y==current_y)) {
                boolean c=(board[move_x][move_y]/10!=board[current_x][current_y]/10 && board[move_x][move_y]!=0 && board[current_x][current_y]!=0);
                if(c){
                    System.out.println("The Piece have been captured");
                }
                board[move_x][move_y]=board[current_x][current_y];
                board[current_x][current_y]=0;
                System.out.println("the move had been made");
                return true;
            }
            else{
                System.out.println("It is an Invalid move!\nPlease Try Again");
                return false;
            }
        }
        else {
            System.out.println("It is an Invalid move!\nPlease Try Again");
            return false;
        }
    }
    public static boolean Bishop(int current_x,int current_y,int move_x,int move_y) {
        if(Checkmove(move_x,move_y)) {
            if (Math.abs(move_x - current_x) == Math.abs(move_y - current_y)) {
                boolean c=(board[move_x][move_y]/10!=board[current_x][current_y]/10 && board[move_x][move_y]!=0 && board[current_x][current_y]!=0);
                if(c){
                    System.out.println("The Piece have been captured");
                }
                board[move_x][move_y]=board[current_x][current_y];
                board[current_x][current_y]=0;
                System.out.println("the move had been made");
                return true;
            }
            else{
                System.out.println("It is an Invalid move!\nPlease Try Again");
                return false;
            }
        }
        else {
            System.out.println("It is an Invalid move!\nPlease Try Again");
            return false;
        }
    }
    public static boolean Queen(int current_x,int current_y,int move_x,int move_y){
        if(Checkmove(move_x,move_y)){
            if(Bishop(current_x,current_y,move_x,move_y)||Rook(current_x,current_y,move_x,move_y)){
                boolean c=(board[move_x][move_y]/10!=board[current_x][current_y]/10 && board[move_x][move_y]!=0 && board[current_x][current_y]!=0);
                if(c){
                    System.out.println("The Piece have been captured");
                }
                board[move_x][move_y] = board[current_x][current_y];
                board[current_x][current_y] = 0;
                System.out.println("the move had been made");
                return true;
            }
            else {
                System.out.println("It is an Invalid move!\nPlease Try Again");
                return false;
            }
        }
        else{
            System.out.println("It is an Invalid move!\nPlease Try Again");
            return false;
        }
    }
    public static boolean King(int current_x,int current_y,int move_x,int move_y){
        if(Checkmove(move_x,move_y)){
            if(Math.abs(current_x-move_x)+Math.abs(move_y-current_y)==1){
                boolean c=(board[move_x][move_y]/10!=board[current_x][current_y]/10 && board[move_x][move_y]!=0 && board[current_x][current_y]!=0);
                if(c){
                    System.out.println("The Piece have been captured");
                }
                board[move_x][move_y] = board[current_x][current_y];
                board[current_x][current_y] = 0;
                System.out.println("the move had been made");
                return true;
            }
            else{
                System.out.println("It is an Invalid move!\nPlease Try Again");
                return false;
            }
        }
        else{
            System.out.println("It is an Invalid move!\nPlease Try Again");
            return false;
        }
    }
    public static boolean Pawn(int current_x,int current_y,int move_x,int move_y){
        if(Checkmove(move_x,move_y)){
            if(Math.abs(move_x-current_x)==1){
                boolean c=(board[move_x][move_y]/10!=board[current_x][current_y]/10 && board[move_x][move_y]!=0 && board[current_x][current_y]!=0);
                if(c){
                    System.out.println("The Piece have been captured");
                }
                board[move_x][move_y] = board[current_x][current_y];
                board[current_x][current_y] = 0;
                System.out.println("the move had been made");
                return true;
            }
            else{
                System.out.println("It is an Invalid move!\nPlease Try Again");
                return false;
            }
        }
        else{
            System.out.println("It is an Invalid move!\nPlease Try Again");
            return false;
        }
    }

    public static boolean Checkmove(int move_x ,int move_y){
        return move_x<8 && move_x>=0 && move_y>=0 && move_y<8;
    }
}