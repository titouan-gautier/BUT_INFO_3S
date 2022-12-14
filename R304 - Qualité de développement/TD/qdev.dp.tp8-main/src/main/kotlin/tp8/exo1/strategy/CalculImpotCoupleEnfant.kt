package tp8.exo1.strategy

import tp8.exo1.ImpotSurLeRevenu
import tp8.exo1.TaxeHabitation

 class CalculImpotCoupleEnfant(foyer: Foyer) : CalculImpot(foyer) {

    override fun revenusImposables(): Double {
        return foyer.revenuAnnuel*0.8 - (750*foyer.nbEnfants)
    }

    override fun impotsSurLeRevenu(): Int {
        return (this.revenusImposables()*1/(4+foyer.nbEnfants)).toInt()
    }

    override fun taxeHabitation(): Int {
        return (1.5*foyer.loyerMensuel - (50*foyer.nbEnfants)).toInt()
    }


}

