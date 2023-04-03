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
public class board1 {
    int board_size ;
    int [][]map;
    public board1(int board_size) {
        this.board_size = board_size ; 
        this.map = new int [board_size][board_size];
        setganj(map);
        //setBoard(map, board_size, 2);
        
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

    void setganj(int [][] tmpMap){
        int tmp1;
        int tmp2;
        int tmp3 =10;
        for(int k =0;k<2;k++){
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    tmp1 = (int)(Math.random()*(this.board_size/2 +i));
                    tmp2 = (int)(Math.random()*(this.board_size/2 +j));
                    if(tmpMap [tmp1 + i*(this.board_size/2) ][tmp2 + j*(this.board_size/2)] == 0){
                        tmpMap [tmp1 + i*(this.board_size/2) ][tmp2 + j*(this.board_size/2)] = tmp3;
                        tmp3++;
                    }
                    else{
                        j--;
                    }
                }
            }
        }
        //tmp1 = (int)(Math.random()*(this.board_size/2));
        //tmp2 = (int)(Math.random()*(this.board_size/2));
        //tmpMap [tmp1][tmp2] = 10;


        //tmp1 = (int)(Math.random()*(this.board_size/2 +1));
        //tmp2 = (int)(Math.random()*(this.board_size/2));
        //tmpMap [tmp1+this.board_size/2][tmp2] = 12;
        
        
        //tmp1 = (int)(Math.random()*(this.board_size/2 +1));
        //tmp2 = (int)(Math.random()*(this.board_size/2 +1));
        //tmpMap [tmp1+this.board_size/2][tmp2+this.board_size/2] = 14;
        

        //tmp1 = (int)(Math.random()*(this.board_size/2));
        //tmp2 = (int)(Math.random()*(this.board_size/2 +1));
        //tmpMap [tmp1][tmp2+this.board_size/2] = 16;

        ////--------------------------------------------------
        
        //tmp1 = (int)(Math.random()*(this.board_size/2));
        //tmp2 = (int)(Math.random()*(this.board_size/2));
        //tmpMap [tmp1][tmp2] = 11;

        //tmp1 = (int)(Math.random()*(this.board_size/2 +1));
        //tmp2 = (int)(Math.random()*(this.board_size/2));
        //tmpMap [tmp1+this.board_size/2][tmp2] = 13;

        //tmp1 = (int)(Math.random()*(this.board_size/2 +1));
        //tmp2 = (int)(Math.random()*(this.board_size/2 +1));
        //tmpMap [tmp1+this.board_size/2][tmp2+this.board_size/2] = 15;

        //tmp1 = (int)(Math.random()*(this.board_size/2));
        //tmp2 = (int)(Math.random()*(this.board_size/2 +1));
        //tmpMap [tmp1][tmp2+this.board_size/2] = 17;
    }
}
