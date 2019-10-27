package lesson1.team;

public class Team {
    String title;
    Competitor[] team;

    public Team(String title, Competitor...team) {
        this.title = title;
        this.team = team;
    }

    public Competitor[] getTeam() {
        return team;
    }

    public void showResult(){
        for(Competitor t: team){
            if(t.isOnDistance())
                t.info();
        }
    }
}
