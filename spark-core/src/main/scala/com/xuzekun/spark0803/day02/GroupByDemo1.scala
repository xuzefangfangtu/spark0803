package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object GroupByDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("GroupByDemo1")
        val sc = new SparkContext(conf)
        val arr1 = Array(30, 50, 7, 6, 1, 20)
        val RDD1 = sc.parallelize(arr1,2)
        val RDD2 = RDD1.groupBy(x => x%2)
        val RDD3 = RDD2.map {
            case (k, it) => (k, it.sum)
        }
        RDD3.collect().foreach(println)
        sc.stop()
    }
}
