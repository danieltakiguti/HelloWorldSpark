import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.hive.HiveContext


object teste {

  def main(args: Array[String]) {

    val conf = new SparkConf()
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.driver.allowMultipleContexts", "true")
      .set("hive.exec.dynamic.partition", "true")
      .set("hive.exec.dynamic.partition.mode", "nonstrict")
      .setAppName("Hello World!")

    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)

    val resultDF = sqlContext.sql("select count(*) from table")
    resultDF.show()

  }

}