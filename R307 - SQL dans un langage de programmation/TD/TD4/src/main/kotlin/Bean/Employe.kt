package Bean

import java.sql.Statement

class Employe(nuempl: Int, nomempl: String, hebdo: Int, affect: Int, salaire : Int) {
    private var nuempl : Int
    private var nomempl : String
    private var hebdo: Int
    private var affect: Int
    private var salaire: Int

    init {
        this.nuempl = nuempl
        this.nomempl = nomempl
        this.hebdo = hebdo
        this.affect = affect
        this.salaire = salaire
    }

    fun getNuempl() : Int  {
        return this.nuempl
    }


    fun getNomempl() : String {
        return this.nomempl
    }

    fun getHebdo() : Int  {
        return this.hebdo
    }

    fun getAffect() : Int  {
        return this.nuempl
    }

    fun getSalaire() : Int {
        return this.salaire
    }

    fun setNomempl(nom : String) {
        this.nomempl = nom
    }

    fun setHebdo(h : Int) {
        this.hebdo = h
    }

    fun setAffect(a : Int) {
        this.hebdo = a
    }

    fun setSalaire(s : Int) {
        this.salaire = s
    }

    override fun toString() : String {
        return "$nuempl $nomempl $hebdo $affect"
    }

}