package net.scalax.simple.adt
package nat
package support
package v5

object AppenderSupport1 {

  object Simple1 { SimpleSelf =>
    trait Appender[M[_], N1[_]] {
      def append[T, B1, C1](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        ma: M[B1]
      ): M[C1]
    }

    trait Zero[M[_]] {
      def zero[B1](b1: B1): M[B1]
    }

    trait Runner[F[_[_]]] {
      def append[M[_], N1[_]](
        appender: SimpleSelf.Appender[M, N1],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1]]
    }

    trait One[M[_], N1[_]] {
      def one[T, B1](func1: FromToFunc[N1[T], B1]): M[B1]
    }

    trait Release[F[_[_]]] {
      def append[M[_], N1[_]](
        appender: SimpleSelf.Appender[M, N1],
        zero: SimpleSelf.One[M, N1]
      ): M[F[N1]]
    }
  }

  object Simple2 { SimpleSelf =>
    trait Appender[M[_, _], N1[_], N2[_]] {
      def append[T, B1, B2, C1, C2](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        ma: M[B1, B2]
      ): M[C1, C2]
    }

    trait Zero[M[_, _]] {
      def zero[B1, B2](b1: B1, b2: B2): M[B1, B2]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _], N1[_], N2[_]](
        appender: SimpleSelf.Appender[M, N1, N2],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2]]
    }

    trait One[M[_, _], N1[_], N2[_]] {
      def one[T, B1, B2](func1: FromToFunc[N1[T], B1], func2: FromToFunc[N2[T], B2]): M[B1, B2]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _], N1[_], N2[_]](
        appender: SimpleSelf.Appender[M, N1, N2],
        zero: SimpleSelf.One[M, N1, N2]
      ): M[F[N1], F[N2]]
    }
  }

  object Simple3 { SimpleSelf =>
    trait Appender[M[_, _, _], N1[_], N2[_], N3[_]] {
      def append[T, B1, B2, B3, C1, C2, C3](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        ma: M[B1, B2, B3]
      ): M[C1, C2, C3]
    }

    trait Zero[M[_, _, _]] {
      def zero[B1, B2, B3](b1: B1, b2: B2, b3: B3): M[B1, B2, B3]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _], N1[_], N2[_], N3[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3]]
    }

    trait One[M[_, _, _], N1[_], N2[_], N3[_]] {
      def one[T, B1, B2, B3](func1: FromToFunc[N1[T], B1], func2: FromToFunc[N2[T], B2], func3: FromToFunc[N3[T], B3]): M[B1, B2, B3]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _], N1[_], N2[_], N3[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3],
        zero: SimpleSelf.One[M, N1, N2, N3]
      ): M[F[N1], F[N2], F[N3]]
    }
  }

  object Simple4 { SimpleSelf =>
    trait Appender[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]] {
      def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        ma: M[B1, B2, B3, B4]
      ): M[C1, C2, C3, C4]
    }

    trait Zero[M[_, _, _, _]] {
      def zero[B1, B2, B3, B4](b1: B1, b2: B2, b3: B3, b4: B4): M[B1, B2, B3, B4]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4]]
    }

    trait One[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]] {
      def one[T, B1, B2, B3, B4](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4]
      ): M[B1, B2, B3, B4]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4],
        zero: SimpleSelf.One[M, N1, N2, N3, N4]
      ): M[F[N1], F[N2], F[N3], F[N4]]
    }
  }

  object Simple5 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]] {
      def append[T, B1, B2, B3, B4, B5, C1, C2, C3, C4, C5](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        ma: M[B1, B2, B3, B4, B5]
      ): M[C1, C2, C3, C4, C5]
    }

    trait Zero[M[_, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5](b1: B1, b2: B2, b3: B3, b4: B4, b5: B5): M[B1, B2, B3, B4, B5]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5]]
    }

    trait One[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]] {
      def one[T, B1, B2, B3, B4, B5](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5]
      ): M[B1, B2, B3, B4, B5]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5]]
    }
  }

  object Simple6 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, C1, C2, C3, C4, C5, C6](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        ma: M[B1, B2, B3, B4, B5, B6]
      ): M[C1, C2, C3, C4, C5, C6]
    }

    trait Zero[M[_, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6](b1: B1, b2: B2, b3: B3, b4: B4, b5: B5, b6: B6): M[B1, B2, B3, B4, B5, B6]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6]]
    }

    trait One[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]] {
      def one[T, B1, B2, B3, B4, B5, B6](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6]
      ): M[B1, B2, B3, B4, B5, B6]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6]]
    }
  }

  object Simple7 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, C1, C2, C3, C4, C5, C6, C7](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        ma: M[B1, B2, B3, B4, B5, B6, B7]
      ): M[C1, C2, C3, C4, C5, C6, C7]
    }

    trait Zero[M[_, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7](b1: B1, b2: B2, b3: B3, b4: B4, b5: B5, b6: B6, b7: B7): M[B1, B2, B3, B4, B5, B6, B7]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7]]
    }

    trait One[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7]
      ): M[B1, B2, B3, B4, B5, B6, B7]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7]]
    }
  }

  object Simple8 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, C1, C2, C3, C4, C5, C6, C7, C8](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8]
    }

    trait Zero[M[_, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8
      ): M[B1, B2, B3, B4, B5, B6, B7, B8]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8]]
    }

    trait One[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8]]
    }
  }

  object Simple9 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, C1, C2, C3, C4, C5, C6, C7, C8, C9](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9]]
    }
  }

  object Simple10 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10]]
    }
  }

  object Simple11 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11]]
    }
  }

  object Simple12 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_], N12[
        _
      ]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12]]
    }

    trait One[
      M[_, _, _, _, _, _, _, _, _, _, _, _],
      N1[_],
      N2[_],
      N3[_],
      N4[_],
      N5[_],
      N6[_],
      N7[_],
      N8[_],
      N9[_],
      N10[_],
      N11[_],
      N12[_]
    ] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_], N12[
        _
      ]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12]]
    }
  }

  object Simple13 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_], N12[
      _
    ], N13[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13]]
    }
  }

  object Simple14 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_], N14[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_], N14[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14]]
    }
  }

  object Simple15 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_], N14[_], N15[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_], N15[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_], N14[_], N15[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15]]
    }
  }

  object Simple16 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
        _
      ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_], N15[_], N16[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
        _
      ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16]]
    }
  }

  object Simple17 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        B17,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16,
        C17
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        abc17: net.scalax.simple.adt.nat.support.ABCFunc[N17[T], B17, C17],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16,
        b17: B17
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
        _
      ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16],
        func17: FromToFunc[N17[T], B17]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
        _
      ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17]]
    }
  }

  object Simple18 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        B17,
        B18,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16,
        C17,
        C18
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        abc17: net.scalax.simple.adt.nat.support.ABCFunc[N17[T], B17, C17],
        abc18: net.scalax.simple.adt.nat.support.ABCFunc[N18[T], B18, C18],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16,
        b17: B17,
        b18: B18
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16],
        func17: FromToFunc[N17[T], B17],
        func18: FromToFunc[N18[T], B18]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ]]
    }
  }

  object Simple19 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        B17,
        B18,
        B19,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16,
        C17,
        C18,
        C19
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        abc17: net.scalax.simple.adt.nat.support.ABCFunc[N17[T], B17, C17],
        abc18: net.scalax.simple.adt.nat.support.ABCFunc[N18[T], B18, C18],
        abc19: net.scalax.simple.adt.nat.support.ABCFunc[N19[T], B19, C19],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16,
        b17: B17,
        b18: B18,
        b19: B19
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16],
        func17: FromToFunc[N17[T], B17],
        func18: FromToFunc[N18[T], B18],
        func19: FromToFunc[N19[T], B19]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19]]
    }
  }

  object Simple20 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
      _
    ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        B17,
        B18,
        B19,
        B20,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16,
        C17,
        C18,
        C19,
        C20
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        abc17: net.scalax.simple.adt.nat.support.ABCFunc[N17[T], B17, C17],
        abc18: net.scalax.simple.adt.nat.support.ABCFunc[N18[T], B18, C18],
        abc19: net.scalax.simple.adt.nat.support.ABCFunc[N19[T], B19, C19],
        abc20: net.scalax.simple.adt.nat.support.ABCFunc[N20[T], B20, C20],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16,
        b17: B17,
        b18: B18,
        b19: B19,
        b20: B20
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16],
        func17: FromToFunc[N17[T], B17],
        func18: FromToFunc[N18[T], B18],
        func19: FromToFunc[N19[T], B19],
        func20: FromToFunc[N20[T], B20]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20]]
    }
  }

  object Simple21 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
      _
    ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        B17,
        B18,
        B19,
        B20,
        B21,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16,
        C17,
        C18,
        C19,
        C20,
        C21
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        abc17: net.scalax.simple.adt.nat.support.ABCFunc[N17[T], B17, C17],
        abc18: net.scalax.simple.adt.nat.support.ABCFunc[N18[T], B18, C18],
        abc19: net.scalax.simple.adt.nat.support.ABCFunc[N19[T], B19, C19],
        abc20: net.scalax.simple.adt.nat.support.ABCFunc[N20[T], B20, C20],
        abc21: net.scalax.simple.adt.nat.support.ABCFunc[N21[T], B21, C21],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16,
        b17: B17,
        b18: B18,
        b19: B19,
        b20: B20,
        b21: B21
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
        _
      ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20], F[N21]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16],
        func17: FromToFunc[N17[T], B17],
        func18: FromToFunc[N18[T], B18],
        func19: FromToFunc[N19[T], B19],
        func20: FromToFunc[N20[T], B20],
        func21: FromToFunc[N21[T], B21]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
        _
      ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_]](
        appender: SimpleSelf.Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20], F[N21]]
    }
  }

  object Simple22 { SimpleSelf =>
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
      _
    ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_], N22[_]] {
      def append[
        T,
        B1,
        B2,
        B3,
        B4,
        B5,
        B6,
        B7,
        B8,
        B9,
        B10,
        B11,
        B12,
        B13,
        B14,
        B15,
        B16,
        B17,
        B18,
        B19,
        B20,
        B21,
        B22,
        C1,
        C2,
        C3,
        C4,
        C5,
        C6,
        C7,
        C8,
        C9,
        C10,
        C11,
        C12,
        C13,
        C14,
        C15,
        C16,
        C17,
        C18,
        C19,
        C20,
        C21,
        C22
      ](
        abc1: net.scalax.simple.adt.nat.support.ABCFunc[N1[T], B1, C1],
        abc2: net.scalax.simple.adt.nat.support.ABCFunc[N2[T], B2, C2],
        abc3: net.scalax.simple.adt.nat.support.ABCFunc[N3[T], B3, C3],
        abc4: net.scalax.simple.adt.nat.support.ABCFunc[N4[T], B4, C4],
        abc5: net.scalax.simple.adt.nat.support.ABCFunc[N5[T], B5, C5],
        abc6: net.scalax.simple.adt.nat.support.ABCFunc[N6[T], B6, C6],
        abc7: net.scalax.simple.adt.nat.support.ABCFunc[N7[T], B7, C7],
        abc8: net.scalax.simple.adt.nat.support.ABCFunc[N8[T], B8, C8],
        abc9: net.scalax.simple.adt.nat.support.ABCFunc[N9[T], B9, C9],
        abc10: net.scalax.simple.adt.nat.support.ABCFunc[N10[T], B10, C10],
        abc11: net.scalax.simple.adt.nat.support.ABCFunc[N11[T], B11, C11],
        abc12: net.scalax.simple.adt.nat.support.ABCFunc[N12[T], B12, C12],
        abc13: net.scalax.simple.adt.nat.support.ABCFunc[N13[T], B13, C13],
        abc14: net.scalax.simple.adt.nat.support.ABCFunc[N14[T], B14, C14],
        abc15: net.scalax.simple.adt.nat.support.ABCFunc[N15[T], B15, C15],
        abc16: net.scalax.simple.adt.nat.support.ABCFunc[N16[T], B16, C16],
        abc17: net.scalax.simple.adt.nat.support.ABCFunc[N17[T], B17, C17],
        abc18: net.scalax.simple.adt.nat.support.ABCFunc[N18[T], B18, C18],
        abc19: net.scalax.simple.adt.nat.support.ABCFunc[N19[T], B19, C19],
        abc20: net.scalax.simple.adt.nat.support.ABCFunc[N20[T], B20, C20],
        abc21: net.scalax.simple.adt.nat.support.ABCFunc[N21[T], B21, C21],
        abc22: net.scalax.simple.adt.nat.support.ABCFunc[N22[T], B22, C22],
        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22]
    }

    trait Zero[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
      def zero[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22](
        b1: B1,
        b2: B2,
        b3: B3,
        b4: B4,
        b5: B5,
        b6: B6,
        b7: B7,
        b8: B8,
        b9: B9,
        b10: B10,
        b11: B11,
        b12: B12,
        b13: B13,
        b14: B14,
        b15: B15,
        b16: B16,
        b17: B17,
        b18: B18,
        b19: B19,
        b20: B20,
        b21: B21,
        b22: B22
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22]
    }

    trait Runner[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
        _
      ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_], N22[_]](
        appender: SimpleSelf.Appender[
          M,
          N1,
          N2,
          N3,
          N4,
          N5,
          N6,
          N7,
          N8,
          N9,
          N10,
          N11,
          N12,
          N13,
          N14,
          N15,
          N16,
          N17,
          N18,
          N19,
          N20,
          N21,
          N22
        ],
        zero: SimpleSelf.Zero[M]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20], F[N21], F[N22]]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
      _
    ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_], N22[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22](
        func1: FromToFunc[N1[T], B1],
        func2: FromToFunc[N2[T], B2],
        func3: FromToFunc[N3[T], B3],
        func4: FromToFunc[N4[T], B4],
        func5: FromToFunc[N5[T], B5],
        func6: FromToFunc[N6[T], B6],
        func7: FromToFunc[N7[T], B7],
        func8: FromToFunc[N8[T], B8],
        func9: FromToFunc[N9[T], B9],
        func10: FromToFunc[N10[T], B10],
        func11: FromToFunc[N11[T], B11],
        func12: FromToFunc[N12[T], B12],
        func13: FromToFunc[N13[T], B13],
        func14: FromToFunc[N14[T], B14],
        func15: FromToFunc[N15[T], B15],
        func16: FromToFunc[N16[T], B16],
        func17: FromToFunc[N17[T], B17],
        func18: FromToFunc[N18[T], B18],
        func19: FromToFunc[N19[T], B19],
        func20: FromToFunc[N20[T], B20],
        func21: FromToFunc[N21[T], B21],
        func22: FromToFunc[N22[T], B22]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
        _
      ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_], N22[_]](
        appender: SimpleSelf.Appender[
          M,
          N1,
          N2,
          N3,
          N4,
          N5,
          N6,
          N7,
          N8,
          N9,
          N10,
          N11,
          N12,
          N13,
          N14,
          N15,
          N16,
          N17,
          N18,
          N19,
          N20,
          N21,
          N22
        ],
        zero: SimpleSelf.One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20], F[N21], F[N22]]
    }
  }

}
