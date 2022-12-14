package tp8.exo1.templatemethod

import tp8.exo1.Situation

class CoupleEnfants(
    revenuAnnuel: Double,
    loyerMensuel: Double,
    situation: Situation,
    nbEnfants: Int = 0,
) : Foyer(revenuAnnuel,loyerMensuel, situation, nbEnfants) {

    override fun getBonusRevenuImposable() : Int {
        return 750*nbEnfants
    }

    override fun getTauxRevenuImposable() : Double {
        return 0.8
    }

    override fun getBonusRevenue() : Int {
        return 4+nbEnfants
    }

    override fun getTauxHab() : Double {
        return 1.5
    }

    override fun getBonusHab() : Int {
        return -50*nbEnfants
    }
}