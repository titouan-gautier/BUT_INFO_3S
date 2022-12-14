package tp8.exo1.templatemethod

import tp8.exo1.ImpotSurLeRevenu
import tp8.exo1.TaxeHabitation

class CalculImpot(var foyer: Foyer) : ImpotSurLeRevenu, TaxeHabitation {

    override fun revenusImposables(): Double {
        return foyer.revenuAnnuel*foyer.getTauxRevenuImposable() - foyer.getBonusRevenuImposable()
    }

    override fun impotsSurLeRevenu(): Int {
        return (revenusImposables()* 1/foyer.getBonusRevenue()).toInt()
    }

    override fun taxeHabitation(): Int {
        return (foyer.getTauxHab() * foyer.loyerMensuel + foyer.getBonusHab()).toInt()
    }

}

