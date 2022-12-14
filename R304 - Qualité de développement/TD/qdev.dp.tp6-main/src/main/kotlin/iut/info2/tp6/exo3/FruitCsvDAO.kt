package iut.info2.tp6.exo3

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File

class FruitCsvDAO(nomFichier : String) : FruitDAO {

    var file = nomFichier

    override fun donneLesFruits(): List<Fruit> {

        var fruits = mutableListOf<Fruit>()

        csvReader().open(file) {
            readAllAsSequence().forEach { row ->
                var fruit : Fruit = Fruit(row[0],row[2].toDouble(),row[1].toInt())
                fruits.add(fruit)
            }
        }
        return fruits
    }

    override fun donneLesFruitsCoutantMoinsQue(prix: Double): List<Fruit> {
        var fruits = donneLesFruits()

        var fruitsPeuCher = mutableListOf<Fruit>()

        fruits.forEach {
            if (it.prix < prix) {
                fruitsPeuCher.add(it)
            }
        }
        return fruitsPeuCher.sortedBy { it.prix}
    }

    override fun donneLeFruit(nom: String): Fruit? {
        var fruits = donneLesFruits()

        fruits.forEach {
            if (it.nom == nom) {
                return it
            }
        }
        return null
    }

    override fun enregistreLesFruits(fruits: List<Fruit>) {
        csvWriter().open(file) {
            fruits.forEach {
                writeRow(it.nom,it.quantite,it.prix)
            }
        }
    }

    override fun ajouteUnFruit(fruit: Fruit) {
        var fruits = donneLesFruits()

        if (fruits.contains(fruit)) {
            throw FruitDejaPresentException()
        }

        var list = listOf(listOf<String>(fruit.nom,fruit.quantite.toString(),fruit.prix.toString()))

        csvWriter().writeAll(list,file,append = true)
    }



}