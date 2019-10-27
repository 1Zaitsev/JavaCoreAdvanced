
package lesson1;

import lesson1.course.*;
import lesson1.team.*;

public class MarathonDemo {
    public static void main(String[] args) {

        Competitor human1 = new Human("Igor", 600, 200, 1);
        Competitor human2 = new Human("Ksenia", 550, 250, 1);
        Competitor cat1 = new Cat("Frank", 150, 0, 4);
        Competitor cat2 = new Cat ("Space", 50, 0, 6);
        Competitor dog = new Dog("Dream", 400, 150, 1);

        Team team1 = new Team("Lakers LA", human1, cat1, cat2);
        Team team2 = new Team("DreamTeam", human2, dog);

        Course course = new Course(new RunTrack(200), new Wall(1), new Pool(200), new Wall(0));

        course.start(team1);
        team1.showResult();

        course.start(team2);
        team2.showResult();
    }
}
