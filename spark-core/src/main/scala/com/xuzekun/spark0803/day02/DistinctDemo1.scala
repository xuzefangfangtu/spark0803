package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object DistinctDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("DistinctDemo1")
        val sc = new SparkContext(conf)
        val list1 = List(30,2,2,55,65,55,222,11)
        val RDD1 = sc.parallelize(list1,2)
        val RDD2 = RDD1.distinct()
        RDD2.collect().foreach(println)
        sc.stop()
    }
}
