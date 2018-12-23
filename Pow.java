package Algorithm;

public class Pow {
    //Pow(x,n)
    public double myPow(double x, int n) {
        if (x == 0) return 0.0;
        if (n == 0) return 1.0;
        double ans = 1.0;
        if (n > 0) {
            ans = myPowRecursive(x, n);
            return ans;
        } else if (n < 0) {
            //int的取值范围为：-2147483648到2147483647,当-2147483648取反时会导致超出int的取值范围
            ans = x * myPowRecursive(x, -(n + 1));    //防止超出int的范围
            return 1.0 / ans;
        }
        return 0;
    }

    private double myPowRecursive(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double res = 1.0;
        res = myPowRecursive(x, n / 2);
        if (n % 2 == 1)
            return x * res * res;
        else
            return res * res;
    }
}
