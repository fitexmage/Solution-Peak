import java.util.ArrayList;
import java.util.List;

//输入一个列表的单词，及一个长字符串，判断字符串是否能由列表中的单词组成。
//补充条件：一个单词可以被使用多次；每个单词不必都被用上；不允许以单词重叠的方式组成字符串。

//输入:['I', 'love', 'byte', 'bytedance], 'Ilovebytedance'
//输出:true

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("I");
        list.add("love");
        list.add("byte");
        list.add("bytedance");
        String string = "Ilovebytedance";
        System.out.println(solution(list, string));
    }

    static public boolean solution(List<String> list, String string) {
        boolean[] checks = new boolean[string.length() + 1];
        checks[0] = true;

        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (checks[j] == true && list.contains(string.substring(j, i))) {
                    checks[i] = true;
                }
            }
        }
        return checks[string.length()];
    }
}
