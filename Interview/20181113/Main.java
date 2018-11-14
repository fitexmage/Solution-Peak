
import java.util.ArrayList;
import java.util.List;

//输入一个列表的单词，及一个长字符串，判断字符串是否能由列表中的单词组成。
//补充条件：一个单词可以被使用多次；每个单词不必都被用上；不允许以单词重叠的方式组成字符串。
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
        return split(list, string);
    }

    static public boolean split(List<String> list, String string) {
        if (string.equals("")) {
            return true;
        }
        if (list.isEmpty()) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            list.remove(s);
            String[] word_list = string.split(s);
            boolean check = true;
            for (String word : word_list) {
                check = check && split(list, word);
            }
            list.add(i, s);
            if (check) {
                return true;
            }
        }
        return false;
    }
}