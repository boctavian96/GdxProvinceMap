package performance;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

public class MapFrameworkBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void test(){}


}
