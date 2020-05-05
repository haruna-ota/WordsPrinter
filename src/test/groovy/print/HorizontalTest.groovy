package print

import spock.lang.Specification

class HorizontalTest extends Specification {
    def "Print"() {
        expect:
        Horizontal.print(word) == exp

        where:
        word               | exp
        ["Hello", "World"] | "Hello World"
    }
}
