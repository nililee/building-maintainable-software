package eu.sig.training.ch05.boardpanel.v3;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import eu.sig.training.ch05.boardpanel.v2.Rectangle;

public class BoardPanel {
    @SuppressWarnings("unused")
    /**
     * �׷��� ���ؽ�Ʈ�� �־��� ��� �簢�� �ϳ��� �׸���.
     * 
     * @param square
     *            �簢�� ��ü
     * @param g
     *            �׷��� ���ؽ�Ʈ
     * @param r
     *            �簢���� �׸� �� �ʿ��� ��ǥ�� ũ��
     */
    // tag::render[]
    private void render(Square square, Graphics g, Rectangle r) {
        Point position = r.getPosition();
        square.getSprite().draw(g, r);
        for (Unit unit : square.getOccupants()) {
            unit.getSprite().draw(g, r);
        }
    }
    // end::render[]

    private class Sprite {
        @SuppressWarnings("unused")
        public void draw(Graphics g, Rectangle r) {

        }
    }

    private class Unit {
        public Sprite getSprite() {
            return null;
        }
    }

    private class Square extends Unit {

        public List<Unit> getOccupants() {
            return null;
        }

    }
}
