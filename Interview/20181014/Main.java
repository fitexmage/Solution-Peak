import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 1) {
            System.out.println(1);
            System.out.println(0);
        } else {
            int winNum = winNum(n);
            if (winNum != 0) {
                System.out.println(1);
                System.out.println(winNum);
            } else {
                System.out.println(2);
            }
        }
    }

    static public int winNum(int n) {
        int num = 0;
        for (int i = 2; i <= Math.sqrt(n);) {
            if (n % i == 0) {
                if (num != 0) {
                    return num * i;
                } else {
                    n /= i;
                    num = i;
                }
            } else {
                i++;
            }
        }
        return 0;
    }
}
