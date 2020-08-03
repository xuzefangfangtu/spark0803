package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object MapDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("MapDemo1")
        val sc = new SparkContext(conf)
        val arr1 = Array(30, 50, 70, 60, 10, 20)
        val RDD1 = sc.makeRDD(arr1,2)
        val RDD2 = RDD1.map(_ * 2)
        val result = RDD2.collect()
        result.foreach(println)
        sc.stop()

    }
}
