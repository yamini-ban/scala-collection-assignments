package extractors

object EmailRegex {
  private val emailRegex = """[[a-zA-Z]+.?[\w]+]+[@][a-zA-Z]+[.][a-zA-Z]+""".r

  def apply(user: String, domain: String) = s"$user@$domain"

  def unapply(arg: String): Option[(String, String)] = {
    if(emailRegex.matches(arg)) {
      Some(arg.split('@')(0), arg.split('@')(1))
    }
    else {
      None
    }
  }
}
