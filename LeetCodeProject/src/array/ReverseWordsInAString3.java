package array;

public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        char aux;
        int start = 0;
        int end = 0;
        int space = 0;
        int length = s.length();

        while (end < length) {
            if (array[end] != ' ') {
                space = ++end;
            } else {
                end--;
                while (start < end) {
                    aux = array[start];
                    array[start] = array[end];
                    array[end] = aux;
                    start++;
                    end--;
                }
                start = space + 1;
                end = start;
            }
        }

        end--;
        while (start < end) {
            aux = array[start];
            array[start] = array[end];
            array[end] = aux;
            start++;
            end--;
        }

        return new String(array);
    }
}
