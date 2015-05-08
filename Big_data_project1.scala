import Heapsort._
import Map._
import HGDistribution._
import scala.math.Ordering.Implicits._
import java.util.PriorityQueue; // importing priority queue
//import scala.collection.mutable

object Big_data_project1 {

import scala.io.Source
import java.io.File
import java.lang.String
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.PriorityQueue
  
  def main(args: Array[String]) {
    //reading in file

    var popArray : ArrayBuffer[Node] = new ArrayBuffer[Node];          // Mutable array for object
    var sampleArray : ArrayBuffer[Node] = new ArrayBuffer[Node];       // Mutable array for sample list
    
    def compare(a: Node) : Float = a.rank
    var popQueue = new PriorityQueue[Node]()(Ordering.by(tempObj => compare(tempObj))) // priority queue 1
    var samQueue = new PriorityQueue[Node]()(Ordering.by(tempObj => compare(tempObj))) // priority queue 2
    
    var bigK = scala.collection.mutable.Map[String, Int]()
    var smallK = scala.collection.mutable.Map[String, Int]()
    
    // setup popQueue
    Heapsort.priorityQueue(popQueue)
    
    var copy_popQueue = popQueue.clone();
    var copy_popQueue_n = popQueue.clone();
    
    println("Please input n:")
    var n = Console.readLine().toInt
    
    // Create sample queue with top n number
    for (i <- 1 to n ){
      var newObj = copy_popQueue_n.dequeue
      // enqueue to sample queue
      samQueue.enqueue(newObj)
    }
    
   // Get all big K
    while (copy_popQueue.nonEmpty){
      var newObj = copy_popQueue.dequeue
      if (bigK.contains(newObj.cat)){
        var temp = bigK.apply(newObj.cat)
        temp += 1
        bigK(newObj.cat) = temp
      }
      else {
        bigK += (newObj.cat -> 1)
      }
    }
    
    // Get all small K
    var copy_samQueue = samQueue.clone();
    while (copy_samQueue.nonEmpty){
      var newObj = copy_samQueue.dequeue
      if (smallK.contains(newObj.cat)){
        var temp = smallK.apply(newObj.cat)
        temp += 1
        smallK(newObj.cat) = temp
      }
      else {
        smallK += (newObj.cat -> 1)
      }
    }
    

    println("-----------------------ORIGINAL DATASET (K)-----------------------\n")
    for ((k,v) <- bigK) 
      printf("key: %s, value: %s\n", k, v)
    println("\n")
     println("-----------------------SAMPLE DATASET (top n)-----------------------\n")
    for ((k,v) <- smallK)     
      printf("key: %s, value: %s\n", k, v)

    
    
    // Get big N
    var bigN = 0
    for ((k,v) <- bigK)     
      bigN += v

    // Get small n
    var smallN = n //smallK.size

    Calculating_HGD.cal(bigK, smallK, bigN, smallN)
    
    //HGDistribution.calculator(smallK.apply("N"), smallN, bigK.apply("N"), bigN)
  }
 
  class Node(x: Float, y: String) {
  	var rank: Float = x
  	var cat: String = y
  }
}