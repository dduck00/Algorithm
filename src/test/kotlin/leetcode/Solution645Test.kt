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

class Solution645Test {
    private lateinit var sut: Solution645

    @BeforeEach
    fun setup() {
        sut = Solution645()
    }

    class Solution645Provider : ArgumentsProvider {
        private fun argumentGenerator(
            nums: IntArray,
            expected: IntArray,
        ): Arguments {
            return Arguments.of(nums, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    nums = intArrayOf(1, 2, 2, 4),
                    expected = intArrayOf(2, 3)
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution645Provider::class)
    fun testSolution(
        nums: IntArray,
        expected: IntArray,
    ) {
        // given

        // when
        val result = sut.findErrorNums(nums)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
