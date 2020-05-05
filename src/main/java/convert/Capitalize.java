package convert;

import java.util.List;
import java.util.stream.Collectors;

public class Capitalize {
    //各単語の先頭１文字を大文字にする。
    public static List<String> convert(List<String> word) {
        return word.stream().map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).collect(Collectors.toList());
    }
}
