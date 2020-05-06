import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MainTest extends Specification {
    def "ConvertOption"() {
        expect:
        Main.convert(option, word) == exp

        where:
        option         | word               | exp
        "--capitalize" | ["hello", "world"] | ["Hello", "World"]
        "--reverse"    | ["hello", "world"] | ["world", "hello"]
    }

    def "ConvertOption例外発生"() {
        when:
        Main.convert("--none", ["hello", "world"])

        then:
        RuntimeException e = thrown()
        e.getMessage() == "想定外の変換オプションです"
    }

    def "PrintOption"() {
        expect:
        Main.print(option, word) == exp

        where:
        option         | word               | exp
        "--horizontal" | ["Hello", "World"] | "Hello World"
        "--vertical"   | ["world", "hello"] | "world\nhello"
    }

    def "PrintOption例外発生"() {
        when:
        Main.print("--none", ["hello", "world"])

        then:
        RuntimeException e = thrown()
        e.getMessage() == "想定外の出力オプションです"
    }
}
