package convert;

import java.util.Collections;
import java.util.List;

public class Reverse {
    //単語の順番を逆順にする。
    public static List<String> convert(List<String> wordList) {
        Collections.reverse(wordList);
        return wordList;
    }
}
