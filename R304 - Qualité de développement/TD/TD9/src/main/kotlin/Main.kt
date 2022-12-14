import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString

@Serializable
data class User(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

suspend fun main() {
    val client = HttpClient(CIO)
    /*
    val response: HttpResponse = client.get("http://jsonplaceholder.typicode.com/todos/3")
    val data = response.body<String>()
    val json = Json.decodeFromString<User>(data)

     */

    val response2 = client.get("http://jsonplaceholder.typicode.com/todos/")
    val data2 = response2.body<String>()
    val json2 = Json.decodeFromString<MutableList<User>>(data2)




    /*
    val response3 =  client.get("https://dummyjson.com/products?limit=100")
    val data3 = response3.body<String>()

     */

    println(json2)

    client.close()
}


