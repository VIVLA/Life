package life;

import java.awt.Color;

public class Config {
    
    public static int SIZE = 10;
    public static int WIDTH = 60;
    public static int HEIGHT = 40;
    
    public static int DELAYMS = 100;
    
    public static final Color getColor(Rules status) {
        switch(status) {
            case NONE: return Color.BLACK;
            case BORN: return Color.GRAY;
            case LIFE: return Color.WHITE;
            case DIE: return Color.BLUE;
            default: return null;
        }
    }
    
}
