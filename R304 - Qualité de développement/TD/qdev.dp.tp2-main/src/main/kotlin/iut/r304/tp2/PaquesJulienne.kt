package iut.r304.tp2

import iut.r304.tp2.Paques.Companion.listDate

class PaquesJulienne : Paques {

    init {
        listDate = mutableListOf()
    }

    override fun calculeDatePaques(annee: Int): Date {
        /*
* voir : https://fr.wikipedia.org/wiki/Calcul_de_la_date_de_P%C3%A2ques_selon_la_m%C3%A9thode_de_Meeus#Calcul_de_la_date_de_P%C3%A2ques_julienne
*/
        if (annee >= 326) {
            val divA : Int = 19
            val divB : Int = 7
            val divC : Int = 4
            val divD : Int = 30
            val divE : Int = 7
            val divG : Int = 31

            var A = annee%divA
            var B = annee%divB
            var C = annee%divC

            var D = (19*A+15)%divD
            var E = (2*C + 4*B - D + 34)%divE
            var G = (D + E + 114)%divG

            var F = (D + E + 114)/divG

            var d : Date = Date(G+1,F,annee)
            listDate.add(d)
            return d
        }
        throw PaquesException("error")
    }

    override fun historiqueResultats(): List<Date> {
        return listDate
    }

    override fun historiqueResultatsTries(): List<Date> {
        return listDate.sortedWith(compareBy({it.mois},{it.jour},{it.annee}))
    }

}