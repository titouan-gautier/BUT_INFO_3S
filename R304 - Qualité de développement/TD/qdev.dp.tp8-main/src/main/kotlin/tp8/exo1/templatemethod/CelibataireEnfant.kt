package tp8.exo1.templatemethod

import tp8.exo1.Situation

class CelibataireEnfant(
    revenuAnnuel: Double,
    loyerMensuel: Double,
    situation: Situation,
    nbEnfants: Int = 0,
) : Foyer(revenuAnnuel,loyerMensuel, situation, nbEnfants) {

    override fun getBonusRevenuImposable() : Int {
        return 1000*nbEnfants
    }

    override fun getTauxRevenuImposable() : Double {
        return 0.88
    }

    override fun getBonusRevenue() : Int {
        return 3+nbEnfants
    }

    override fun getTauxHab() : Double {
        return 1.0
    }

    override fun getBonusHab() : Int {
        return -75*nbEnfants
    }
}