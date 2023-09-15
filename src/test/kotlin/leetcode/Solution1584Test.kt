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

class Solution1584Test {
    private lateinit var sut: Solution1584

    @BeforeEach
    fun setup() {
        sut = Solution1584()
    }

    class Solution1584Provider : ArgumentsProvider {
        private fun argumentGenerator(
            points: Array<IntArray>,
            expected: Int,
        ): Arguments {
            return Arguments.of(points, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    points = arrayOf(intArrayOf(3, 12), intArrayOf(-2, 5), intArrayOf(-4, 1)),
                    expected = 18
                ),
                argumentGenerator(
                    points = arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(2, 2),
                        intArrayOf(3, 10),
                        intArrayOf(5, 2),
                        intArrayOf(7, 0),
                    ),
                    expected = 20
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution1584Provider::class)
    fun testSolution(
        points: Array<IntArray>,
        expected: Int,
    ) {
        // given

        // when
        val result = sut.minCostConnectPoints(points)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
