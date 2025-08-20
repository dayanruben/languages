import languages.Benchmark

fun main(args: Array<String>) {
    val runMs = args[0].toLong();
    val warmupMs = args[1].toLong();
    var n = args[2].toInt()
    Benchmark.run({ fibonacci(n) }, warmupMs);
    val results = Benchmark.run({ fibonacci(n) }, runMs);
    println(Benchmark.formatResults(results));
}

