package dynamicProgramming;

public class ClimbingStairsVFibonacci {
    /**
     * Para cada valor de N, a resposta eh o fibonacci de N.
     * N = 1 -> 1
     * N = 2 -> 2
     * N = 3 -> 3
     * N = 4 -> 5
     * N = 5 -> 8
     * N = 6 -> 13
     * N = 7 -> 21
     * N = 8 -> 34
     * N = 9 -> 55
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || i == 1) {
                continue;
            }


        }

        return result;
    }

    public static void main(String[] args) {
        ClimbingStairsVFibonacci climbingStairs = new ClimbingStairsVFibonacci();
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(5));
        System.out.println(climbingStairs.climbStairs(6));
        System.out.println(climbingStairs.climbStairs(45));
    }
}
