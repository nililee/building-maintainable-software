package eu.sig.training.ch05.boardpanel.v1;

import java.awt.Graphics;
import java.util.List;

public class BoardPanel {
    @SuppressWarnings("unused")
    // tag::render[]
    /**
     * �׷��� ���ؽ�Ʈ�� �־��� ��� �簢�� �ϳ��� �׸���.
     * 
     * @param square
     *            �簢�� ��ü
     * @param g
     *            �׷��� ���ؽ�Ʈ
     * @param x
     *            �׸��� ���� x ��ǥ
     * @param y
     *            �׸��� ���� y ��ǥ
     * @param w
     *            �簢�� �ʺ� (����: �ȼ�)
     * @param h
     *            �簢�� ���� (����: �ȼ�)
     */
    private void render(Square square, Graphics g, int x, int y, int w, int h) {
        square.getSprite().draw(g, x, y, w, h);
        for (Unit unit : square.getOccupants()) {
            unit.getSprite().draw(g, x, y, w, h);
        }
    }
    // end::render[]

    private class Sprite {
        @SuppressWarnings("unused")
        public void draw(Graphics g, int x, int y, int w, int h) {

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
