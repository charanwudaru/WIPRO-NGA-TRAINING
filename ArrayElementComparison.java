public class ArrayElementComparison {
    public static void main(String[] args) {
        int arr1[] = { 1, 23, 43, 44 };
        int arr2[] = { 2, 3, 32, 41 };

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                System.out.println("greater than arr2");
            } else if (arr1[i] < arr2[i]) {
                System.out.println("less than arr2");
            } else {
                System.out.println("equal try git commends");
            }
        }
    }
}
