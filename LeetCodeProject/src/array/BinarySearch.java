package array;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int limiteEsq = 0;
        int limiteDir = nums.length - 1;
        int meio = 0;
        while (limiteEsq <= limiteDir) {
            meio = (limiteEsq + limiteDir)/2;
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
}
