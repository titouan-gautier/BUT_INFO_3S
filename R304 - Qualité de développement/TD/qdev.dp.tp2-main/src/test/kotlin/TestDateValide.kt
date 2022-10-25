import iut.r304.tp2.Date
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse


class TestDateValide {

    @Test
    fun test() {
        val d1 = Date(29,2,2023)
        val d2 = Date(29,2,2024)
        assertFalse(d1.dateValide());
        assertTrue(d2.dateValide());
    }

    @Test
    fun test2() {
        val d1 = Date(40,1,2000)
        val d3 = Date(31,4,2000)
        val d4 = Date(29,2,2023)
        val d5 = Date(30,2,2024)

        val d2 = Date(1,13,2000)

        assertFalse(d1.dateValide(),"jour plus grand que 31")
        assertFalse(d3.dateValide(),"jour plus grand que 30 pour mois à 30")
        assertFalse(d4.dateValide(),"jour trop grand pour février non bisextile")
        assertFalse(d5.dateValide(),"jour trop grand pour février bisextile")

        assertFalse(d2.dateValide(),"mois plus grand que 12")
    }

}