import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.http.*

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.jackson.jackson
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*





fun main() {


    val port = 8082
    val server = embeddedServer(Netty, port = port, host = "0.0.0.0", module = Application::mainModule)

    server.start(wait = true)

}


fun Application.mainModule(){


    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }

    }
    routing {
        get {
//                context.respondText { "Hello -> World!" }


            context.respond(mapOf("Hello" to "World!"))

        }


        get("/{name}") {

            val name = call.request.queryParameters["age"]
            val namePara = call.parameters["name"]
            context.respond(mapOf("name" to name, "namePara" to namePara))
        }

    }
}