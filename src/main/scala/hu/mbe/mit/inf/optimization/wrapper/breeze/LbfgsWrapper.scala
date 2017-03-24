package hu.mbe.mit.inf.optimization.wrapper.breeze

import breeze.linalg.DenseVector
import breeze.optimize.LBFGS

/**
  * Created by kris on 3/24/17.
  */
class LbfgsWrapper(maxIter: Int, m: Int, tolerance: Double) {
  private val lbfgs = new LBFGS[DenseVector[Double]](maxIter, m, tolerance)

  def minimize(diffFunction: DiffFunction, initial: Array[Double]): Array[Double] =
    lbfgs.minimize(diffFunction, DenseVector(initial)).toArray
}
