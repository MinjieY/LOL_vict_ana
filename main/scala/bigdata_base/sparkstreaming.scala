package bigdata_base

import org.apache.spark.SparkConf
import org.apache.spark.streaming._;
object SparkStreaming {

  def main(args: Array[String]) {
    //开本地线程两个处理，local[4]：意思本地起4个进程运行，setAppName("SparkStreaming")：设置运行处理类
    val conf = new SparkConf().setMaster("local[4]").setAppName("SparkStreaming")
    //每隔5秒计算一批数据
    val ssc = new StreamingContext(conf, Seconds(5))
    // 指定监控的目录
    val lines = ssc.textFileStream("C:\\Users\\yingm\\Desktop\\sparkstreamingtest")
    //按\t 切分输入数据
    val words = lines.flatMap(_.split(" "))
    //计算wordcount
    val pairs = words.map(word => (word, 1))
    //word ++
    val wordCounts = pairs.reduceByKey(_ + _)
    //排序结果集打印，先转成rdd，然后排序true升序，false降序，可以指定key和value排序_._1是key，_._2是value
    val sortResult = wordCounts.transform(rdd => rdd.sortBy(_._2, false))
    sortResult.print()
    ssc.start() // 开启计算
    ssc.awaitTermination() // 阻塞等待计算
  }
}