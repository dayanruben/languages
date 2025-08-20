import java.io.File
import languages.Benchmark

fun distances(strings: List<String>): List<Int> {
    val distances = mutableListOf<Int>()
    // Compare all pairs and store their distances
    for (i in strings.indices) {
        val start = i + 1
        for (j in start..strings.lastIndex) {
            distances += levenshteinDistance(strings[i], strings[j]);
        }
    }
    return distances;
}

fun main(args: Array<String>) {
    val runMs = args[0].toLong()
    val warmupMs = args[1].toLong()
    val inputPath = args[2];
    val strings = File(inputPath).readLines()
    Benchmark.run({ distances(strings) }, warmupMs);
    val results = Benchmark.run({ distances(strings) }, runMs);
    val summedResults = results.withResult(results.result().sum())
    println(Benchmark.formatResults(summedResults));
}
