package GUI;

import Game.Game;

/**
 *
 * @author eby
 */
public class GUI {

    private final Game game;
    private MapCreator mapCreator;
    private MainMap mainMap;

    public GUI(Game game) {
        this.game = game;
        mapCreator = new MapCreator(game);
    }
   
    void newMapCreator() {
        mapCreator = new MapCreator(game);
    }

    public void drawMainMap() {
        mainMap = new MainMap(mapCreator);
    }

    public MainMap getMainMap() {
        return mainMap;
    }

    public MapCreator getMapCreator() {
        return mapCreator;
    }
}
