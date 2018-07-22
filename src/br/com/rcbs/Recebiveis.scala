package br.com.rcbs
import scala.collection.mutable.TreeSet
import scala.collection.mutable.ListBuffer
import java.io.PrintWriter
/** Cessão de Recebíveis
 *  
 *  Problema: Minimização de perdas
 *  
 *  Esta implementação provê suporte para a minimização das perdas financeiras
 *  em transações nas quais haja a necessidade de negociação de parcelas à ceder.  
 *  
 *  Solução: Implementação de Algoritmo RMQ
 *  
 *  Em situações onde haja a necessidade de minimização de um fator(Ex.: perda) para 
 *  ajuste da solução ótima o mais efficiente é uma solução baseada em RMQ.
 *  Optamos pela solução em Scala/Java pela facilidade de expressão de idéias de modo funcional
 *  e a flexibilidade em criar tipos simples/complexos com orientação mista(OO/Funcional) 
 *  com legibilidade.
 * 
 */
object Recebiveis extends App {
  val MIN_RCBV = 50
  val MAX_RCBV = 10000
  val TOT_RCB = 7e5  
  // Multilista Nativa Implícita por Índices
  implicit class IndexesList[A](list: ListBuffer[A]){
    def apply(indices: ListBuffer[Int]) = indices map list
  }  
  // Gera sub-listas de uma lista
  def subCombinationsSum[T](xs:ListBuffer[T]):Iterator[ListBuffer[T]] =
     xs.toSet.subsets.map(_.to[ListBuffer])
  // Parcela de um recebível
  case class parcelas(var rcvb: BigDecimal,var parList:ListBuffer[BigDecimal],var perda:BigDecimal)
  val format = "Recebível , Parcelas, Valor_Perda"
  val result = StringBuilder.newBuilder
  var parcels = ListBuffer[parcelas]()
  // Arredonda parcelas para valores mais exatos da moeda corrente
  def round(v: BigDecimal) = v.setScale(2,BigDecimal.RoundingMode.HALF_UP)
  // Gera sempre 12 parcelas
  def geraParcelas(v: BigDecimal) = {
      var list = ListBuffer[BigDecimal]()
      for(i<-12 to 1 by -1) list.append(round((BigDecimal.valueOf(i.toLong))/12)*v)     
      list      
  }
  // Gera recebíveis, parcelas, analisa dados gerados gravando buffer 
  // para salvar em arquivo csv
  def processa() = {
    val aList: ListBuffer[Int] = (MIN_RCBV to MAX_RCBV).to[ListBuffer]
    val aListR: ListBuffer[Int] = aList(scala.util.Random.shuffle((0 until aList.length).to[ListBuffer]))   
    for(v <- aListR) {
      val parcelas = geraParcelas(BigDecimal.valueOf(v))
      val list = subCombinationsSum(parcelas).filter(list => list.sum==parcelas(0)).to[ListBuffer]       
      for(p <- list) {
        val sz = p.size
        val parVal = p.sum
        var perda = BigDecimal(0.0)
        sz match {
          case 1 => perda = parVal*0.001
          case 2 => perda = parVal*0.0008
          case 3 => perda = parVal*0.0006
          case 4 => perda = parVal*0.0004
          case 5 => perda = parVal*0.0003
          case 6 => perda = parVal*0.0002
          case _ => perda = parVal*0.0001
        }             
        parcels.append(new parcelas(BigDecimal(v),p,perda))        
      } 
      parcels = parcels.sortBy((_: parcelas).perda)
      for(s<-format) result.append(s);
      result.append("\n")
      result.append(parcels(0).rcvb+",")
      result.append(parcels(0).parList.mkString("|")+",")
      result.append(parcels(0).perda+"\n")
      parcels.remove(0)     
      while (!parcels.isEmpty) {
        val pr = parcels(0); parcels.remove(0)
        result.append(pr.rcvb+",")
        result.append(pr.parList.mkString("|")+",")
        result.append(pr.perda+"\n")        
      }
    }
  }
  val start = System.currentTimeMillis()
  processa()  
  new PrintWriter("Resultado_Perdas.csv") { write(result.toString); close }
  val end = System.currentTimeMillis()
  println("Tempo de execução =========> "+(end-start)/1000.0)
}
