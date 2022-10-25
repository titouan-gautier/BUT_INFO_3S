package iut.but2.tp1

class FileChainee<E> : File<E> {

    private var debut : Cellule<E>? = null
    private var fin : Cellule<E>? = null

    override fun insererEnQueue(element: E) {
        var c = Cellule<E>(element)

        if (debut == null) {
            debut = c
        } else {
            fin?.modifieSuivant(c)
        }
        this.fin = c
    }

    override fun supprimerEnTete() {
        if (this.debut != null) {
            debut = debut?.suivant()
        } else {
            throw NoSuchElementException()
        }

    }

    override fun listerDepuisDebut() : MutableList<E>  {

        var list = mutableListOf<E>()

        var c = this.debut

        while (c != null) {
            list.add(c.valeur())
            c = c.suivant()
        }
        return list
    }

    override fun taille(): Int {
        var c = this.debut
        var count = 0

        while (c != null) {
            count += 1
            c = c.suivant()
        }
        return count
    }

    override fun consulter(position: Int): E {

        var list = listerDepuisDebut()

        if (position < 0 || position > list.size) {
            throw IndexOutOfBoundsException()
        }

        return list[position]
    }

    override fun listerDepuisFin() : MutableList<E> {
        if (debut == null)  {
            return mutableListOf()
        }

        var listOrdre = listerDepuisDebut()
        var listPasOrdre : MutableList<E> = listOrdre.reversed() as MutableList<E>

        return listPasOrdre
    }

}