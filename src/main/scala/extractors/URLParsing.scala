package extractors

object URLParsing {
  def apply(protocol:String,domain:String,path:String, params:Map[String,String]):String = {
    val param = for(x <- params) yield (x._1 + "=" + x._2)

    s"$protocol://$domain$path?"+ param.reduceLeft((param1, param2) => s"$param1&$param2")
  }
  def unapply(url:String):Option[(String , String, String,Map[String,String])] = {
    val urlComponents = url.split("://")
    if(urlComponents.length == 2) {
      val params = urlComponents(1).split('?')
      if(params.length == 2) {
        val domainAndPath = params(0).split("com")
        val param = params(1).split('&')
        val extractedParams = for(p <- param) yield (p.split("=")(0), p.split("=")(1))
        val extParams = extractedParams.toMap
        Some(s"${urlComponents(0)}", s"${domainAndPath(0)}com",s"${domainAndPath(1)}", extParams)
      }
      else {
        val domainAndPath = urlComponents(1).split('/')
        if(domainAndPath.length >= 2){
          Some(s"${urlComponents(0)}", s"${domainAndPath(0)}",s"/+${domainAndPath.slice(1,domainAndPath.length)}", Map.empty)
        }
        else {
          Some(urlComponents(0), domainAndPath(0), "/", Map.empty)
        }
      }
    }
    else {
      None
    }
  }
}
