name := "KeywordTweets"

version := "1.0"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.0" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.4.0" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-streaming-twitter" % "1.4.0" 

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "3.0.3" 

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"