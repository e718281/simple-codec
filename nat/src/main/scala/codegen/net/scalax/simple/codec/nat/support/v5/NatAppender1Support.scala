package net.scalax.simple.adt
package nat
package support
package v5

object AppenderSupport1 {

  object Simple1 {
    trait Appender[M[_], N1[_]] {
      def append[T, B1, C1](
        abc1: ABCFunc[N1[T], B1, C1],

        ma: M[B1]
      ): M[C1]
    }

    trait One[M[_], N1[_]] {
      def one[T, B1](
        abc1: FromToFunc[N1[T], B1]
      ): M[B1]
    }

    trait Release[F[_[_]]] {
      def append[M[_], N1[_]](
        appender: Appender[M, N1],
        zero: One[M, N1]
      ): M[F[N1]]
    }
  }

  object Simple2 {
    trait Appender[M[_, _], N1[_], N2[_]] {
      def append[T, B1, B2, C1, C2](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        ma: M[B1, B2]
      ): M[C1, C2]
    }

    trait One[M[_, _], N1[_], N2[_]] {
      def one[T, B1, B2](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2]
      ): M[B1, B2]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _], N1[_], N2[_]](
        appender: Appender[M, N1, N2],
        zero: One[M, N1, N2]
      ): M[F[N1], F[N2]]
    }
  }

  object Simple3 {
    trait Appender[M[_, _, _], N1[_], N2[_], N3[_]] {
      def append[T, B1, B2, B3, C1, C2, C3](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        ma: M[B1, B2, B3]
      ): M[C1, C2, C3]
    }

    trait One[M[_, _, _], N1[_], N2[_], N3[_]] {
      def one[T, B1, B2, B3](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3]
      ): M[B1, B2, B3]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _], N1[_], N2[_], N3[_]](
        appender: Appender[M, N1, N2, N3],
        zero: One[M, N1, N2, N3]
      ): M[F[N1], F[N2], F[N3]]
    }
  }

  object Simple4 {
    trait Appender[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]] {
      def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        ma: M[B1, B2, B3, B4]
      ): M[C1, C2, C3, C4]
    }

    trait One[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]] {
      def one[T, B1, B2, B3, B4](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4]
      ): M[B1, B2, B3, B4]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]](
        appender: Appender[M, N1, N2, N3, N4],
        zero: One[M, N1, N2, N3, N4]
      ): M[F[N1], F[N2], F[N3], F[N4]]
    }
  }

  object Simple5 {
    trait Appender[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]] {
      def append[T, B1, B2, B3, B4, B5, C1, C2, C3, C4, C5](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        ma: M[B1, B2, B3, B4, B5]
      ): M[C1, C2, C3, C4, C5]
    }

    trait One[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]] {
      def one[T, B1, B2, B3, B4, B5](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5]
      ): M[B1, B2, B3, B4, B5]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]](
        appender: Appender[M, N1, N2, N3, N4, N5],
        zero: One[M, N1, N2, N3, N4, N5]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5]]
    }
  }

  object Simple6 {
    trait Appender[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, C1, C2, C3, C4, C5, C6](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        ma: M[B1, B2, B3, B4, B5, B6]
      ): M[C1, C2, C3, C4, C5, C6]
    }

    trait One[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]] {
      def one[T, B1, B2, B3, B4, B5, B6](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6]
      ): M[B1, B2, B3, B4, B5, B6]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6],
        zero: One[M, N1, N2, N3, N4, N5, N6]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6]]
    }
  }

  object Simple7 {
    trait Appender[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, C1, C2, C3, C4, C5, C6, C7](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        ma: M[B1, B2, B3, B4, B5, B6, B7]
      ): M[C1, C2, C3, C4, C5, C6, C7]
    }

    trait One[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7]
      ): M[B1, B2, B3, B4, B5, B6, B7]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7]]
    }
  }

}
