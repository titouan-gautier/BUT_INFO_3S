package tp8.exo1.templatemethod

import tp8.exo1.Situation
import tp8.exo1.strategy.CalculImpotCelibataire
import tp8.exo1.strategy.CalculImpotCelibataireEnfant
import tp8.exo1.strategy.CalculImpotCouple
import tp8.exo1.strategy.CalculImpotCoupleEnfant

fun declarationFiscale(
    revenuAnnuel: Double,
    loyerMensuel: Double,
    situation: Situation,
    nbEnfants: Int
): Triple<Double, Int, Int> {

    lateinit var foyer : Foyer
    if (situation == Situation.Celibataire && nbEnfants <= 0) {
        foyer = Celibataire(revenuAnnuel, loyerMensuel, situation, nbEnfants)
    } else if (situation == Situation.Couple && nbEnfants <= 0) {
        foyer = Couple(revenuAnnuel, loyerMensuel, situation, nbEnfants)
    } else if (situation == Situation.Couple && nbEnfants > 0) {
        foyer = CoupleEnfants(revenuAnnuel, loyerMensuel, situation, nbEnfants)
    } else if (situation == Situation.Celibataire && nbEnfants > 0) {
        foyer = CelibataireEnfant(revenuAnnuel, loyerMensuel, situation, nbEnfants)
    }

    val calcul = CalculImpot(foyer)
    return Triple(
        calcul.revenusImposables(),
        calcul.impotsSurLeRevenu(),
        calcul.taxeHabitation())
}

