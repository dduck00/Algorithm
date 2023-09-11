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
import kotlin.math.exp

class Solution1282Test {
    private lateinit var sut: Solution1282

    @BeforeEach
    fun setup() {
        sut = Solution1282()
    }

    class Solution1282Provider : ArgumentsProvider {
        private fun argumentGenerator(
            groupSizes: IntArray,
            expected: List<List<Int>>,
        ): Arguments {
            return Arguments.of(groupSizes, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    groupSizes = intArrayOf(3, 3, 3, 3, 3, 1, 3),
                    expected = listOf(listOf(5), listOf(0, 1, 2), listOf(3, 4, 6))
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution1282Provider::class)
    fun testSolution(
        groupSizes: IntArray,
        expected: List<List<Int>>,
    ) {
        // given

        // when
        val result = sut.groupThePeople(groupSizes)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
