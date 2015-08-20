# TwitterTweets-Spark

## Overview

This program get real time tweets that contains a given keyword. Made using Spark and its Scala API.

## Instructions

This program requires 5 parameters to be sent via the command line.

`./bin/spark-submit --class KeywordTweets /path/to/KeywordTweets.jar <twitter Consumer Key> <twitter Consumer Secret> <twitter Access Token> <twitter Access Secret> <keyword to search>`

## Notes

This work include code licensed under the Apache License, 2.0. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0

The code taken is from the official Apache Spark repository: [link](https://github.com/apache/spark/blob/master/examples/src/main/scala/org/apache/spark/examples/streaming/TwitterPopularTags.scala)
