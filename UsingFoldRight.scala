package Assignment1

/**
  * Created by knoldus on 24/1/17.
  */
object UsingFoldRight {

  def main(args: Array[String]) {
    val list1=List("anmol","archana","saniya")
    val list2=List('a','b','c')
    val list3=List(1,2,3,4,5,6)
    val list4=List(('a',1),('b',2))
    println(s"length: ${length(list1)}")
    println(s"length: ${length(list2)}")
    println(s"length: ${length(list3)}")
    println(s"length: ${length(list4)}")
    println(hasSubsequence(List(1,2,3,4,5),List(2,3,4)))
    println("Concatenating List "+concatenateList(List(1,2,3,4),List(1,2)))
    println(s"the splitted lists are: ${spliList(List[Int](1,2,5,4,3,6),(x:Int)=>x>3)}")
  }

  def length[A](l:List[A]):Int={
    l.foldRight(0){(x,i)=>i+1}
  }

  def hasSubsequence[A](list:List[A],sub:List[A]):Boolean={
      list.containsSlice(sub)


  }

  def concatenateList[A](l1:List[A],l2:List[A]):List[A]={
    def concat(l1:List[A],l2:List[A],l3:List[A]):List[A]={
      (l1,l2)match {
        case (Nil,Nil)=>l3
        case(l1,Nil)=> l1
        case (Nil,x::list)=>concat(Nil,list,x::l3)
        case (x::list,l2)=>concat(list,l2,x::l3)
      }
    }
    concat(l1,l2,List[A]()).reverse
  }

  def spliList[A](list:List[A],f:A=>Boolean):(List[A],List[A])={
    val result1=for(x<-list if f(x)) yield x
    val result2=for(x<-list if !f(x)) yield x
    (result1,result2)
  }
}
