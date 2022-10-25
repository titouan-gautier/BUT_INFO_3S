package DAO
import Bean.Employe
import database.SessionOracle
import java.sql.Connection
import java.sql.*

class DAOEmploye(val ss: SessionOracle) {
    var session: SessionOracle? = null
    init {
        this.session=ss
    }

    fun create(e : Employe) {
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete: String = "Insert into employe VALUES(${e.getNuempl()},'${e.getNomempl()}',${e.getHebdo()},${e.getAffect()},${e.getSalaire()})"

        try {
            val stmt: Statement = conn!!.createStatement()// Création d'une requete de type Statemen
            stmt.executeUpdate(requete)
        } catch (e: SQLException) {
            println(e.errorCode)//numéro d'erreur
            println(e.message)// message d'erreur qui provient d'oracle, trigger ou procédure
        }
        this.read()
    }

    fun update(e : Employe) {
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete : String = "UPDATE employe SET nomempl = '${e.getNomempl()}', hebdo = ${e.getHebdo()}, affect = ${e.getAffect()}, salaire = ${e.getSalaire()} where nuempl = ${e.getNuempl()} "

        try {
            val stmt: Statement = conn!!.createStatement()// Création d'une requete de type Statemen
            stmt.executeUpdate(requete)
        } catch (e: SQLException) {
            println(e.errorCode)//numéro d'erreur
            println(e.message)// message d'erreur qui provient d'oracle, trigger ou procédure
        }
        this.read()
    }

    fun delete(e: Employe) {
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete : String = "DELETE from employe where nuempl = ${e.getNuempl()}"

        try {
            val stmt: Statement = conn!!.createStatement()// Création d'une requete de type Statemen
            stmt.executeUpdate(requete)
        } catch (e: SQLException) {
            println(e.errorCode)//numéro d'erreur
            println(e.message)// message d'erreur qui provient d'oracle, trigger ou procédure
        }
        this.read()
    }


    fun read(){


        //var essai = SessionOracle();
        var conn: Connection? = null
        conn= session?.getConnectionOracle()
        val requete: String="SELECT * FROM employe"
        try {
            val stmt: Statement = conn!!.createStatement()// Création d'une requete de type Statemen
            val result: ResultSet= stmt.executeQuery(requete) //Le contenu du select est dans ResultSet

            /* Parcourir le résultat du select avec la fonction next();*/
            while (result!!.next()) {

                // getting the value of the id column
                val id = result.getInt("nuempl")
                val nom=result.getString("nomempl")
                val hebdo = result.getInt("hebdo")
                val affect = result.getInt("affect")
                val salaire = result.getInt("salaire")
                println("$id $nom $hebdo $affect $salaire")

            }
            result.close()
        }

        catch(e: SQLException){
            println(e.errorCode)//numéro d'erreur
            println(e.message)// message d'erreur qui provient d'oracle, trigger ou procédure
        }
    }


}