import Big_data_project1._
import scala.annotation.tailrec

object HGDistribution {

import scala.math.BigDecimal

  def calculator (k: Int, n: Int, K: Int, N: Int ): BigDecimal = { 
      

  var n_fact= BigDecimal.apply(n)            // n
  var k_fact= BigDecimal.apply(k)            // k
  var K_fact= BigDecimal.apply(K)            // K
  var N_fact = BigDecimal.apply(N)           // N


  var NminusK_fact= N - K   // N - K
  var nMinusk_fact= n - k   // n - k
  
   var Nn = biCoe(N_fact, n_fact)
   var Kk = biCoe(K_fact,k_fact)
   var nk = biCoe(NminusK_fact,nMinusk_fact)
   
   var answer = (Kk * nk)/Nn

  return answer
}

  def biCoe(a: BigDecimal, b: BigDecimal): BigDecimal = {
    var bg_answer= BigDecimal.apply(0) 
      return factorial(a) /  (factorial(b) * factorial(a - b))
  }



  
  def factorial(n_int: BigDecimal): BigDecimal = {
    //var m = BigDecimal.apply(1) 
    @tailrec def factorialAcc(acc: BigDecimal, n: BigDecimal): BigDecimal = {
      if (n <= 1) acc
      else return factorialAcc(n * acc, n - 1)
    }
    factorialAcc(1, n_int)
  }

  
//  def factorial(n_fact: BigDecimal): BigDecimal = {
//    if (n_fact<=1)  
//      return 1
//    else
//      return n_fact * factorial(n_fact -1)
//  }
}