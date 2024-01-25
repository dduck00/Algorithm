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

class Solution1143Test {
    private lateinit var sut: Solution1143

    @BeforeEach
    fun setup() {
        sut = Solution1143()
    }

    class Solution1143Provider : ArgumentsProvider {
        private fun argumentGenerator(
            text1: String,
            text2: String,
            expected: Int,
        ): Arguments {
            return Arguments.of(text1, text2, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    text1 = "abcde",
                    text2 = "ace",
                    expected = 3
                ),
                argumentGenerator(
                    text1 = "abc",
                    text2 = "abc",
                    expected = 3
                ),
                argumentGenerator(
                    text1 = "abc",
                    text2 = "def",
                    expected = 0
                ),
                argumentGenerator(
                    text1 = "bcdec",
                    text2 = "abce",
                    expected = 3
                ),
                argumentGenerator(
                    text1 = "bsbininm",
                    text2 = "jmjkbkjkv",
                    expected = 1
                ),
                argumentGenerator(
                    text1 = "ezupkr",
                    text2 = "ubmrapg",
                    expected = 2
                ),
                argumentGenerator(
                    text1 = "abcba",
                    text2 = "abcbcba",
                    expected = 5
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution1143Provider::class)
    fun testSolution(
        text1: String,
        text2: String,
        expected: Int,
    ) {
        // given

        // when
        val result = sut.longestCommonSubsequence(text1, text2)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
