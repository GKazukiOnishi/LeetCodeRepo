package array;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    class Tupla {
        int count;
        int index;

        Tupla(int count, int index) {
            this.count = count;
            this.index = index;
        }
    }

    public int firstUniqChar(String s) {
        Map<Character, Tupla> map = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.containsKey(c)) {
                Tupla t = map.get(c);
                t.count++;
            } else {
                map.put(c, new Tupla(1, i));
            }
        }

        for (Tupla t : map.values()) {
            if (t.count == 1) {
                return t.index;
            }
        }
        return -1;
    }
}
