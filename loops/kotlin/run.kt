import languages.Benchmark
import kotlin.random.Random

fun loops(u: Int): Int{
    val r: Int = Random.nextInt(10_000)
    val a = IntArray(10_000)
    for (i in 0..<10_000) {
        for (j in 0..<10_000) {
            a[i] = a[i] + j % u
        }
        a[i] = a[i] + r
    }
    return a[r]
}

fun main(args: Array<String>) {
    val runMs = args[0].toLong()
    val warmupMs = args[1].toLong()
    val n = args[2].toInt()
    Benchmark.run({ loops(n) }, warmupMs);
    val results = Benchmark.run({ loops(n) }, runMs);
    println(Benchmark.formatResults(results));
}
