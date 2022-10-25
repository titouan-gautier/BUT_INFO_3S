package DAObis

import Bean.Employe
import database.SessionOracle
import oracle.jdbc.OracleTypes
import java.sql.*

class DAOEmployeter(val ss: SessionOracle) {
    var session: SessionOracle? = null
    init {
        this.session=ss
    }

    fun create(e : Employe) {
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete: String = "call MAJ.CREER_EMPLOYE(?,?,?,?,?)"
        try {
            val stmt: CallableStatement = conn!!.prepareCall(requete)// Création d'une requete de type Statemen
            stmt.setInt(1,e.getNuempl());
            stmt.setString(2,e.getNomempl());
            stmt.setInt(3,e.getHebdo());
            stmt.setInt(4,e.getAffect());
            stmt.setInt(5,e.getSalaire());
            stmt.execute()
        } catch (e: SQLException) {
            println(e.errorCode)//numéro d'erreur
            println(e.message)// message d'erreur qui provient d'oracle, trigger ou procédure
        }
        this.read()
    }

    fun update(e : Employe) {
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete : String = "UPDATE employe SET nomempl = ?, hebdo = ?, affect = ?, salaire = ? where nuempl = ? "

        try {
            val stmt: PreparedStatement = conn!!.prepareStatement(requete)// Création d'une requete de type Statemen
            stmt.setString(1,e.getNomempl())
            stmt.setInt(2,e.getHebdo())
            stmt.setInt(3,e.getAffect())
            stmt.setInt(4,e.getSalaire())
            stmt.setInt(5,e.getNuempl())
            stmt.executeUpdate()
        } catch (e: SQLException) {
            println(e.errorCode)//numéro d'erreur
            println(e.message)// message d'erreur qui provient d'oracle, trigger ou procédure
        }
        this.read()
    }

    fun delete(e: Employe) {
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete : String = "DELETE from employe where nuempl=?"

        try {
            val stmt: PreparedStatement = conn!!.prepareStatement(requete)// Création d'une requete de type Statemen
            stmt.setInt(1,e.getNuempl())
            stmt.executeUpdate()
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
        val requete: String="call LECTURE.liste_employes(?)"
        try {
            val stmt: CallableStatement = conn!!.prepareCall(requete)// Création d'une requete de type Stateme
            stmt.registerOutParameter(1,OracleTypes.CURSOR)
            stmt.execute()
            var result = stmt.getObject(1) as ResultSet

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