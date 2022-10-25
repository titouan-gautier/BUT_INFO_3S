package iut.r304.tp2

import iut.r304.tp2.Paques.Companion.listDate

class PaquesGregorienne : Paques {

    init {
        listDate = mutableListOf()
    }

    override fun calculeDatePaques(annee: Int): Date {

        if (annee >= 1583) {
            val divN = annee%19
            val divU = annee%100

            val quotientC : Int = annee/100

            val divt : Int = quotientC%4

            val quotientS : Int = quotientC/4
            val quotientP : Int = (quotientC + 8)/25
            val quotientQ : Int = (quotientC-quotientP+1)/3

            val divE = (19*divN + quotientC - quotientS - quotientQ + 15)%30
            val divD = divU%4

            val quotientB : Int = divU/4

            val divL = (2*divt + 2*quotientB - divE - divD + 32)%7

            val quotientH : Int = (divN + 11*divE + 22*divL) / 451

            val divJ = (divE + divL - 7*quotientH + 114) % 31
            val quotientM = (divE + divL - 7*quotientH + 114) / 31

            listDate.add(Date(divJ + 1, quotientM,annee))
            return Date(divJ + 1, quotientM,annee)
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