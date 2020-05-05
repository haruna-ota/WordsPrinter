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
}
