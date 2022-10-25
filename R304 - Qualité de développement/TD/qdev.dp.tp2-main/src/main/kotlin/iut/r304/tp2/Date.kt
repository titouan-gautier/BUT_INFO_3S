package iut.r304.tp2

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Classe très simple représentant une date
 *
 * @constructor Constructeur définissant une date
 * @property jour entier représentant le jour
 * @property mois entier représentant le mois
 * @property annee entier représentant l'annee
 */
class Date (j : Int, m : Int, a : Int) {
    var jour : Int
        private set
    var mois : Int
        private set
    var annee : Int
        private set

    init {
        jour = j
        mois = m
        annee = a
    }


    /**
     * donne une chaine de caractères correspondant à la date
     *
     * @return une chaine JJ-MM-AAAA
     */
    override fun toString(): String {
        return "$jour-$mois-$annee"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Date) return false

        if (jour != other.jour) return false
        if (mois != other.mois) return false
        if (annee != other.annee) return false

        return true
    }

    override fun hashCode(): Int {
        var result = jour
        result = 31 * result + mois
        result = 31 * result + annee
        return result
    }



    /**
     * methode qui permet de vérifier si une date est valide, cad si le jour,
     * mois et année sont cohérents : uniquement 28 jours en février, sauf les
     * années bissextiles, uniquement 30 jours en juin, etc.
     *
     * @return true si la date est valide
     */
    fun dateValide(): Boolean {
       if (isBisextile(annee)) {
           var table = mutableListOf(31,29,31,30,31,30,31,31,30,31,30,31)
           if (jour > 31) {return false}
           if (jour > 30 && table[mois - 1] == 30) {return false}
           if (jour > 29 && table[mois - 1] == 29) {return false}
           if (mois > 12) {return false}
       } else {
           var table = mutableListOf(31,28,31,30,31,30,31,31,30,31,30,31)
           if (jour > 31) {return false}
           if (jour > 30 && table[mois - 1] == 30) {return false}
           if (jour > 28 && table[mois - 1] == 28) {return false}
           if (mois > 12) {return false}
       }
        return true
    }

    fun isBisextile(annee : Int) : Boolean {
        if (annee%4 == 0 && annee%100 != 0) {
            return true
        } else if (annee%400 == 0) {
            return true
        }
        return false
    }

    companion object {

        /**
         * fabrique une date valide à partir de la chaine de caractère passé en
         * paramètre
         *
         * @param str chaine representant une date dans le format JJ-MM-AAAA
         * @return la date correspondant à la chaine de caractère
         * @throws DateException si la chaine est malformée
         */
        fun fabrique(str: String): Date {
            var d = str.split("-")
            var date = Date(d[0].toInt(),d[1].toInt(),d[2].toInt())

            if (!date.dateValide()) {
                throw DateException("error")
            }
            return date
        }
    }
}
