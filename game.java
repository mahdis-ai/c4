import java.util.Scanner;

public class game {
    String board[][]=new String[6][7];
    Scanner input=new Scanner(System.in);
    int currentplayer=1;
    public  void welcome1(){
        System.out.println("please enter player1 name and color");
    }
    player player1=new player(input.nextLine(),input.nextLine());
    public void welcome2(){
        System.out.println("please enter player 2 name and color");
    }
    player player2=new player(input.nextLine(),input.nextLine());
    int r=0;
    String m;
    public game() {
        intialize();
        do {
            CreateBoard();
            printboard();
            String S = ask();
            if (S.equals("exit")) exit();
            while (!S.equals("exit")) {
                if (S.equals("restart"))
                    restart();
                dropx();
                if (check() != 0) break;
                dropo();
                if (check() != 0) break;
            }
            showinf();
            askpergame();
        }while(m.equals("startnew"));
    }
    public void askpergame(){
        System.out.println("for starting new game press startnew");
         m=input.nextLine();
    }
    public void CreateBoard() {
        for (int i = 0; 6 > i; i += 1) {
            for (int j = 0; 7 > j; j += 1) {
                board[i][j] = ".";
            }
        }
    }
    public void printboard(){
        System.out.println("x is player1 sign");
        System.out.println("o is player2 sign");
        for (int i = 0;  i<6; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(board[i][j]+'\t');
            }
            System.out.println();
        }

    }
    public void intialize(){
        player1.setScore(0);
        player2.setScore(0);
    }
    public void dropx() {
        System.out.println("its player" + currentplayer + "turn");
        System.out.println("enter column number(0-6)");
        int column = input.nextInt();
        int counter=1;
        while (true) {
            if (column > 7) {
                System.out.println("That's not a valid column");
                break;
            }
            int imin = 5;

            if (board[imin][column].equals(".")) {
                board[imin][column] = "x";
                currentplayer=2;
                break;
            } else if (board[imin][column].equals("x") || board[imin][column].equals("o")) {
                if (board[imin - counter][column].equals(".")) {
                    board[imin - counter][column]="x";
                    currentplayer=2;
                    break;
                }
            }
            counter += 1;
            if (counter == 5) {
                System.out.println("That column is full");
                break;
            }

        }
        if(counter!=5) printboard();
    }
        public void dropo(){
        System.out.println("its player"+currentplayer+"turn");
            System.out.println("enter column number(0-6)");
        int column=input.nextInt();
            int counter = 1;
            while (true) {
                if (column > 7) {
                    System.out.println("That's not a valid column");
                    break;
                }
                int imin = 5;

                if (board[imin][column].equals(".")) {
                    board[imin][column] = "o";
                    currentplayer=1;
                    break;
                } else if (board[imin][column].equals("x") || board[imin][column].equals("o")) {
                    if (board[imin - counter][column].equals(".")) {
                        board[imin - counter][column]="o";
                        currentplayer=1;
                        break;
                    }
                }
                counter += 1;
                if (counter == 5) {
                    System.out.println("That column is full");
                    break;
                }

            }
            if(counter!=5) printboard();

    }

      public   int check(){
          for (int i = 0; i <6; i++) {
              for (int j = 0; j <4 ; j++) {
                  if (board[i][j].equals("x") && board[i][j+1].equals("x")&& board[i][j+2].equals("x") && board[i][j+3].equals("x")) {
                      System.out.println("player1 won");
                      player1.setScore(player1.getScore()+1);
                      r=1;

                     break;
                  }
                  if(r==1) break;
              }
              if(r==1) break;
              
          }
          for (int i = 0; i <6; i++) {
              for (int j = 0; j <4 ; j++) {
                  if (board[i][j].equals("o") && board[i][j+1].equals("o")&& board[i][j+2].equals("o")&& board[i][j+3].equals("o")) {
                      System.out.println("player2 won");
                      r=1;
                      player2.setScore(player2.getScore()+1);
                      break;
                  }
                  if(r==1) break;
              }
              if(r==1) break;

          }
          for (int j = 0;  j<6 ; j++) {
              for (int i = 0; i <3 ; i++) {
                  if (board[i][j].equals("x")&& board[i+1][j].equals("x")&& board[i+2][j].equals("x")&& board[i+3][j].equals("x")){
                      System.out.println("player1 won");
                      r=1;
                      player1.setScore(player1.getScore()+1);
                      break;
                  }
                  if(r==1) break;
              }
              if(r==1) break;
          }
          for (int j = 0;  j<6 ; j++) {
              for (int i = 0; i <3 ; i++) {
                  if (board[i][j].equals("o")&& board[i+1][j].equals("o")&& board[i+2][j].equals("o")&& board[i+3][j].equals("o")){
                      System.out.println("player2 won");
                      r=1;
                      player2.setScore(player2.getScore()+1);
                      break;
                  }
                  if(r==1) break;
              }
              if(r==1) break;
          }
          for (int i = 5; i >=3; i--) {
              for (int j = 0; j <4; j++) {
                  if (board[i][j].equals("x")&& board[i-1][j+1].equals("x")&& board[i-2][j+2].equals("x")&& board[i-3][j+3].equals("x")){
                      System.out.println("player1 won");
                      player1.setScore(player1.getScore()+1);
                      r=1;
                      break;
                  }
                  if(r==1) break;

              }
              if(r==1) break;
          }
          for (int i = 5; i >=3; i--) {
              for (int j = 0; j <4; j++) {
                  if (board[i][j].equals("o")&& board[i-1][j+1].equals("o")&& board[i-2][j+2].equals("o")&& board[i-3][j+3].equals("o")){
                      System.out.println("player2 won");
                      player2.setScore(player2.getScore()+1);
                      r=1;
                      break;
                  }
                  if(r==1) break;

              }
              if(r==1) break;
          }
          int c=0;
          for (int i = 0; i <6 ; i++) {

              for (int j = 0; j <7 ; j++) {
                  if (!board[i][j] .equals( ".")) c++;
              }
          }
          for (int i = 0; i <3 ; i++) {
              for (int j = 0; j <4; j++) {

                  if (board[i][j].equals("x")&& board[i+1][j+1].equals("x")&& board[i+2][j+2].equals("x")&& board[i+3][j+3].equals("x")){
                      System.out.println("player1 won");
                      player1.setScore(player1.getScore()+1);
                      r=1;
                      break;
                  }
                  if(r==1) break;

              }
              if(r==1) break;
          }
          for (int i = 0; i <3 ; i++) {
              for (int j = 0; j <4; j++) {

                  if (board[i][j].equals("o")&& board[i+1][j+1].equals("o")&& board[i+2][j+2].equals("o")&& board[i+3][j+3].equals("o")){
                      System.out.println("player2 won");
                      player2.setScore(player2.getScore()+1);
                      r=1;
                      break;
                  }
                  if(r==1) break;

              }
              if(r==1) break;
          }
          if(c==42 && r==0){
              System.out.println("draw ");
              r=2;}
          return r;

      }
      public void exit(){

              System.exit(0);

      }
      public void showinf(){
          System.out.println("player1"+player1.getScore()+"-"+"player2"+player2.getScore());
      }
     public void restart(){
          CreateBoard();
          printboard();

     }
     public String ask(){
         System.out.println("for exiting the game press exit");
         System.out.println("for starting new game press restart");
         System.out.println("for continuing the game press any key");
         String s=input.nextLine();
         return s;
     }


}