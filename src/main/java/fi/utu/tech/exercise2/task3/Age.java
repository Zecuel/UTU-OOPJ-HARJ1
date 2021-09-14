package fi.utu.tech.exercise2.task3;

import java.time.LocalDate;

public class Age {

    /**
     * Laskee kuinka paljon aikaa on kulunut annetusta päivämäärästä
     *
     * Ei rajoita parametrejä mitenkään. Syötteenä voi olla ei-positiivinen luku,
     *     tai päivämäärä jota ei ole olemassa, esim. syöte (32, 13, -2000) on
     *     täysin kelvollinen vaikkei sellaista päivämäärää tule koskaan olemaan.
     *     Lisäksi päivämäärän ajankohtaa ei ole mitenkään rajoitettu, eli
     *     syötetty päivämäärä voi olla tulevaisuudessa jolloin ikä on negatiivinen.
     *
     * Metodi käyttää nykyisen ajan hakemiseen käyttäjän aikavöyhykettä.
     *     Tämä ei myöskään tuota oikeata tulosta jos halutaan vaikka
     *     hakea Pohjois-Amerikkalaisen ikää hänen syntymäpäivänsä perusteella,
     *     sillä hänen syntymäpäivänsä on Pohjois-Amerikan aikavyöhykken
     *     mukainen.
     *
     * Metodi ei myöskään huomio esim. karkauspäiviä, karkaussekunteja, aikavyöhykkeiden muuttumista
     *     ajan myötä yms. poikkeuksia ajan laskennassa.
     *
     *
     * @.pre true              -- Parametrejä ei ole rajoitettu mitenkään
     *
     * @.post rawDay == day + 30 * (month + 12 * year) &&
     *        currentDay == LocalDate.now().getDayOfMonth() &&
     *        currentMonth == LocalDate.now().getMonth().getValue() &&
     *        currentYear == LocalDate.now().getYear() &&
     *        rawDay == currentDay + 30 * (currentMonth + 12 * currentYear) &&
     *        difference = rawDay2 - rawDay &&
     *        RESULT == "AGE: " + difference / 30 / 12 + " years " +
     *            (difference / 30) % 12 + " months, " + difference % 30 + " days!"
     *
     */
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
