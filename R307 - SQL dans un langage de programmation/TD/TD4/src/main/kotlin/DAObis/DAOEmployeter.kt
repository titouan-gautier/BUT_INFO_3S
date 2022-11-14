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
        var conn : Connection?
        conn = session!!.getConnectionOracle()
        var requete = "call MAJ.CREER_EMPLOYE(?,?,?,?,?)"

        try {
            var stmt : CallableStatement = conn!!.prepareCall(requete)
            stmt.setInt(1,e.getNuempl())
            stmt.setString(2,e.getNomempl())
            stmt.setInt(3,e.getHebdo())
            stmt.setInt(4,e.getAffect())
            stmt.setInt(5,e.getSalaire())
            stmt.executeUpdate()
        } catch (e : SQLException) {
            println(e.errorCode)
            println(e.message)
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
        var conn: Connection? = null
        conn = session?.getConnectionOracle()
        val requete : String = "call lecture.liste_employes(?)"

        try {
            var stmt : CallableStatement = conn!!.prepareCall(requete)
            stmt.registerOutParameter(1,OracleTypes.CURSOR)
            stmt.executeUpdate()
            var result : ResultSet = stmt.getObject(1) as ResultSet

            while (result!!.next()) {
                var id = result.getInt("nuempl")
                var name = result.getString("nomempl")
                var hebdo = result.getInt("hebdo")
                var affect = result.getInt("affect")
                var salaire = result.getInt("salaire")

                println("$id $name $hebdo $affect $salaire")
            }
        } catch (e : SQLException) {
            println(e.errorCode)
            println(e.message)
        }
    }


}