package com.artesluisstudio

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import java.io.File
import java.nio.file.Paths
import scala.io.StdIn

object Main extends App {

  implicit val system: ActorSystem = ActorSystem("artes-luis-studio-scala")
  implicit val ec = system.dispatcher

  // carpeta donde está tu index.html dentro de resources
  val webRoot =
    "web/artesluis_avance_3_admin_completo/" +
      "artesluis/" +
      "artesluis-frontend"

  val webDir = Paths.get("src", "main", "resources", webRoot).toFile
  val useFilesystem = webDir.exists() && webDir.isDirectory
  val adminFile = new File(webDir, "admin.html")

  def indexRoute: Route =
    if (useFilesystem) {
      getFromFile(new File(webDir, "index.html"))
    } else {
      getFromResource(s"$webRoot/index.html")
    }

  def assetsRoute: Route =
    if (useFilesystem) {
      getFromDirectory(webDir.getPath)
    } else {
      getFromResourceDirectory(webRoot)
    }

  val routes: Route =
    concat(
      pathSingleSlash {
        indexRoute
      },
      pathPrefix("") {
        assetsRoute
      }
    )

  Http().newServerAt("localhost", 8080).bind(routes)

  println("==============================================")
  println("Artes Luis Studio (Scala) ejecutándose en:")
  println("http://localhost:8080")
  println(s"Static mode: ${if (useFilesystem) "filesystem" else "classpath"}")
  if (useFilesystem) {
    println(s"admin.html path: ${adminFile.getAbsolutePath}")
    println(s"admin.html size: ${adminFile.length()} bytes")
  }
  println("==============================================")

  StdIn.readLine()
  system.terminate()
}
