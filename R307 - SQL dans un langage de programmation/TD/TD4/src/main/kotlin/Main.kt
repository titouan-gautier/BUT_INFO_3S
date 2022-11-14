import Bean.Employe
import DAO.DAOEmploye
import DAO.DAOEmployebis
import DAObis.DAOEmployeter
import database.SessionOracle

/**
 * Program to list databases in MySQL using Kotlin
 */


fun main(args: Array<String>) {
    var essai= SessionOracle();

    essai.getConnectionOracle()

    var titouan = Employe(1,"titouan",25,2, 2000)
    var titouanv2 = Employe(2,"titouanv2",25,2, 2000)
    /*
    var titouanv2 = Employe(1,"titouanv2",25,2, 2000)
    var maxime = Employe(2,"maxime",25,1,5000)



     */

    var dd= DAOEmployeter(essai)

    dd.create(titouanv2)

    /*

    dd.read()

     */

}