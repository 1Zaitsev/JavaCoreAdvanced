package lesson2.myEnum;

public enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY( 0), SUNDAY(0);

    int hours;

    DayOfWeek(){
        this.hours = 8;
    }

    DayOfWeek(int hours){
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public static int getWorkingHours(DayOfWeek day){
        if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
            System.out.println("It's weekend!");
            return 0;
        }
        else{
            return (5 - day.ordinal()) * day.getHours();
        }
    }
}
