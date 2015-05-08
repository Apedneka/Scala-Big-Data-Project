import Big_data_project1._
import HGDistribution._


object Calculating_HGD {
  def cal( K: scala.collection.mutable.Map[String, Int], k: scala.collection.mutable.Map[String, Int], N: Int, n: Int) {
    var rank = scala.collection.mutable.Map[String, BigDecimal]()
    
    for ((s,i) <- K) {
      if (k.contains(s)){
        // Big K
        var temp = K.apply(s)
        // Small k
        var temp1 = k.apply(s)
        
        println("Calculating...")
        var answer = HGDistribution.calculator(temp1, n, temp , N)

        rank(s) = answer
      } 
      else {
        // Not contain, rank k = 0
        var temp = K.apply(s)
        var answer = HGDistribution.calculator(0, n, temp , N)
        rank(s) = answer
      }
    }
    
    // Sort
    var t = rank.toSeq.sorted(Ordering by ((_: (String, BigDecimal))._2)).reverse

    println("\n")
    println("-----------------------FINAL RESULT DATASET ----------------------------\n")
    for ((k,v) <- t)     
      printf("key: %s, value: %s\n", k, v)
    
  }
}