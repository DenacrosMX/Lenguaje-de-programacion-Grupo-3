package com.artesluisstudio

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import scala.io.StdIn

object Main extends App {

  implicit val system: ActorSystem = ActorSystem("artes-luis-studio-scala")
  implicit val ec = system.dispatcher

  // carpeta donde está tu index.html dentro de resources
  val webRoot =
    "web/artesluis_avance_3_admin_completo/" +
      "artesluis/" +
      "artesluis-frontend"

  val routes: Route =
    concat(
      pathSingleSlash {
        getFromResource(s"$webRoot/index.html")
      },
      pathPrefix("") {
        getFromResourceDirectory(webRoot)
      }
    )

  Http().newServerAt("localhost", 8080).bind(routes)

  println("==============================================")
  println("Artes Luis Studio (Scala) ejecutándose en:")
  println("http://localhost:8080")
  println("==============================================")

  StdIn.readLine()
  system.terminate()
}
