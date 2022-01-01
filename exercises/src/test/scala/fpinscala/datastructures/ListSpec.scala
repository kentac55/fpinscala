package fpinscala.datastructures

import org.scalatest.wordspec.AnyWordSpec

class ListSpec extends AnyWordSpec {
  "A List" can {
    "sum()" should {
      "return their sum" in {
        assert(List.sum(Cons(1, Cons(2, Nil))) == 3)
      }
    }
  }
}
