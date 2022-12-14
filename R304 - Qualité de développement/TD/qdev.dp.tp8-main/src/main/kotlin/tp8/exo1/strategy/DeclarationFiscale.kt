package tp8.exo1.strategy

import tp8.exo1.Situation

fun declarationFiscale(
    revenuAnnuel: Double,
    loyerMensuel: Double,
    situation: Situation,
    nbEnfants: Int
): Triple<Double, Int, Int> {
    val foyer = Foyer(revenuAnnuel, loyerMensuel, situation, nbEnfants)

    lateinit var calcul: CalculImpot
    if (foyer.situation == Situation.Celibataire && foyer.nbEnfants <= 0) {
        calcul = CalculImpotCelibataire(foyer)
    } else if (foyer.situation == Situation.Couple && foyer.nbEnfants <= 0) {
        calcul = CalculImpotCouple(foyer)
    } else if (foyer.situation == Situation.Couple && foyer.nbEnfants > 0) {
        calcul = CalculImpotCoupleEnfant(foyer)
    } else if (foyer.situation == Situation.Celibataire && foyer.nbEnfants > 0) {
        calcul = CalculImpotCelibataireEnfant(foyer)
    }

    return Triple(
        calcul.revenusImposables(),
        calcul.impotsSurLeRevenu(),
        calcul.taxeHabitation())
}



