package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object GlomDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("GlomDemo1")
        val sc = new SparkContext(conf)
        val arr1 = Array(30, 50, 70, 60, 10, 20)
        val RDD1 = sc.parallelize(arr1,2)
        val RDD2 = RDD1.glom().map(_.toList)
        RDD2.collect().foreach(println)
        sc.stop()
    }
}
