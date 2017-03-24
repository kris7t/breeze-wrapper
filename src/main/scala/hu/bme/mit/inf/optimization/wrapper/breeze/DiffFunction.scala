package hu.bme.mit.inf.optimization.wrapper.breeze

import breeze.linalg.DenseVector

class ValueAndGradient(val value: Double, val gradient: Array[Double])

trait DiffFunction {
  def calculate(x: Array[Double]): ValueAndGradient
}

object DiffFunction {
  implicit def toBreeze(diffFunction: DiffFunction): breeze.optimize.DiffFunction[DenseVector[Double]] =
    new breeze.optimize.DiffFunction[DenseVector[Double]] {
      override def calculate(x: DenseVector[Double]): (Double, DenseVector[Double]) = {
        val valueAndGradient = diffFunction.calculate(x.toArray)
        (valueAndGradient.value, DenseVector(valueAndGradient.gradient))
      }
    }
}
