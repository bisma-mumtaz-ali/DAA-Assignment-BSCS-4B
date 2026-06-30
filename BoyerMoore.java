public class BoyerMoore {

    static final int NO_OF_CHARS = 256;

    static void badCharHeuristic(char[] str, int size,
                                 int[] badChar) {
        for (int i = 0; i < NO_OF_CHARS; i++)
            badChar[i] = -1;

        for (int i = 0; i < size; i++)
            badChar[str[i]] = i;
    }

    static void search(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        int[] badChar = new int[NO_OF_CHARS];

        badCharHeuristic(pat.toCharArray(), m, badChar);

        int s = 0;

        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 &&
                    pat.charAt(j) == txt.charAt(s + j))
                j--;

            if (j < 0) {
                System.out.println(
                        "Pattern found at index " + s);

                s += (s + m < n)
                        ? m - badChar[txt.charAt(s + m)]
                        : 1;
            } else {
                s += Math.max(1,
                        j - badChar[txt.charAt(s + j)]);
            }
        }
    }

    public static void main(String[] args) {

        String txt =
                "Insertion sort typically has a smaller constant factor than merge sort";

        String pat = "sort";

        search(txt, pat);
    }
}