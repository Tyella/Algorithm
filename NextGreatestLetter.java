package Algorithm;

public class NextGreatestLetter {
    //寻找比目标字母大的最小字母
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target)
                low = mid + 1;
            else
                high = mid; //mid-1通不过
        }
        return low < n ? letters[low] : letters[0];
    }
}
