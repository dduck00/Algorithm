package leetcode

import kotlin.math.absoluteValue

class Solution1584 {
    fun calcManhattanDistance(point1: IntArray, point2: IntArray): Int {
        val x = (point1[0] - point2[0]).absoluteValue
        val y = (point1[1] - point2[1]).absoluteValue
        return x + y
    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val pointSize = points.size
        val routes = mutableListOf<Mst>()

        for (i in 0 until pointSize) {
            for (j in i + 1 until pointSize) {
                val distance = calcManhattanDistance(points[i], points[j])
                routes.add(Mst(distance, i, j))
            }
        }

        routes.sortBy { it.distance }

        val uf = UF(pointSize)
        var result = 0
        var usedCount = 0
        for (route in routes) {
            if (uf.merge(route.i, route.j)) {
                result += route.distance
                usedCount++

                if (usedCount == pointSize - 1) break
            }
        }
        return result
    }

    class Mst(
        val distance: Int,
        val i: Int,
        val j: Int,
    )


    class UF(n: Int) {
        private val parent: IntArray = IntArray(n + 1) { idx -> idx }
        private val rank: IntArray = IntArray(n + 1) { 1 }

        fun find(a: Int): Int {
            if (a == parent[a])
                return a

            parent[a] = find(parent[a])

            return parent[a]
        }

        fun merge(a: Int, b: Int): Boolean {
            val A = find(a)
            val B = find(b)

            if (A == B) return false

            when {
                rank[A] < rank[B] -> {
                    parent[A] = B
                }

                rank[A] > rank[B] -> {
                    parent[B] = A
                }

                else -> {
                    parent[A] = B
                    rank[B]++
                }
            }

            return true
        }

    }
}
