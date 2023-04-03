/*
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 
 * 
 * 
 */
public class board {
    int board_size ;
    int [][]map;
    public board(int board_size) {
        this.board_size = board_size ; 
        this.map = new int [board_size][board_size];
        setBoard(map, 8, 1);
        
    }
    void setBoard(int [][] tmpMap,int howMany,int num){
        int tmp1;
        int tmp2;
        for (int i = 0; i < howMany; i++) {
            tmp1 = (int)(Math.random()*(this.board_size));
            tmp2 = (int)(Math.random()*(this.board_size));
            if (tmpMap[tmp1][tmp2] == 0 ) {
                //tmpMap[tmp1][tmp2]=10*num+i; 
                tmpMap[tmp1][tmp2]=num; 
            }
            else{
                i--;
            }

        }
    }


}
