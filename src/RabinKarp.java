import java.util.*;

public class RabinKarp {

    private static final int BASE = 256;
    private static final long MOD = 1_000_000_007L;

    // Rabin-Karp string search using polynomial rolling hash
    public static List<Integer> search(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m > n) return matches;

        long patternHash = 0;
        long textHash = 0;
        long power = 1;

        // Precompute BASE^(m-1) % MOD
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }

        // Compute initial hash values for pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            textHash = (textHash * BASE + text.charAt(i)) % MOD;
        }

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                // Verify substring to handle collisions
                if (text.substring(i, i + m).equals(pattern)) {
                    matches.add(i);
                }
            }

            // Compute rolling hash for next window
            if (i < n - m) {
                textHash = (textHash * BASE + text.charAt(i + m)) % MOD;
            }
        }

        return matches;
    }

    public static void main(String[] args) {
        // Short string test
        testCase("Goal by Ronaldo", "Goal");

        // Medium string test
        testCase("Lionel Messi scored a stunning goal for Miami", "Messi");

        // Long string test
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) sb.append("abc");
        testCase(sb.toString(), "bca");
    }

    private static void testCase(String text, String pattern) {
        System.out.println("Text length: " + text.length());
        System.out.println("Pattern: \"" + pattern + "\""); // ✅ fixed here
        long start = System.nanoTime();
        List<Integer> result = search(text, pattern);
        long end = System.nanoTime();
        System.out.println("Matches found at indices: " + result);
        System.out.printf("Execution time: %.4f ms%n", (end - start) / 1e6);
        System.out.println("-------------------------------------");
    }
}
