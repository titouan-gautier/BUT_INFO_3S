package tp8.exo1.strategy

import tp8.exo1.ImpotSurLeRevenu
import tp8.exo1.TaxeHabitation

 class CalculImpotCelibataireEnfant(foyer : Foyer) : CalculImpot(foyer) {

    override fun revenusImposables(): Double {
        return foyer.revenuAnnuel * 0.88 - (1000 * foyer.nbEnfants)
    }

    override fun impotsSurLeRevenu(): Int {
        return (this.revenusImposables()*1/(3 + foyer.nbEnfants)).toInt()
    }

    override fun taxeHabitation(): Int {
        return (foyer.loyerMensuel - (75 * foyer.nbEnfants)).toInt()
    }


}

