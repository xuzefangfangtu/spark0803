package com.xuzekun.spark0803.day01

import org.apache.spark.{SparkConf, SparkContext}

object hello {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("Hello")
        val sc = new SparkContext(conf)
        val lineRDD = sc.textFile(args(0))
        val resultRDD = lineRDD.flatMap(_.split("\\W+"))
            .map((_, 1))
            .reduceByKey(_ + _)
        val wordcount = resultRDD.collect()
        wordcount.foreach(println)
        sc.stop()
    }
}
