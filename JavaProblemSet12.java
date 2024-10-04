public class JavaProblemSet12 {
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static boolean isWeekend(Day day) {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    public static void main(String[] args) {
        Day[] days = Day.values();
        for (Day day : days) {
            System.out.println(day + ": " + (isWeekend(day) ? "Weekend" : "Weekday"));
        }
    }
}