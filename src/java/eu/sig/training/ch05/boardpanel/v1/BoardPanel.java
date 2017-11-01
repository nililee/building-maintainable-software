package eu.sig.training.ch05.boardpanel.v1;

import java.awt.Graphics;
import java.util.List;

public class BoardPanel {
    @SuppressWarnings("unused")
    // tag::render[]
    /**
     * 그래픽 콘텍스트에 주어진 대로 사각형 하나를 그린다.
     * 
     * @param square
     *            사각형 객체
     * @param g
     *            그래픽 콘텍스트
     * @param x
     *            그리기 시작 x 좌표
     * @param y
     *            그리기 시작 y 좌표
     * @param w
     *            사각형 너비 (단위: 픽셀)
     * @param h
     *            사각형 높이 (단위: 픽셀)
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
