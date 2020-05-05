package print;

import java.util.List;

public class Horizontal {
    public static void print(List<String> word) {
        String horizontal = String.join(" ", word);
        System.out.println("半角つなぎ：\n" + horizontal);
    }
}
