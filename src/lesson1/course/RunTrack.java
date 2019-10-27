package lesson1.course;

import lesson1.team.Competitor;

public class RunTrack extends Obstacle{
    int distance;

    public RunTrack(int distance) {
        this.distance = distance;
    }

    public void doIt(Competitor competitor) {
        competitor.run(distance);
    }
}
