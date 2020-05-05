package print

import spock.lang.Specification

class VerticalTest extends Specification {
    def "Print"() {
        expect:
        Vertical.print(word) == exp

        where:
        word               | exp
        ["Hello", "World"] | "Hello\nWorld"
    }
}
