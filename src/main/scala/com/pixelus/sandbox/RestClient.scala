import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.{BasicResponseHandler, HttpClientBuilder}
import org.apache.http.message.BasicHeader

object RestClient {
  var params: Map[String, List[String]] = _;
  var url: String = _;

  def parseArgs(args: Array[String]): Map[String, List[String]] = {

    def nameValuePair(paramName: String) = {
      def values(commaSeparatedValues: String) = commaSeparatedValues.split(",").toList

      val index = args.indexWhere(_ == paramName)
      (paramName, if (index == -1) Nil else values(args(index + 1)))
    }

    Map(nameValuePair("-d"), nameValuePair("-h"))
  }

  def splitByEqual(nameValue: String): Array[String] = nameValue.split("=")

  def headers = for (nameValue <- params("-h")) yield {
    def tokens = splitByEqual(nameValue)
    new BasicHeader(tokens(0), tokens(1))
  }

  def handleGetRequest = {
    val query = params("-d").mkString("&")
    val httpGet = new HttpGet(s"${url}?${query}")
    headers.foreach {
      httpGet.addHeader(_)
    }

    val responseBody = HttpClientBuilder.create().build().execute(httpGet, new BasicResponseHandler())
    println(responseBody)
  }

  def main(args: Array[String]) {
    require(args.size >= 2, "at least you should specify action[get] and url")
    val command = args.head
    params = parseArgs(args)
    url = args.last

    command match {
      case "get" => handleGetRequest
    }
  }
}