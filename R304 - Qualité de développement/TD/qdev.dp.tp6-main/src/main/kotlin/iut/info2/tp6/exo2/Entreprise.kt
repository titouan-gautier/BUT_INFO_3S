package iut.info2.tp6.exo2

class Entreprise( private val principal: Departement = Departement() ) : Salariable,Ajoutable by principal {

    override fun ajouter(entite: Entite) {
        principal.ajouter(entite)
    }

    override fun supprimer(entite : Entite) {
        principal.supprimer(entite)
    }

    override fun salaire() : Double {
        return principal.salaire()
    }

}


