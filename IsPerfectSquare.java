package Algorithm;

public class IsPerfectSquare {
    //有效的完全平方数
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0)
            return true;
        int low = 1;
        int high = num;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == num)
                return true;
            //if(mid*mid>num)在有些情况下通不过
            if (mid > num / mid)
                high = mid;
            else
                low = mid;
        }
        return false;
    }
}
