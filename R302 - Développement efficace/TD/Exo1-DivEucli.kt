fun main() {
    print(divEucli(10032,554))
}

fun divEucli(A : Int,B : Int) : Pair<Int,Int> {

    var q : Int
    var r : Int
    var r_before : Int

    require(B != 0)

    r = A
    q = 0
    r_before = r

    while (r >= B) {
        r_before = r
        r -= B
        q += 1

        assert(r >= B)
        assert(q*B+r == A)
        assert(r < r_before)
    }

    assert(q*B+r == A)

    return Pair(q,r)
}

