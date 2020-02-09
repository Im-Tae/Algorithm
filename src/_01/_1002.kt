package _01

import java.util.*
import kotlin.math.sqrt

// i = √{ (x1 - x2)^2 + (y1 - y2)^2 }

// (x1, y1), (x2, y2) 같을때,
// r1, r2가 같으면 -1
// r1, r2가 다르면 0

// (x1, y1), (x2, y2) 다를때,
// (r1 + r2) > i > |(r1 - r2)| 이면 교차점이 2개
// (r1 + r2) == i 이면 교차점이 1개
// (r1 + r2) < i 이면 교차점이 0개

val scanner = Scanner(System.`in`)
val count = getNum()

var result = arrayListOf(count)

fun main() {

    for (i in 0 until count) result.add(calculate(getNum(), getNum(), getNum(), getNum(), getNum(), getNum()))

    for (element in result) println(element)
}

fun getNum(): Int = scanner.nextInt()

fun calculate(x1: Int, y1: Int, r1: Int, x2: Int, y2: Int, r2: Int): Int {
    val i = getI(x1, y1, x2, y2)

    return if (x1 == x2 && y1 == y2)
        if (r1 == r2) -1
        else 0
    else if ((r1 + r2) > i && Math.abs(r1 - r2) < i) 2
    else if ((r1 + r2).toDouble() == i) 1
    else 0
}

fun getI(x1: Int, y1: Int, x2: Int, y2: Int): Double = Math.sqrt(Math.pow((x2 - x1).toDouble(), 2.0) + Math.pow((y2 - y1).toDouble(), 2.0))