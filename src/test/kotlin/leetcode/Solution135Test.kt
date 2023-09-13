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

class Solution135Test {
    private lateinit var sut: Solution135

    @BeforeEach
    fun setup() {
        sut = Solution135()
    }

    class Solution135Provider : ArgumentsProvider {
        private fun argumentGenerator(
            rating: IntArray,
            expected: Int,
        ): Arguments {
            return Arguments.of(rating, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    rating = intArrayOf(1, 0, 2),
                    expected = 5
                ),
                argumentGenerator(
                    rating = intArrayOf(1, 2, 2),
                    expected = 4
                ),
                argumentGenerator(
                    rating = intArrayOf(1, 3, 4, 5, 2),
                    expected = 11
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution135Provider::class)
    fun testSolution(
        rating: IntArray,
        expected: Int,
    ) {
        // given

        // when
        val result = sut.candy(rating)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
