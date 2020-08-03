package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object FlatMapDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("FlatMapDemo1")
        val sc = new SparkContext(conf)
        val list1 = List(1 to 3,1 to 5,10 to 20)
        val RDD1 = sc.parallelize(list1,2)
        val RDD2 = RDD1.flatMap(x => x)

        val arr1 = Array(30, 50, 70, 60, 10, 20)
        val RDD3 = sc.parallelize(arr1,2)
        val RDD4 = RDD3.flatMap(x => List(x, x * x, x * x * x))
        RDD2.collect().foreach(println)
        RDD4.collect().foreach(println)
        sc.stop()

    }
}
