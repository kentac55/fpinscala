package fpinscala.datastructures

import org.scalatest.wordspec.AnyWordSpec

class ListSpec extends AnyWordSpec {
  val l = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))
  "A List" can {
    "x" should {
      "3" in {
        assert(List.x == 3)
      }
    }

    "tail()" should {
      "与えられたListのtailを返す" in {
        assert(List.tail(l) == Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))
      }
      "与えられたListがNilだった場合エラー" in {
        intercept[IllegalArgumentException] {
          List.tail(Nil)
        }
      }
    }

    "setHead()" should {
      "与えられたListのHeadを与えられた値にしたListを返す" in {
        assert(List.setHead(l, -1) == Cons(-1, Cons(2, Cons(3, Cons(4, Cons(5, Nil))))))
      }
      "与えられたListがNilだった場合エラー" in {
        intercept[IllegalArgumentException] {
          List.setHead(Nil, -1)
        }
      }
    }

    "drop()" should {
      "与えられたListから与えられた回数Headを除去したListを返す" in {
        assert(List.drop(l, 1) == Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))
        assert(List.drop(l, 2) == Cons(3, Cons(4, Cons(5, Nil))))
      }
      "与えられたListの長さよりも与えられた回数のほうが多かった場合エラー" in {
        intercept[IllegalArgumentException] {
          List.drop(l, 6)
        }
      }
      "与えられた回数が負の場合エラー" in {
        intercept[IllegalArgumentException] {
          List.drop(l, -1)
        }
      }
    }

    "dropWhile()" should {
      "与えられた述語のマッチするまでHeadを除去したListを返す" in {
        assert(List.dropWhile(l, (i: Int) => i == 4) == Cons(4, Cons(5, Nil)))
        assert(List.dropWhile(l, (i: Int) => i == 6) == Nil)
      }
    }

    "init()" should {
      "与えられたListの末尾を除いたListを返す" in {
        assert(List.init(l) == Cons(1, Cons(2, Cons(3, Cons(4, Nil)))))
      }

      "与えられたListがNilの場合エラー" in {
        intercept[IllegalArgumentException] {
          List.init(Nil)
        }
      }
    }

    "length()" should {
      "与えられたListの長さを返す" in {
        assert(List.length(l) == 5)
      }
    }

    "foldLeft()" should {
      "左畳み込み" in {
        assert(List.foldLeft(l, 10)(_ + _) == 25)
        assert(List.foldLeft[Int, Int](Nil, 10)(_ + _) == 10)
      }
    }

    "map()" should {
      "まっぷ" in {
        assert(List.map(l)(_ + 1) == Cons(2, Cons(3, Cons(4, Cons(5, Cons(6, Nil))))))
      }
    }
  }
}
