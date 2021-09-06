package fi.utu.tech.exercise2.task3;

import java.time.LocalDate;

public class Age {
    public static void printAge(int day, int month, int year) {
        int rawDay = day + 30 * (month + 12 * year);

        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonth().getValue();
        int currentYear = currentDate.getYear();

        int rawDay2 = currentDay + 30 * (currentMonth + 12 * currentYear);

        int difference = rawDay2 - rawDay;

        System.out.format("Age: %d years %d months, %d days!",
                difference / 30 / 12,
                (difference / 30) % 12,
                difference % 30
        );
    }
}
