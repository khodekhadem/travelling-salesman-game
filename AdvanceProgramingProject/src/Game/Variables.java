package Game;

/**
 *
 * @author eby
 */
public class Variables {

    public static int squerLine;
    private static int row = 10;
    private static int cool = 10;
    public static MyClient client;
    public static MyServer server;

    public static void setRow(int row) {
        if (row > 2 && row < 50) {
            Variables.row = row;
        } else if (row >= 50) {
            Variables.row = 49;
        }
    }

    public static int getRow() {
        return Variables.row;
    }

    public static void setCool(int cool) {
        if (cool > 2 && cool < 50) {
            Variables.cool = cool;
        } else if (cool >= 50) {
            Variables.cool = 49;
        }
    }
    public static  void setRowAndCool(int row,int cool){
        setRow(row);
        setCool(cool);
    }

    public static int getCool() {
        return Variables.cool;
    }
}
