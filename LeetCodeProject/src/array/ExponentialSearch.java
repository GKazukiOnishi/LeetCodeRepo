package array;

public class ExponentialSearch {
    private int binarySearch(int[] nums, int target, int limiteEsq, int limiteDir) {
        int meio = 0;
        while (limiteEsq <= limiteDir) {
            meio = (limiteEsq + limiteDir) / 2;
            if (nums[meio] == target) {
                return meio;
            } else if (nums[meio] < target) {
                limiteEsq = meio + 1;
            } else {
                limiteDir = meio - 1;
            }
        }
        return -1;
    }

    public int exponentialSearch(int[] nums, int target) {
        int lenght = nums.length;
        if (lenght <= 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums[0] == target) {
            return 0;
        }

        int limite = 1;
        while (limite < lenght && nums[limite] < target) {
            limite *= 2;
        }

        int limiteInferior = Math.min((limite / 2) + 1, lenght - 1);

        return binarySearch(nums, target, limiteInferior, Math.min(limite * 2, lenght - 1));
    }

    public static void main(String[] args) {
        ExponentialSearch es = new ExponentialSearch();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        int result = es.exponentialSearch(nums, 14);
        System.out.println("Element 14 found at index: " + result);
        result = es.exponentialSearch(nums, 1);
        System.out.println("Element 1 found at index: " + result);
        result = es.exponentialSearch(nums, 2);
        System.out.println("Element 2 found at index: " + result);
        result = es.exponentialSearch(nums, 32);
        System.out.println("Element 32 found at index: " + result);
        result = es.exponentialSearch(nums, 21);
        System.out.println("Element 21 found at index: " + result);
        result = es.exponentialSearch(nums, 33);
        System.out.println("Element 33 found at index: " + result);
    }
}
