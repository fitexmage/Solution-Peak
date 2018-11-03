//Each time can climb 1 or 2 stairs.
//Given number of stairs n, find the number of possible ways.

public class ClimbStair {
    public int count(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return count(n - 1) + count(n - 2);
        }
    }
}
