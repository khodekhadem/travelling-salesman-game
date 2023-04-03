public class Main {
  

    public static void main(String[] args) {
        board1 mybBoard = new board1(11);
        for (int i = 0; i < 11; i++) {
          for (int j = 0; j < 11; j++) {
            System.out.print(mybBoard.map[i][j]);
            System.out.print(" ");
          }
          System.out.println();
        }
    }

}
