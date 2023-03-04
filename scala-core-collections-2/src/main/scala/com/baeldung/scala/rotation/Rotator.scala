package com.baeldung.scala.rotation

object Rotator {
  implicit class Wrapper[T](val sequence: Seq[T]) extends AnyVal {

    def rotatedView(index: Int): Seq[T] = useSplit(sequence, index)

    private def useSplit(sequence: Seq[T], index: Int): Seq[T] = {
      val length = sequence.length
      if (length == 0) sequence
      else {
        val normalisedIndex = (index % length + length) % length
        val (left, right) = sequence.splitAt(normalisedIndex).swap
        left ++ right
      }
    }

  }

}
