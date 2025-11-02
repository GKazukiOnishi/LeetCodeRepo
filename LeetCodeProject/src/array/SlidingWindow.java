package array;

import java.util.HashMap;

public class SlidingWindow {

    private static long slidingWindow(String in) {
        char[] charArray = in.toCharArray();
        int left = 0, right = 0;
        long maxSize = 0, size;
        HashMap<Character, Long> characterHashMap = new HashMap<Character, Long>();
        while (true) {
            if (characterHashMap.containsKey(charArray[right])) {
                characterHashMap.put(charArray[right], characterHashMap.get(charArray[right]) + 1);
            } else {
                characterHashMap.put(charArray[right], 1L);
            }

            if (characterHashMap.get(charArray[right]) == 3L) {
                size = right - left;
                if (size > maxSize) {
                    maxSize = size;
                }
                while (true) {
                    characterHashMap.put(charArray[left], characterHashMap.get(charArray[left]) - 1);
                    left++;
                    if (characterHashMap.get(charArray[right]) != 3L) {
                        break;
                    }
                }
            }
            right++;

            if (right == charArray.length) {
                size = right - left;
                if (size > maxSize) {
                    maxSize = size;
                }
                break;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(slidingWindow("acbbabcgfccff"));
        System.out.println(slidingWindow("acbbabcgfccfff"));
        System.out.println(slidingWindow("acbbabcgfccfffc"));
        System.out.println(slidingWindow("bcbbbcba"));
    }

}
