import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MainTest extends Specification {
    def "printWord"() {
        expect:
        Main.printWord(word, convertOption, printOption) == exp

        where:
        word               | convertOption                 | printOption    | exp
        ["hello", "world"] | ["--capitalize"]              | "--horizontal" | "Hello World"
        ["hello", "world"] | ["--reverse"]                 | "--vertical"   | "world\nhello"
        ["hello", "world"] | ["--capitalize", "--reverse"] | "--horizontal" | "World Hello"
    }

    def "ConvertOption例外発生"() {
        when:
        Main.printWord(["hello", "world"], ["--none"], "--horizontal")

        then:
        RuntimeException e = thrown()
        e.getMessage() == "想定外の変換オプションです"
    }

    def "PrintOption例外発生"() {
        when:
        Main.printWord(["hello", "world"], ["--capitalize"], "--none")

        then:
        RuntimeException e = thrown()
        e.getMessage() == "想定外の出力オプションです"
    }
}
