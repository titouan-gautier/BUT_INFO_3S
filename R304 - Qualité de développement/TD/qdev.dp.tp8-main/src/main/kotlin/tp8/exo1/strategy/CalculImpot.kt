package tp8.exo1.strategy

import tp8.exo1.ImpotSurLeRevenu
import tp8.exo1.TaxeHabitation

 abstract class CalculImpot(var foyer : Foyer) : ImpotSurLeRevenu, TaxeHabitation {

     abstract override fun revenusImposables(): Double

    abstract override fun impotsSurLeRevenu(): Int

    abstract override fun taxeHabitation(): Int

}

