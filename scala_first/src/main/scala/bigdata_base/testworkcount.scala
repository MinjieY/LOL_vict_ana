package bigdata_base
import java.io._
import java.text.SimpleDateFormat
import org.apache.spark.{SparkConf, SparkContext}
import java.util.Date
import java.io.{PrintWriter}
import scala.io.Source

import scala.util.matching.Regex
object testworkcount {

  def main(args: Array[String]) {

    var i=0
    while (i<100 )
    {
      val filename = args(0)
      val lines = Source.fromFile(filename).getLines.toList
      val filerow = lines.length
      val writer = new PrintWriter(new File("C:\\Users\\yingm\\Desktop\\sparkstreamingtest"+i+".txt" ))
      i=i+1
      var j=0
      while(j<i)
      {
        writer.write(lines(index(filerow)))
        println(lines(index(filerow)))
        j=j+1
      }
      writer.close()
      Thread sleep 5000
      log(getNowTime(),"C:\\Users\\yingm\\Desktop\\sparkstreamingtest"+i+".txt generated")
    }
  }
  def log(date: String, message: String)  = {
    println(date + "----" + message)
  }
  /**
   * 从每行日志解析出imei和logid
   *
   **/
  def index(length: Int) = {
    import java.util.Random
    val rdm = new Random
    rdm.nextInt(length)
  }
  def getNowTime():String={
    val now:Date = new Date()
    val datetimeFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val ntime = datetimeFormat.format( now )
    ntime
  }
  /**
   * 根据时间字符串获取时间,单位(秒)
   *
   **/
  def getTimeByString(timeString: String): Long = {
    val sf: SimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss")
    sf.parse(timeString).getTime / 1000
  }
}