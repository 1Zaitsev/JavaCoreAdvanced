package lesson1.team;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public void run(int distance) {
        if(distance <= maxRunDistance) {
            System.out.println("Type: " + type + ", name: " + name + " ran through the distance - " + distance + ".");
        }
        else{
            System.err.println("Type: " + type + ", name: " + name + " failed the cross (distance - " + distance + ").");
            onDistance = false;
        }
    }

    public void swim(int distance) {
        if(distance <= maxSwimDistance) {
            System.out.println("Type: " + type + ", name: " + name + " swam through the distance - " + distance + ".");
        }
        else{
            System.err.println("Type: " + type + ", name: " + name + " failed the swim (distance - " + distance + ").");
            onDistance = false;
        }
    }

    public void jump(int height) {
        if(height <= maxJumpHeight) {
            System.out.println("Type: " + type + ", name: " + name + " jumped over the wall height - " + height + ".");
        }
        else{
            System.err.println("Type: " + type + ", name: " + name + " failed the jump (height - " + height + ").");
            onDistance = false;
        }
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void info() {
        System.out.println(type +" "+ name + " " + onDistance);
    }
}