package fi.utu.tech.exercise2.task1;

public class Utilities {

    /**
     * Laskee annetun syötevektorin arvojen keskiarvon
     *     ja palauttaa sen Integer tyyppinä
     *     tai null jos alkuehdot eivät toteudu
     *
     * @.pre values != null &&
     *       values.length != 0
     *
     * @.post RESULT == syötevektorin arvojen keskiarvo ||
     *        RESULT == null
     *
     */
    public static Integer average(int[] values) {
        if (values == null || values.length == 0) return null;
        int sum = 0;
        for (var value : values) sum += value;
        return sum / values.length;
    }

    /**
     * Muuttaa syötenumeron oktaaliesitykseksi jos syöte positiivinen
     *     muutoin palauttaa tyhjän merkkijonon
     *
     * @.pre true
     * @.post RESULT == FORALL(
     *     i : 0 <= i < RESULT.length;
     *     RESULT[(RESULT.length - 1) - i] == prependIntToString(
     *         RESULT[Result.length - 1 - i],
     *         getOctalRemainder(number / ((i + 1) * 8)
     *     )
     *
     * )
     *
     */
    public static String toOct(int number) {
        String tmp = "";
        do {
            tmp = prependIntToString(tmp, getOctalRemainder(number));
            number /= 8;
        } while (number > 0);
        return tmp;
    }

    /**
     * Lisää annetun luvun annetun merkkijonon alkuun
     *
     * @.pre true
     * @.post RESULT == value + OLD(input)
     *
     */
    public static String prependIntToString(String input, int value) {
        return value + input;
    }

    /**
     * Palauttaa annetun numeron oktaalijäännöksen
     * ( ==> numeron jakojäännös, kun jaetaan 8:lla )
     *
     * @.pre true
     * @.post RESULT == number % 8
     */
    public static int getOctalRemainder(int number) {
        return number % 8;
    }

    /**
     * Koodaa annetun syötteen ROT13 algoritmillä
     * Algoritmi muuttaa jokaisen syötteen kirjaimen
     *     vaihtamalla sen kirjaimeen, joka on akkosissa
     *     13 merkin päässä itsestään
     *
     * Tässä toteutuksessa kirjaimen siirtämisen suunta (+13, tai -13)
     *     riippuu kirjaimesta. Välillä "A-M" kerroin on positiivinen,
     *     jolloin algoritmi siirtää kirjainta eteenpäin 13 kirjainta,
     *     ja välillä "N-Z" algoritmi siirtää kirjainta taaksepäin 13 kirjainta.
     *     Tämän määrittävä osa ottaa huomioon myös pienet kirjaimet, joihin pätee
     *     samat säännöt kuin edellä esitettyihin isoihin kirjaimiin.
     *     Jos taas kirjain ei ole A-Z (tai a-z) välillä, algoritmi pitää
     *     kirjaimen saman kuin se oli, sillä <kirjain> + 13 * 0 ==> <kirjain>
     *
     * Kirjaimilla on suoraan numeroesitys, joten toteutus voi verrata kirjaimia
     *     ikäänkuin numeroina.
     *
     * Jos annettu syöte on tyhjä, toteutus palauttaa vain tyhjän merkkijonon.
     *
     * @.pre true
     *
     * @.post RESULT == FORALL(
     *     c : 0 <= c < input.length;
     *     RESULT[c] == (char) OLD(input[c]) + 13 ||
     *     RESULT[c] == (char) OLD(input[c])
     * )
     *
     */
    public static String rot13(String input) {
        String tmp = "";
        for (var c : input.toCharArray())
            tmp += (char) (c + 13 * (
                    c >= 'a' && c <= 'm' ? 1 :
                    c >= 'A' && c <= 'M' ? 1 :
                    c >= 'n' && c <= 'z' ? -1 :
                    c >= 'N' && c <= 'Z' ? -1 : 0));
        return tmp;
    }
}
