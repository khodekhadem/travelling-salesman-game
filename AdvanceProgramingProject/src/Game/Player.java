package Game;

import javax.swing.JOptionPane;

/**
 * @author eby
 *
 */
public class Player {

    private String name;
    private int power = 1;
    private int point;
    private int nowXCoordinates;
    private int nowYCoordinates;
    public boolean isForbidRound = false;
    public Move move;
    
    public Player(Move move) {
        this.move = move;
    }

    //function for control power
    public int getPower() {
        return this.power;
    }

    public void losePower() {
        power--;
        if (power < 1) {
            power = 1;
            isForbidRound = true;
            JOptionPane.showMessageDialog(null, "Opss! " + this.name + " coudn't play for one turn (pow=0)!!");
        }
    }

    public void addPower() {
        power++;
    }

    public void setPower(int tmppower) {
        power = tmppower;
    }

    //function for control point
    public void addPoint() {
        this.point++;
    }

    public int getPoint() {
        return this.point;
    }

    //function for control location
    public void setNowX(int x) {
        nowXCoordinates = x;
    }

    public void setNowY(int y) {
        nowYCoordinates = y;
    }

    public int getNowX() {
        return nowXCoordinates;
    }

    public int getNowY() {
        return nowYCoordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if (!name.isEmpty()) {
                this.name = name;
            }
        } catch (Exception e) {

        }
    }

}
