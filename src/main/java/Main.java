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
        String printOption = list.get(1);

        if (printOption.equals("--horizontal")) {
            System.out.println("半角つなぎ：\n" + Horizontal.print(word));
        } else if (printOption.equals("--vertical")) {
            System.out.println("改行つなぎ：\n" + Vertical.print(word));
        } else {
            throw new RuntimeException("想定外の出力オプションです");
//        }
        }
    }
}
