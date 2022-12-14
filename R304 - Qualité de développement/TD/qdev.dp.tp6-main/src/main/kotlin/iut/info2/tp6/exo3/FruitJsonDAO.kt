package iut.info2.tp6.exo3

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.internal.writeJson
import java.io.File

class FruitJsonDAO(nomFichier : String) : FruitDAO {

    var file = nomFichier

    override fun donneLesFruits(): List<Fruit> {
        var json = File(file).readText()
        val data = Json.decodeFromString<List<Fruit>>(json).sortedBy{ it.nom }
        return data
    }

    override fun donneLesFruitsCoutantMoinsQue(prix: Double): List<Fruit> {
        val data = donneLesFruits()
        var list : MutableList<Fruit> = mutableListOf()
        for (i in data) {
            if (i.prix <= prix) {
                list.add(i)
            }
        }
        return list.sortedBy { it.prix }
    }

    override fun donneLeFruit(nom: String): Fruit? {
        var data = donneLesFruits()
        for (i in data) {
           if (i.nom == nom) {
               return i
           }
        }
        return null
    }

    override fun enregistreLesFruits(fruits: List<Fruit>) {
        var data = Json.encodeToJsonElement(fruits).toString()
        File(file).writeText(data)
    }

    override fun ajouteUnFruit(fruit: Fruit) {
        var data = donneLesFruits()

        if (data.contains(fruit)) {
            throw FruitDejaPresentException()
        }
        enregistreLesFruits(donneLesFruits()+fruit)
    }

}