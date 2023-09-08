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

class Solution118Test {
    private lateinit var sut: Solution118

    @BeforeEach
    fun setup() {
        sut = Solution118()
    }

    class Solution118Provider : ArgumentsProvider {
        private fun argumentGenerator(
            numRows:Int,
            expected: List<List<Int>>,
        ): Arguments {
            return Arguments.of(numRows, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    numRows = 5,
                    expected = listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1)),
                ),
                argumentGenerator(
                    numRows = 1,
                    expected = listOf(listOf(1)),
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution118Provider::class)
    fun testSolution(
        numRows:Int,
        expected: List<List<Int>>,
    ) {
        // given

        // when
        val result = sut.generate(numRows)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
