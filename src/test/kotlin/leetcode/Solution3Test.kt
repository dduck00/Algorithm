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

class Solution3Test {
    private lateinit var sut: Solution3

    @BeforeEach
    fun setup() {
        sut = Solution3()
    }

    class Solution3Provider : ArgumentsProvider {
        private fun argumentGenerator(
            s: String,
            expected: Int,
        ): Arguments {
            return Arguments.of(s, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                argumentGenerator(
                    s = "abcabcbb",
                    expected = 3
                ),
                argumentGenerator(
                    s = "bbbbb",
                    expected = 1
                ),
                argumentGenerator(
                    s = "pwwkew",
                    expected = 3
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution3Provider::class)
    fun testSolution(
        s: String,
        expected: Int,
    ) {
        // given

        // when
        val result = sut.lengthOfLongestSubstring(s)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
