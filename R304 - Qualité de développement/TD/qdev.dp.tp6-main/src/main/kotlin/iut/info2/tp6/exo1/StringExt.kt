package iut.info2.tp6.exo1

/**
 * méthode indiquant si la chaine de caractère est uniquement composée de
 * lettres en majuscules
 *
 * @return [true] si la chaine est en majuscule
 */
fun String.isFullUpperCase(): Boolean {
    if ( this == this.uppercase()) {
        return true
    }
    return false
}

/**
 * Méthode indiquant si la chaine de caractères est composée d'un premier
 * caractère en majuscule, suivi des autres caractères en minuscules
 *
 * @return [true] si la chaine respecte le format
 */
fun String.hasAnUppercaseLetterFirst(): Boolean {
    var firstLetter : Char = this[0]

    if (firstLetter.isUpperCase()) {
        if (this.length == 1) {
            return true
        }
        for (i in 1..this.length-1) {
            if (this[i].isUpperCase()) {
                return false
            }
        }
        return true
    }

    return false
}

