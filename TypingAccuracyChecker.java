
public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int length = Math.min(original.length(), typed.length());
        int firstMismatch = -1;

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = original.isEmpty() && typed.isEmpty()
                ? 100.0
                : (original.isEmpty() ? 0.0
                : matched * 100.0 / Math.max(original.length(), typed.length()));

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matched, original.length(), accuracy);

        if (firstMismatch != -1) {
            System.out.printf(
                " | First Mismatch at position %d ('%c' vs '%c')",
                firstMismatch + 1,
                original.charAt(firstMismatch),
                typed.charAt(firstMismatch));
        } else if (original.length() != typed.length()) {
            System.out.println(" | Length Mismatch");
            return;
        } else {
            System.out.print(" | No Mismatches");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
