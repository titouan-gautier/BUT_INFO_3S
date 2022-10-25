package iut.but2.tp1

class FileArrayList<E> : File<E> {

    var list = ArrayList<E>()

    init {

    }

    override fun insererEnQueue(element: E) {
        list.add(element)
    }

    override fun supprimerEnTete() {
        if (list.size == 0 || list == null) {
            throw NoSuchElementException()
        }

        var newlist = ArrayList<E>()

        for (i in 1 until list.size) {
                newlist.add(list[i])
            }

        list = newlist

    }

    override fun listerDepuisDebut(): MutableList<E> {
        var m = mutableListOf<E>()
        for (i in list) {
            m.add(i)
        }
        return m
    }

    override fun taille(): Int {
        return list.size
    }

    override fun consulter(position: Int): E {
        if (position < 0 || position > list.size) {
            throw IndexOutOfBoundsException()
        }
        return list[position]
    }

    override fun listerDepuisFin(): MutableList<E> {
        var m = listerDepuisDebut()

        return m.asReversed()
    }


}