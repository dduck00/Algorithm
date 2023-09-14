package leetcode

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class Solution332Test {
    private lateinit var sut: Solution332

    @BeforeEach
    fun setup() {
        sut = Solution332()
    }

    class Solution332Provider : ArgumentsProvider {
        private fun argumentGenerator(
            tickets: List<List<String>>,
            expected: List<String>,
        ): Arguments {
            return Arguments.of(tickets, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    tickets = listOf(
                        listOf("JFK", "SFO"),
                        listOf("JFK", "ATL"),
                        listOf("SFO", "ATL"),
                        listOf("ATL", "JFK"),
                        listOf("ATL", "SFO")
                    ),
                    expected = listOf("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")
                ),
                argumentGenerator(
                    tickets = listOf(
                        listOf("MUC", "LHR"),
                        listOf("JFK", "MUC"),
                        listOf("SFO", "SJC"),
                        listOf("LHR", "SFO")
                    ),
                    expected = listOf("JFK", "MUC", "LHR", "SFO", "SJC")
                ),
                argumentGenerator(
                    tickets = listOf(
                        listOf("JFK", "KUL"),
                        listOf("JFK", "NRT"),
                        listOf("NRT", "JFK"),
                    ),
                    expected = listOf("JFK", "NRT", "JFK", "KUL")
                ),
                argumentGenerator(
                    tickets = listOf(
                        listOf("EZE", "AXA"),
                        listOf("TIA", "ANU"),
                        listOf("ANU", "JFK"),
                        listOf("JFK", "ANU"),
                        listOf("ANU", "EZE"),
                        listOf("TIA", "ANU"),
                        listOf("AXA", "TIA"),
                        listOf("TIA", "JFK"),
                        listOf("ANU", "TIA"),
                        listOf("JFK", "TIA")
                    ),
                    expected = listOf("JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK")
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution332Provider::class)
    fun testSolution(
        tickets: List<List<String>>,
        expected: List<String>,
    ) {
        // given

        // when
        val result = sut.findItinerary(tickets)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
