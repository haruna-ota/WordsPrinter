package convert

import spock.lang.Specification

class ReverseTest extends Specification {
    def "Convert"() {
        expect:
        Reverse.convert(wordList) == exp

        where:
        wordList           | exp
        ["hello", "world"] | ["world", "hello"]
    }
}
