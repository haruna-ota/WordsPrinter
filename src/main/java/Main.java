import com.sun.istack.internal.NotNull;
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

        //まず引数の中から変換オプションを全て探す
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("--capitalize") || list.get(i).equals("--reverse")) {
                convertOption.add(list.get(i));
            }
        }
        System.out.println(convertOption);

        //引数の中から出力オプションを探す
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("--horizontal") || list.get(i).equals("--vertical")) {
                printOption = list.get(i);
            }
        }
        System.out.println(printOption);

        //引数の文字列に全ての変換を適用
        List<String> word = Stream.of(list.get(0).split(" ")).collect(Collectors.toList());
        System.out.println("変換前：" + word);

        for (int i = 0; i < convertOption.size(); i++) {
            word = convert(convertOption.get(i), word);
        }
        System.out.println("変換後：" + word);

        System.out.println("完成：" + print(printOption, word));

//        String convertOption = null;
//        String printOption = null;
//        List<String> word = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("--horizontal") || list.get(i).equals("--vertical")) {
//                printOption = list.get(i);
//            } else if (list.get(i).equals("--capitalize") || list.get(i).equals("--reverse")) {
//                convertOption = list.get(i);
//            } else {
//                word = Stream.of(list.get(i).split(" ")).collect(Collectors.toList());
//            }
//        }
//
//        System.out.println(word + " " + convertOption + " " + printOption);
//        System.out.println(printWord(word, convertOption, printOption));
//    }
//
//    public static String printWord(List<String> word, String convertOption, String printOption) {
//        if (printOption.equals("--horizontal")) {
//            if (convertOption.equals("--capitalize")) {
//                return (Horizontal.print(Capitalize.convert(word)));
//            } else if (convertOption.equals("--reverse")) {
//                return (Horizontal.print(Reverse.convert(word)));
//            } else {
//                throw new RuntimeException("想定外の変換オプションです");
//            }
//        } else if (printOption.equals("--vertical")) {
//            if (convertOption.equals("--capitalize")) {
//                return (Vertical.print(Capitalize.convert(word)));
//            } else if (convertOption.equals("--reverse")) {
//                return (Vertical.print(Reverse.convert(word)));
//            } else {
//                throw new RuntimeException("想定外の変換オプションです");
//            }
//        } else {
//            throw new RuntimeException("想定外の出力オプションです");
//        }
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
