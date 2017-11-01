package eu.sig.training.ch05.boardpanel.v3;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import eu.sig.training.ch05.boardpanel.v2.Rectangle;

public class BoardPanel {
    @SuppressWarnings("unused")
    /**
     * 그래픽 콘텍스트에 주어진 대로 사각형 하나를 그린다.
     * 
     * @param square
     *            사각형 객체
     * @param g
     *            그래픽 콘텍스트
     * @param r
     *            사각형을 그릴 때 필요한 좌표와 크기
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
