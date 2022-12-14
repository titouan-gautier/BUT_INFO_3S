package tp8.exo1.strategy

import tp8.exo1.ImpotSurLeRevenu
import tp8.exo1.TaxeHabitation

 class CalculImpotCouple(foyer : Foyer) : CalculImpot(foyer) {

    override fun revenusImposables(): Double {
        return foyer.revenuAnnuel * 0.8
    }

    override fun impotsSurLeRevenu(): Int {
        return (revenusImposables() * 1/4).toInt()
    }

    override fun taxeHabitation(): Int {
        return (foyer.loyerMensuel*2).toInt()
    }


}

