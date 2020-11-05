package life;

import javax.swing.SwingUtilities;

public class Life {

    public static void main(String[] args) {
        Window game = new Window();
        SwingUtilities.invokeLater(game);
    }
    
}
