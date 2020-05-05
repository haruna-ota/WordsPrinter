package print;

import java.util.List;

public class Vertical {
    public static void print(List<String> word) {
        String vertical = String.join("\n", word);
        System.out.println("改行つなぎ：\n" + vertical);
    }
}
