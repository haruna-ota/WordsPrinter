import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MainTest extends Specification {
    def "PrintWord"() {
        expect:
        Main.printWord(word, convertOption, printOption) == exp

        where:
        word               | convertOption  | printOption    | exp
        ["hello", "world"] | "--capitalize" | "--horizontal" | "Hello World"
        ["hello", "world"] | "--reverse"    | "--horizontal" | "world hello"
        ["hello", "world"] | "--capitalize" | "--vertical"   | "Hello\nWorld"
        ["hello", "world"] | "--reverse"    | "--vertical"   | "world\nhello"
    }

    def "PrintWord変換例外発生"() {
        when:
        Main.printWord(["hello", "world"], "--none", "--horizontal")

        then:
        RuntimeException e = thrown()
        e.getMessage() == "想定外の変換オプションです"
    }

    def "PrintWord出力例外発生"() {
        when:
        Main.printWord(["hello", "world"], "--reverse", "--none")

        then:
        RuntimeException e = thrown()
        e.getMessage() == "想定外の出力オプションです"
    }
}
