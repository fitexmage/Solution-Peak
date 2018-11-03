import java.util.Scanner;

//A和B两个人轮流进行游戏，从A先开始。
//给定一个整数，如果整数小于等于1，则A获胜。反之，两个人将从整数的因数中选取一个非1和它本身的因数交给下一个人，如果某个人无法从该整数中找到因数，则此人获胜。
//如果A获胜，则输出1以及A第一轮选择的数，如果B获胜，则输出2。
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
