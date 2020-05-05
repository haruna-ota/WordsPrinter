import convert.Capitalize;
import convert.Reverse;
import print.Horizontal;
import print.Vertical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        List<String> word = Stream.of(list.get(0).split(" ")).collect(Collectors.toList());
        String convertOption = list.get(1);
        String printOption = list.get(2);
        System.out.println(word + " " + convertOption + " " + printOption);
        System.out.println(printWord(word, convertOption, printOption));
    }

    public static String printWord(List<String> word, String convertOption, String printOption) {
        if (printOption.equals("--horizontal")) {
            if (convertOption.equals("--capitalize")) {
                return (Horizontal.print(Capitalize.convert(word)));
            } else if (convertOption.equals("--reverse")) {
                return (Horizontal.print(Reverse.convert(word)));
            } else {
                throw new RuntimeException("想定外の変換オプションです");
            }
        } else if (printOption.equals("--vertical")) {
            if (convertOption.equals("--capitalize")) {
                return (Vertical.print(Capitalize.convert(word)));
            } else if (convertOption.equals("--reverse")) {
                return (Vertical.print(Reverse.convert(word)));
            } else {
                throw new RuntimeException("想定外の変換オプションです");
            }
        } else {
            throw new RuntimeException("想定外の出力オプションです");
        }
    }
}
