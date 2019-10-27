package lesson1.team;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;

    boolean onDistance;

    public Human(String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public void run(int distance) {
        if(distance <= maxRunDistance) {
            System.out.println("Human, name: " + name + " ran through the distance - " + distance + ".");
        }
        else{
            System.err.println("Human, name: " + name + " failed the cross (distance - " + distance + ").");
            onDistance = false;
        }
    }

    public void swim(int distance) {
        if(distance <= maxSwimDistance) {
            System.out.println("Human, name: " + name + " swam through the distance - " + distance + ".");
        }
        else{
            System.err.println("Human, name: " + name + " failed the swim (distance - " + distance + ").");
            onDistance = false;
        }
    }

    public void jump(int height) {
        if(height <= maxJumpHeight) {
            System.out.println("Human, name: " + name + " jumped over the wall height - " + height + ".");
        }
        else{
            System.err.println("Human, name: " + name + " failed the jump (height - " + height + ").");
            onDistance = false;
        }
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void info() {
        System.out.println("Human " + name + " " + onDistance);
    }
}
