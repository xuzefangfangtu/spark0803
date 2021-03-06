package com.xuzekun.spark0803.day02

import org.apache.spark.{SparkConf, SparkContext}

object SampleDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setMaster("local[2]").setAppName("SampleDemo1")
        val sc = new SparkContext(conf)
        val list1 = 1 to 20
        val RDD1 = sc.parallelize(list1,2)
        val RDD2 = RDD1.sample(true,2)
        RDD2.collect().foreach(println)
        sc.stop()
    }
}
