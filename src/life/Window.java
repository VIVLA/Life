/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Window extends JFrame implements Runnable {
    
    private Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    private void initFrame() {
        setSize(Config.SIZE * Config.WIDTH + 10, Config.SIZE * Config.HEIGHT + 37);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Life Game");
        setVisible(true);
    }

    private void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                add(boxes[x][y]);
            }
        
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = - 1; sx <= 1; sx++)
                    for (int sy = - 1; sy <= 1; sy++)
                        if (!(sx == 0 && sy == 0)) {
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
                        }
        
        for (int x = 10; x < 15; x++) {
            boxes[x][10].cell.status = Rules.LIFE;
            boxes[x][10].setColor();
        }
        
    }

    private void initTimer() {
        TimerAdapter t = new TimerAdapter();
        Timer timer = new Timer(Config.DELAYMS, t);
        timer.start();
    }
    
    private class TimerAdapter implements ActionListener {
        private boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++)
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (flop)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();
                }
        }
        
    }
    
    

}
