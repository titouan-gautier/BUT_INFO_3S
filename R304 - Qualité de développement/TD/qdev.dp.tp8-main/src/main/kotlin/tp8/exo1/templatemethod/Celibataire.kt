package tp8.exo1.templatemethod

import tp8.exo1.Situation

class Celibataire(
    revenuAnnuel: Double,
    loyerMensuel: Double,
    situation: Situation,
    nbEnfants: Int = 0,
) : Foyer(revenuAnnuel,loyerMensuel, situation, nbEnfants) {

    override fun getBonusRevenuImposable() : Int {
        return 0
    }

    override fun getTauxRevenuImposable() : Double {
        return 0.9
    }

    override fun getBonusRevenue() : Int {
        return 3
    }

    override fun getTauxHab() : Double {
        return 2.0
    }

    override fun getBonusHab() : Int {
        return 1000
    }
}