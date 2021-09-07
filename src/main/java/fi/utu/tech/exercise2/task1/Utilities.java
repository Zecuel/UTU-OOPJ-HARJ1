package fi.utu.tech.exercise2.task1;

public class Utilities {

    /**
     * Laskee annetun syötevektorin arvojen keskiarvon
     *     ja palauttaa sen Integer tyyppinä
     *
     * @.pre values != null && values.length != 0
     *
     * @.post RESULT == syötteen keskiarvo
     *
     */
    public static Integer average(int[] values) {
        if (values == null || values.length == 0) return null;
        int sum = 0;
        for (var value : values) sum += value;
        return sum / values.length;
    }

    /**
     * Muuttaa syötenumeron oktaalinumeroksi
     *
     * @.pre
     * @.post RESULT == syötteen oktaalinumero
     *
     */
    public static String toOct(int number) {
        String tmp = "";
        do {
            tmp = (number % 8) + tmp;
            number /= 8;
        } while (number > 0);
        return tmp;
    }

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
