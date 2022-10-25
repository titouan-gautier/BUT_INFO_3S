package database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class SessionOracle {

    var conn: Connection? = null
    var username: String = "i2a01a" // provide the username
    var password = "titouangautier" // provide the corresponding password
    var database="pdb1"  // le nom de la base


    /**
     * This method makes a connection to Oracle  Server
     */


    fun getConnectionOracle(): Connection? {
        val connectionProps = Properties()
        connectionProps["user"] = username
        connectionProps["password"] = password

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
            conn = DriverManager.getConnection("jdbc:oracle:thin:@172.26.82.68:1521:pdb1",username, password);
            println("connexion réussie")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
        return conn
    }


}