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

class Solution1647Test {
    private lateinit var sut: Solution1647

    @BeforeEach
    fun setup() {
        sut = Solution1647()
    }

    class Solution1647Provider : ArgumentsProvider {
        private fun argumentGenerator(
            s: String,
            expected: Int,
        ): Arguments {
            return Arguments.of(s, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
//                argumentGenerator(
//                    s = "aab",
//                    expected = 0
//                ),
//                argumentGenerator(
//                    s = "aaabbbcc",
//                    expected = 2
//                ),
//                argumentGenerator(
//                    s = "ceabaacb",
//                    expected = 2
//                ),
                argumentGenerator(
                    s = "abcabc",
                    expected = 3
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution1647Provider::class)
    fun testSolution(
        s: String,
        expected: Int,
    ) {
        // given

        // when
        val result = sut.minDeletions(s)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
