import convert.Capitalize;
import convert.Reverse;
import print.Horizontal;
import print.Vertical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);

        //変換オプション
        List<String> convertOption = new ArrayList<>();
        //出力オプション
        String printOption = "";
        //文字列
        List<String> word = new ArrayList<>();

        //まず引数の中から変換オプション,出力オプション、文字を全て探す
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("--capitalize") || list.get(i).equals("--reverse")) {
                convertOption.add(list.get(i));
            } else if (list.get(i).equals("--horizontal") || list.get(i).equals("--vertical")) {
                printOption = list.get(i);
            } else {
                word = Stream.of(list.get(i).split(" ")).collect(Collectors.toList());
            }
        }
        System.out.println(convertOption);
        System.out.println(printOption);
        System.out.println("変換前：" + word);

        //引数の文字列に全ての変換を適用
        for (int i = 0; i < convertOption.size(); i++) {
            word = convert(convertOption.get(i), word);
        }
        System.out.println("変換後：" + word);

        System.out.println("完成：" + print(printOption, word));
    }

    public static List<String> convert(String convertOption, List<String> word) {
        if (convertOption.equals("--capitalize")) {
            return Capitalize.convert(word);
        } else if (convertOption.equals("--reverse")) {
            return Reverse.convert(word);
        } else {
            throw new RuntimeException("想定外の変換オプションです");
        }
    }

    public static String print(String printOption, List<String> word) {
        if (printOption.equals("--horizontal")) {
            return Horizontal.print(word);
        } else if (printOption.equals("--vertical")) {
            return Vertical.print(word);
        } else {
            throw new RuntimeException("想定外の出力オプションです");
        }
    }
}
