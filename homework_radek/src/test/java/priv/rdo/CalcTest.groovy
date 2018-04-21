package priv.rdo

import spock.lang.Specification
import spock.lang.Unroll

class CalcTest extends Specification {

    @Unroll
    def "add should return #expectedResult for #left and #right"() {
        given:
            Calc calc = new Calc()

        when:
            def result = calc.add(left, right)

        then:
            result == expectedResult

        where:
            left | right || expectedResult
            1    | 2     || 3
            2    | 2     || 4
            4    | 2     || 6
    }
}
