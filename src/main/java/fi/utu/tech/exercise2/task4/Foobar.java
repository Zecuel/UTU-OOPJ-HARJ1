package fi.utu.tech.exercise2.task4;

import java.util.Arrays;

public class Foobar {
    /**
     * Internal implementation - no documentation!
     * Don't use directly.
     *
     * @.pre input != null
     */
    private static int[] foo(int[] input) {
        var tmp = new int[1 + input.length << 1];

        for (var e : input) {
            var has_e = false;
            for (var i = 1; i <= tmp[0]; i++)
                has_e |= tmp[i] == e;
            if (!has_e)
                tmp[++tmp[0]] = e;
        }

        return Arrays.copyOfRange(tmp, 1, tmp[0] + 1);
    }

    /**
     * Internal implementation - no documentation!
     * Don't use directly.
     *
     * @.pre input != null
     */
    private static int[] bar(int[] input) {
        var k = input.length;
        var tmp = new int[k];
        for (int i = 0; i < k; i++) tmp[i] = input[i];

        for (int i = 0; i < k; i++)
            for (int j = i; j < k; j++)
                if (tmp[i] > tmp[j]) {
                    k = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = k;
                    k = input.length;
                }
        return tmp;
    }

    /**
     * Performs the special 'foobar' operation. Works with any
     * array of integers as input, even empty ones.
     *
     * @.pre input != null
     * @.post
     *   FORALL(e: input; EXISTS (re: RESULT; re = = e)) &&
     *   FORALL(i: 0 <= i < RESULT.length;
     *     FORALL(j: i < j < RESULT.length; RESULT[i] < RESULT[j]))
     */
    public static int[] foobar(int[] input) {
        return bar(foo(input));
    }
}
