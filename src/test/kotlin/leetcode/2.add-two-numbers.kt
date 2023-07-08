package leetcode

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import java.util.stream.Stream
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

class SolutionAddTwoNumbersTest {
    private lateinit var sut: SolutionAddTwoNumbers

    @BeforeEach
    fun setup() {
        sut = SolutionAddTwoNumbers()
    }

    class TwoSumArgumentsProvider : ArgumentsProvider {
        private fun argumentGenerator(
            l1: SolutionAddTwoNumbers.ListNode,
            l2: SolutionAddTwoNumbers.ListNode,
            expected: List<Int>,
        ): Arguments {
            return Arguments.of(l1, l2, expected)
        }

        private fun listNodeGenerator(input: List<Int>): SolutionAddTwoNumbers.ListNode {
            val result = input.map {
                SolutionAddTwoNumbers.ListNode(it)
            }.let { result ->
                result.forEachIndexed { index, listNode ->
                    if (index != result.size - 1)
                        listNode.next = result[index + 1]
                }
                result
            }
            return result.first()
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    l1 = listNodeGenerator(listOf(2, 4, 3)),
                    l2 = listNodeGenerator(listOf(5, 6, 4)),
                    expected = listOf(7, 0, 8),
                ),
                argumentGenerator(
                    l1 = listNodeGenerator(listOf(0)),
                    l2 = listNodeGenerator(listOf(0)),
                    expected = listOf(0),
                ),
                argumentGenerator(
                    l1 = listNodeGenerator(listOf(9,9,9,9,9,9,9)),
                    l2 = listNodeGenerator(listOf(9,9,9,9)),
                    expected = listOf(8,9,9,9,0,0,0,1),
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(TwoSumArgumentsProvider::class)
    fun testSolution(
        l1: SolutionAddTwoNumbers.ListNode,
        l2: SolutionAddTwoNumbers.ListNode,
        expected: List<Int>,
    ) {
        // given

        // when
        val result = sut.addTwoNumbers(l1, l2)

        // then
        var resultPointer = result
        expected.forEach {
            assertThat(resultPointer!!.`val`).isEqualTo(it)
            resultPointer = resultPointer!!.next
        }
        assertThat(resultPointer).isNull()
    }
}
