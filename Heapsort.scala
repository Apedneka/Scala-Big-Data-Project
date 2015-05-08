import Big_data_project1._
import scala.collection.mutable.PriorityQueue

object Heapsort {
  def priorityQueue(x: PriorityQueue[Node]){
    // Get line, split elements and write to array[object]
    println("What is the file name?")
    var fileName = Console.readLine().toString
    for (line <- scala.io.Source.fromFile(fileName).getLines){
      val temp = line.split("\t")
      val obj = new Node(temp(0).toFloat, temp(1))  // Write to new object
      //find min and replace... tomorrow 
      x.enqueue(obj)
    }
  }
}
