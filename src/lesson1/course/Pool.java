package lesson1.course;

import lesson1.team.Competitor;

public class Pool extends Obstacle {
    int distance;

    public Pool(int distance) {
        this.distance = distance;
    }

    public void doIt(Competitor competitor) {
        competitor.swim(distance);
    }
}
