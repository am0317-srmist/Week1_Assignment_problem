
public class WarehouseInventory {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int max = Integer.MIN_VALUE;
        String section = "";
        int index = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];

            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "Section A";
                index = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];

            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "Section B";
                index = i + 1;
            }
        }

        String status = totalA == totalB
                ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + max
                + " (" + section + ", Item " + index + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
