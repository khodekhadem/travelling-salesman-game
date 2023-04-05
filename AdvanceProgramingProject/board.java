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
    int [][]mainmap;
    int [][]shownmap;
    public board(int board_size) {
        this.board_size = board_size ; 
        this.mainmap = new int [board_size][board_size];
        this.shownmap= new int [board_size][board_size];
        mainmap[board_size/2][board_size/2] = 9 ;//set ghale
        setganj(mainmap);//set ganj [10..17]
        setBoard(mainmap, 5, 2);//set divar
        setBoard(mainmap, 5, 3);//set market
        setBoard(mainmap, board_size, 4);//set gom shode
        setBoard(mainmap, 3, 5);//set tale
        copy_main_to_shown(mainmap,shownmap);        
    }
    void copy_main_to_shown(int [][]tmpmainmap,int [][]tmpshownmap){
        for (int i = 0; i < this.board_size; i++) {
            for (int j = 0; j < this.board_size; j++) {
                if (tmpmainmap[i][j]==9 ||tmpmainmap[i][j]==2 || tmpmainmap[i][j]==3  ) {
                    tmpshownmap [i][j] = tmpmainmap[i][j]; 
                }  
            }
        }

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
    }
}
