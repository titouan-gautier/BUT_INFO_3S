package tp8.exo1.strategy

import tp8.exo1.ImpotSurLeRevenu
import tp8.exo1.TaxeHabitation

 class CalculImpotCelibataire(foyer: Foyer) : CalculImpot(foyer) {

    override fun revenusImposables(): Double {
        return foyer.revenuAnnuel*0.9
    }

    override fun impotsSurLeRevenu(): Int {
        return (this.revenusImposables()*1/3).toInt()
    }

    override fun taxeHabitation(): Int {
        return (foyer.loyerMensuel*2 + 1000).toInt()
    }


}

