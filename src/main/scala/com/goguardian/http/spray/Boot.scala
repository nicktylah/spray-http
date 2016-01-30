package com.goguardian.http.spray

import akka.actor.{Actor, ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import spray.http.{HttpRequest, HttpResponse}

object Main extends App {
  implicit val system: ActorSystem = ActorSystem()
  val boot = system.actorOf(Props(classOf[Boot]))
}

class Boot extends Actor {
  import context.system

  IO(Http) ! Http.Bind(self, interface = "0.0.0.0", port = 8080)

  def receive = {
    case _: Http.Connected => sender ! Http.Register(self)
    case _: HttpRequest => sender ! HttpResponse()
  }
}
