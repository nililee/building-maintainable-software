package eu.sig.training.ch02;

import java.util.List;

public class Level {
    private boolean inProgress;
    private final List<LevelObserver> observers;

    Level(List<LevelObserver> observers) {
        this.observers = observers;
    }

    // tag::start[]
    public void start() {
        if (inProgress) {
            return;
        }
        inProgress = true;
        // 팩맨이 죽으면 옵저버를 업데이트한다
        if (!isAnyPlayerAlive()) {
            for (LevelObserver o : observers) {
                o.levelLost();
            }
        }
        // 알을 다 먹으면 옵저버를 업데이트한다
        if (remainingPellets() == 0) {
            for (LevelObserver o : observers) {
                o.levelWon();
            }
        }
    }
    // end::start[]

    @SuppressWarnings("unused")
    // tag::updateObservers[]
    private void updateObservers() {
        // 팩맨이 죽으면 옵저버를 업데이트한다
        if (!isAnyPlayerAlive()) {
            for (LevelObserver o : observers) {
                o.levelLost();
            }
        }
        // 알을 다 먹으면 옵저버를 업데이트한다
        if (remainingPellets() == 0) {
            for (LevelObserver o : observers) {
                o.levelWon();
            }
        }
    }
    // end::updateObservers[]

    @SuppressWarnings("unused")
    // tag::updateObserversPlayerDied[]
    private void updateObserversPlayerDied() {
        if (!isAnyPlayerAlive()) {
            for (LevelObserver o : observers) {
                o.levelLost();
            }
        }
    }

    // end::updateObserversPlayerDied[]

    @SuppressWarnings("unused")
    // tag::updateObserversPelletsEaten[]
    private void updateObserversPelletsEaten() {
        if (remainingPellets() == 0) {
            for (LevelObserver o : observers) {
                o.levelWon();
            }
        }
    }
    // end::updateObserversPelletsEaten[]

    private int remainingPellets() {
        return 0;
    }

    private boolean isAnyPlayerAlive() {
        return false;
    }
}

class LevelObserver {
    public void levelLost() {}
    public void levelWon() {}
}
