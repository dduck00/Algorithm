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

class Solution1359Test {
    private lateinit var sut:Solution1359

    @BeforeEach
    fun setup() {
        sut = Solution1359()
    }

    class Solution1359Provider : ArgumentsProvider {
        private fun argumentGenerator(
            n:Int,
            expected: Int,
        ): Arguments {
            return Arguments.of(n, expected)
        }

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
//                argumentGenerator(
//                    n = 1,
//                    expected = 1
//                ),
//                argumentGenerator(
//                    n = 2,
//                    expected = 6
//                ),
//                argumentGenerator(
//                    n = 3,
//                    expected = 90
//                ),
                argumentGenerator(
                    n = 8,
                    expected = 729647433
                ),
            )
        }

    }

    @ParameterizedTest
    @ArgumentsSource(Solution1359Provider::class)
    fun testSolution(
        n:Int,
        expected: Int,
    ) {
        // given

        // when
        val result = sut.countOrders(n)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
