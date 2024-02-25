package com.first.flink.examples;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
public class WordCountBatchByJava {
    public static void main(String[] args) throws Exception {
// set up the batch execution environment
final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
// 通过字符串构建数据集
        DataSet<String> text = env.fromElements(
                "I am jelly ",
                "Hello jerry",
                "Good morning ... jelly",
                "this is bigdata basic course."
        );
// 分割字符串，按照key进行分组，统计相同的key个数
        DataSet<Tuple2<String, Integer>> wordCount = text
                .flatMap(new LineSplitter())
                .groupBy(0)
                .sum(1);
        wordCount.print();
// execute program
// env.execute("Flink Batch Java API Skeleton");
    }
// 分割字符串的方法
    public static class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String line, Collector<Tuple2<String, Integer>> out) {
            for (String word : line.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }
}
