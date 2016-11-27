package org.example


import org.json4s.JValue
import org.json4s.JsonAST.JObject

import scala.io.Source
import org.json4s.native.JsonMethods


object JsonParseExample {
  def main(args: Array[String]) {
    val filename = getClass.getResource("/test.json").getPath
    val source = Source.fromFile(filename)
    val lines = try source.mkString finally source.close()

    val json: JValue = JsonMethods.parse(lines)
    println(json)

    val neighborNode = json \ "neighbor"
    val updateNode = neighborNode \ "update"

    // Withdraw
    val withdrawNode = updateNode \ "withdraw"
    for (family <- getKeys(withdrawNode)) {
      val familyNode = withdrawNode \ family

      val withdrawnRoutes = family match {
        case "ipv4 unicast" => getKeys(familyNode)
      }
    }

    // Announce
    val announceNode = updateNode \ "announce"
    for (xxx <- getKeys(announceNode)) {
      // TODO
    }

    // Attribute
    val attributeNode = updateNode \ "attribute"
    for (xxx <- getKeys(attributeNode)) {
      // TODO
    }

  }

  def getKeys(jsonObj: JValue): List[String] = jsonObj match {
    case JObject(l) => l.map(_._1)
    case _ => List.empty
  }
}


