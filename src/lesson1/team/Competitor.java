package lesson1.team;

public interface Competitor {
    void run(int distance);
    void swim(int distance);
    void jump(int height);
    boolean isOnDistance();
    void info();
}
