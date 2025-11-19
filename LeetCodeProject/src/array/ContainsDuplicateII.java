package array;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        if (length <= 1) return false;
        int left = 0, right = 1;
        while (right < length) {
            while (right < length && right - left <= k) {
                if (nums[left] == nums[right]) {
                    return true;
                }
                right++;
            }
            left++;
            right = left + 1;
        }
        return false;
    }
    // Uma solução mais rápida inverte a lógica, percorrendo os valores e validando a condição de índice k.
    // Hashmap para verificar se item já existe, se sim verificamos o K. Isso é bem mais rápido.
}
