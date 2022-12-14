package iut.info2.tp6.exo2

class Departement : Entite(), Ajoutable {

    var element : MutableList<Entite> = mutableListOf()

    override fun salaire() : Double {
        var salaire : Double = 0.0
        for (i in element) {
            salaire += i.salaire()
        }
        return salaire
    }

    override fun ajouter(entite : Entite) {
        element.add(entite)
    }

    override fun supprimer(entite : Entite) {
        element.remove(entite)
    }
}