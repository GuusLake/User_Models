package actr.tasks.driving;

import java.awt.*;

public class Billboard {
    final boolean INTERESTING = false;
    final double WIDTH = 1;
    final double HEIGHT = 1.6;
    final double START_X = 1.28;
    String boardText = "yooooo";
    double boardOnSet = 0;
    Position boardPos;
    double boardFrac;
    boolean visible = false;
    boolean newBoard = false;

    void update(Env env) {
        double time = env.time;
//        if (time >= 5) {
            if ((int) (time + 3) % 10 == 0 && !visible) {
                newBoard(env);
                newBoard = true;
            }
//        }
    }

    void newBoard(Env env) {
        double time = env.time;
        if (env.simcar.nearPoint != null ) {
            boardFrac = env.simcar.fracIndex + 100;
            boardPos = Road.location(boardFrac, env.road.lanes + 1.3);
            boardPos.y = 1.5;
            boardOnSet = time;
        }
    }

    void drawBoard(Graphics g, Env env) {
        Coordinate cs = env.world2image(boardPos);
        if (cs == null)
            return;

        // grey board
        Position pos1 = Road.location(boardFrac, env.road.lanes + START_X);
        pos1.y = 0.0;
        Coordinate im1 = env.world2image(pos1);

        Position pos2 = Road.location(boardFrac, env.road.lanes + START_X + WIDTH);
        pos2.y = HEIGHT; // For reference: A car is 1 unit tall.
        Coordinate im2 = env.world2image(pos2);

        g.setColor(Color.GRAY);
        int imWidth = im2.x - im1.x;
        int imHeight = im1.y - im2.y;
        g.fillRect(im1.x, im2.y, imWidth, imHeight);
//        System.out.println("x1: " + im1.x + "\t y1: " + im1.y + "\tx2: " + im2.x + "\t y2: " + im2.y);

        // text
        int fontSize = 12;
        Font f = new Font("SANS_SERIF",  Font.BOLD, fontSize);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        g.setColor(Color.black);

        int textX = im1.x + (imWidth - fm.stringWidth(boardText)) / 2;
        int textY = im2.y + ((imHeight - fm.getHeight()) / 2) + fm.getAscent();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.black);
        g2d.drawString(boardText, textX, textY); // bit off center
    }

}
