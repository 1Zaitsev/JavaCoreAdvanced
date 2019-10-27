package lesson1.course;

import lesson1.team.Competitor;
import lesson1.team.Team;

public class Course {
    Obstacle[] course;

    public Course(Obstacle... course) {
        this.course = course;
    }

    public void start(Team team){
        for(Competitor t: team.getTeam()){
            for(Obstacle o: course){
                o.doIt(t);
                if(!t.isOnDistance()) break;
            }
        }
    }
}