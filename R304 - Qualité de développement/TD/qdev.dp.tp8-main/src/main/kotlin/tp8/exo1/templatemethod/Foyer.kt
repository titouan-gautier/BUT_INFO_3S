package tp8.exo1.templatemethod

import tp8.exo1.Situation

abstract class Foyer(var revenuAnnuel: Double, var loyerMensuel: Double, var situation: Situation = Situation.Celibataire, var nbEnfants: Int = 0) {

    abstract fun getBonusRevenuImposable() : Int

    abstract fun getTauxRevenuImposable() : Double

    abstract fun getBonusRevenue() : Int

    abstract fun getBonusHab() : Int

    abstract fun getTauxHab() : Double

}