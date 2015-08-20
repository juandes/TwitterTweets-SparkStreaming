import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import org.apache.spark.SparkConf

object KeywordTweets {
  def main(args: Array[String]) {
    if (args.length < 5) {
      System.err.println("Usage: KeywordTweets <consumer key> <consumer secret> " +
        "<access token> <access token secret> <keyword>")
      System.exit(1)
    }

    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters = args.takeRight(args.length - 4)    
    
    // Set the system properties so that Twitter4j library used by twitter stream
    // can use them to generate OAuth credentials
    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)

    val sparkConf = new SparkConf().setAppName("Keyword Tweets")
    val ssc = new StreamingContext(sparkConf, Seconds(5))
    val stream = TwitterUtils.createStream(ssc, None, filters)
    
    // Filter by the given keyword
    val tweets = stream.map(status => status.getText).filter(_.contains(args(4)))
                 
    tweets.print()

    ssc.start()
    ssc.awaitTermination()
  }
}