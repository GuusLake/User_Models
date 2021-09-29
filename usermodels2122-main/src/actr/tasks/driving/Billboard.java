package actr.tasks.driving;

import java.awt.*;

public class Billboard {
    final boolean INTERESTING = false;
    final double WIDTH = 2.5;
    final double HEIGHT = 2;
    final double START_X = 1.28;
    double boardOnSet = 0;
    Position boardPos;
    double boardFrac;
    boolean visible = false;
    boolean newBoard = false;
    int boardNumber = 0;

    public Billboard() {
        BillboardText.initialize();
    }

    void update(Env env) {
        double time = env.time;
//        if (time >= 5) {
            if ((int) (time + 3) % 7 == 0 && !visible) {
                boardNumber++;
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
        if (INTERESTING) {
            drawText(g, im1.x, im2.y, imWidth, imHeight);
        }
    }

    void drawText(Graphics g, int boardX, int boardY, int boardWidth, int boardHeight) {
        int fontSize = 60;
        String boardText1 = BillboardText.getBoard(boardNumber)[0];
        String boardText2 = BillboardText.getBoard(boardNumber)[1];
        Font f = new Font("MONOSPACED", Font.BOLD, fontSize);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        while (fm.stringWidth(boardText1) > boardWidth) {
            fontSize--;
            f = f.deriveFont((float)fontSize);
            g.setFont(f);
            fm = g.getFontMetrics();
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.black);

        int textX = boardX + (boardWidth - fm.stringWidth(boardText1)) / 2;
        int textY = boardY + ((boardHeight - fm.getHeight()*2) / 2) + fm.getAscent();
        g2d.drawString(boardText1, textX, textY);
        textX = boardX + (boardWidth - fm.stringWidth(boardText2)) / 2;
        textY += fm.getHeight();
        g2d.drawString(boardText2, textX, textY);
    }

}