package extractors

object AppDriver extends App {

  try {
    val ExtractDayFromTimeStamp(day: String) = "12-21-2001 21:12:12"

    println(s"Day = $day")

    val url = s"https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112"

    val URLParsing(protocol: String, domain: String, path: String, params: Map[String, String]) = url

    println(s"Protocol = $protocol")

    println(s"Domain = $domain")

    println(s"Path = $path")

    println(s"Params = $params")

    val email = "yamini.bansal@knoldus.com"

    val EmailRegex(user: String, dom: String) = email

    println(email)

    println(s"user = $user")

    println(s"dom = $dom")

  }
  catch {
    case exception: MatchError => println("content not found @ " + exception.getMessage)
  }
}
