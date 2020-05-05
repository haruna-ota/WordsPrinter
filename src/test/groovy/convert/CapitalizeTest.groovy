package convert

import spock.lang.Specification

class CapitalizeTest extends Specification {
    def "Convert"() {
        expect:
        Capitalize.convert(wordList) == exp

        where:
        wordList           | exp
        ["hello", "world"] | ["Hello", "World"]
    }
}
