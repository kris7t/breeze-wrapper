package hu.mbe.mit.inf.optimization.wrapper.breeze

import breeze.linalg.DenseVector

class ValueAndGradient(val value: Double, val gradient: Array[Double])

/**
  * Created by kris on 3/24/17.
  */
abstract class DiffFunction extends breeze.optimize.DiffFunction[DenseVector[Double]] {
  override def calculate(x: DenseVector[Double]): (Double, DenseVector[Double]) = {
    val valueAndGradient = calculate(x.toArray)
    (valueAndGradient.value, DenseVector(valueAndGradient.gradient))
  }

  def calculate(x: Array[Double]): ValueAndGradient
}
