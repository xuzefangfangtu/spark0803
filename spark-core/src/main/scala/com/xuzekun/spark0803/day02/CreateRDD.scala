package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object CreateRDD {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("CreateRDD")
        val sc = new SparkContext(conf)
        val arr1 = Array(30, 50, 70, 60, 10, 20)
//        val rdd = sc.parallelize(arr1)
        val rdd = sc.makeRDD(arr1)
        val array = rdd.collect()
        array.foreach(println)
        sc.stop()
    }
}
