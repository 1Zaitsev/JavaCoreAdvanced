package lesson2.myEnum;

public class DayOfWeekDemo {
    public static void main(String[] args) {
        for (DayOfWeek day: DayOfWeek.values()) {
            System.out.println(day + "- до конца рабочей недели " + DayOfWeek.getWorkingHours(day) + " часов.");
        }
    }
}
