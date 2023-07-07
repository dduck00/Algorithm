package leetcode

import assertk.assertThat
import assertk.assertions.isEqualTo
import java.util.stream.Stream
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

class SolutionTwoSumTest {
    private lateinit var sut: SolutionTwoSum

    @BeforeEach
    fun setup() {
        sut = SolutionTwoSum()
    }

    class TwoSumArgumentsProvider : ArgumentsProvider {
        private fun argumentGenerator(
            nums: IntArray,
            target: Int,
            expected: IntArray,
        ): Arguments {
            return Arguments.of(nums, target, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    nums = intArrayOf(2, 7, 11, 15),
                    target = 9,
                    expected = intArrayOf(0, 1)
                ),
                argumentGenerator(
                    nums = intArrayOf(3, 2, 4),
                    target = 6,
                    expected = intArrayOf(1, 2)
                ),
                argumentGenerator(
                    nums = intArrayOf(3, 3),
                    target = 6,
                    expected = intArrayOf(0, 1)
                )
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(TwoSumArgumentsProvider::class)
    fun testSolution(
        nums: IntArray,
        target: Int,
        expected: IntArray,
    ) {
        // given

        // when
        val result = sut.twoSum(nums, target)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
