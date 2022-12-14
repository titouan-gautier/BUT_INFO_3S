package iut.info2.tp6.exo1

/**
 * Classe englobant des Personnes ou des Entreprises
 *
 * @property nom le nom de la personne ou de l'entreprise
 */
open class PersonneA
protected constructor(protected open val nom: String) {

    companion object {

        /**
         * Méthode permettant de retourner une Personne ou une Entreprise à partir
         * de l'analyse d'une seule chaine de caractères qui doit respecter une
         * format précis
         *
         * @param texteSaisi le texte a analyser
         * @return une Personne ou une Entreprise
         * @throws PersonneException si le chaine [texteSaisi] le respecte pas l'un
         *     des formats attendus et donc, ne permet pas de créer une Personne ou
         *     une Entreprise
         */
        fun donnePersonneSaisie(texteSaisi: String): PersonneA {
            
            var texte = texteSaisi.split(" ")

            println(texte[0])
            println(texte[1])
            println()

            if (texte[0].isFullUpperCase() && texte[1].isFullUpperCase()) {
                var cat : CategorieEntreprise
                try {
                    cat = CategorieEntreprise.valueOf(texte[0])
                } catch (e: Exception) {
                    var name = texte[0]
                    var firstName = texte[1]
                    return Personne(name,firstName)
                }
                var name = texte[1]
                return Entreprise(name,cat)
            } else if (texte[0].isFullUpperCase() && texte[1].hasAnUppercaseLetterFirst()) {
                var name = texte[0]
                var firstName = texte[1]
                return Personne(name,firstName)
            } else if (texte[0].hasAnUppercaseLetterFirst() && texte[1].isFullUpperCase()) {
                var name = texte[1]
                var firstName = texte[0]
                return Personne(name,firstName)
            } else {
                throw PersonneException("Mauvais format")
            }
        }
    }
}