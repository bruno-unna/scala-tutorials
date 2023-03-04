package com.baeldung.scala.rotation

import org.scalatest.wordspec.AnyWordSpec

class RotatorSpec extends AnyWordSpec {
  import Rotator._

  "A rotator of collections" should {

    "do nothing to an empty list" in {
      val sequence = Vector.empty[Char]
      assert(sequence.rotatedView(8).isEmpty)
    }

    "do nothing when the rotation is zero" in {
      val sequence = Vector('a', 'b', 'c', 'd', 'e')
      assertResult(sequence)(sequence.rotatedView(0))
    }

    "handle positive rotations" in {
      val sequence = Vector('a', 'b', 'c', 'd', 'e')
      assertResult(Vector('b', 'c', 'd', 'e', 'a'))(sequence.rotatedView(1))
      assertResult(Vector('e', 'a', 'b', 'c', 'd'))(sequence.rotatedView(4))
      assertResult(Vector('b', 'c', 'd', 'e', 'a'))(sequence.rotatedView(6))
    }

    "handle negative rotations" in {
      val sequence = Vector('a', 'b', 'c', 'd', 'e')
      assertResult(Vector('b', 'c', 'd', 'e', 'a'))(sequence.rotatedView(-4))
      assertResult(Vector('e', 'a', 'b', 'c', 'd'))(sequence.rotatedView(-1))
      assertResult(Vector('a', 'b', 'c', 'd', 'e'))(sequence.rotatedView(-10))
    }

  }

}
