import java.util.*

fun main() {

}

fun DrapeauMonégasque(T : Array<String>) : Array<String> {

    val N : Int = T.size
    var i : Int = 0
    var k : Int = T.size

    assert

    while( i > k ) {
        if (T[i] == "B") {
            i += 1
        } else if (T[k] == "R") {
            k += 1
        } else {
            echanger(i,k)
            i += 1
            k += 1
        }

        T.slice(IntRange(0,i-1)).all { it == "B" }
        T.slice(IntRange(k+1,N)).all { it == "R" }

    }

    return T
}


fun echanger(T : Array<String>,i : Int,j : Int) {
    Collections.swap(T.asList(),i,j)
}
