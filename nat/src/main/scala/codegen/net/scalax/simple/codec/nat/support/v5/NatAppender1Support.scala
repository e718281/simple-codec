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

  object Simple8 {
    trait Appender[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, C1, C2, C3, C4, C5, C6, C7, C8](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8]
    }

    trait One[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8]]
    }
  }

  object Simple9 {
    trait Appender[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, C1, C2, C3, C4, C5, C6, C7, C8, C9](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9]
    }

    trait One[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9]]
    }
  }

  object Simple10 {
    trait Appender[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10]]
    }
  }

  object Simple11 {
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11]]
    }
  }

  object Simple12 {
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12]
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
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_], N12[
        _
      ]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12]]
    }
  }

  object Simple13 {
    trait Appender[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_]] {
      def append[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13](
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[_], N12[
      _
    ], N13[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13]]
    }
  }

  object Simple14 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_], N14[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14]]
    }
  }

  object Simple15 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_], N15[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
        _
      ], N12[_], N13[_], N14[_], N15[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15]]
    }
  }

  object Simple16 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[_], N11[
      _
    ], N12[_], N13[_], N14[_], N15[_], N16[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
        _
      ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16]]
    }
  }

  object Simple17 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        abc17: ABCFunc[N17[T], B17, C17],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16],

        abc17: FromToFunc[N17[T], B17]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
        _
      ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17]]
    }
  }

  object Simple18 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        abc17: ABCFunc[N17[T], B17, C17],

        abc18: ABCFunc[N18[T], B18, C18],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[_], N10[
      _
    ], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16],

        abc17: FromToFunc[N17[T], B17],

        abc18: FromToFunc[N18[T], B18]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ]]
    }
  }

  object Simple19 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        abc17: ABCFunc[N17[T], B17, C17],

        abc18: ABCFunc[N18[T], B18, C18],

        abc19: ABCFunc[N19[T], B19, C19],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16],

        abc17: FromToFunc[N17[T], B17],

        abc18: FromToFunc[N18[T], B18],

        abc19: FromToFunc[N19[T], B19]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19]]
    }
  }

  object Simple20 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        abc17: ABCFunc[N17[T], B17, C17],

        abc18: ABCFunc[N18[T], B18, C18],

        abc19: ABCFunc[N19[T], B19, C19],

        abc20: ABCFunc[N20[T], B20, C20],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16],

        abc17: FromToFunc[N17[T], B17],

        abc18: FromToFunc[N18[T], B18],

        abc19: FromToFunc[N19[T], B19],

        abc20: FromToFunc[N20[T], B20]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
        _
      ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20]]
    }
  }

  object Simple21 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        abc17: ABCFunc[N17[T], B17, C17],

        abc18: ABCFunc[N18[T], B18, C18],

        abc19: ABCFunc[N19[T], B19, C19],

        abc20: ABCFunc[N20[T], B20, C20],

        abc21: ABCFunc[N21[T], B21, C21],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[_], N9[
      _
    ], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16],

        abc17: FromToFunc[N17[T], B17],

        abc18: FromToFunc[N18[T], B18],

        abc19: FromToFunc[N19[T], B19],

        abc20: FromToFunc[N20[T], B20],

        abc21: FromToFunc[N21[T], B21]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
        _
      ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20], F[N21]]
    }
  }

  object Simple22 {
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
        abc1: ABCFunc[N1[T], B1, C1],

        abc2: ABCFunc[N2[T], B2, C2],

        abc3: ABCFunc[N3[T], B3, C3],

        abc4: ABCFunc[N4[T], B4, C4],

        abc5: ABCFunc[N5[T], B5, C5],

        abc6: ABCFunc[N6[T], B6, C6],

        abc7: ABCFunc[N7[T], B7, C7],

        abc8: ABCFunc[N8[T], B8, C8],

        abc9: ABCFunc[N9[T], B9, C9],

        abc10: ABCFunc[N10[T], B10, C10],

        abc11: ABCFunc[N11[T], B11, C11],

        abc12: ABCFunc[N12[T], B12, C12],

        abc13: ABCFunc[N13[T], B13, C13],

        abc14: ABCFunc[N14[T], B14, C14],

        abc15: ABCFunc[N15[T], B15, C15],

        abc16: ABCFunc[N16[T], B16, C16],

        abc17: ABCFunc[N17[T], B17, C17],

        abc18: ABCFunc[N18[T], B18, C18],

        abc19: ABCFunc[N19[T], B19, C19],

        abc20: ABCFunc[N20[T], B20, C20],

        abc21: ABCFunc[N21[T], B21, C21],

        abc22: ABCFunc[N22[T], B22, C22],

        ma: M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22]
      ): M[C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22]
    }

    trait One[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
      _
    ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_], N22[_]] {
      def one[T, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22](
        abc1: FromToFunc[N1[T], B1],

        abc2: FromToFunc[N2[T], B2],

        abc3: FromToFunc[N3[T], B3],

        abc4: FromToFunc[N4[T], B4],

        abc5: FromToFunc[N5[T], B5],

        abc6: FromToFunc[N6[T], B6],

        abc7: FromToFunc[N7[T], B7],

        abc8: FromToFunc[N8[T], B8],

        abc9: FromToFunc[N9[T], B9],

        abc10: FromToFunc[N10[T], B10],

        abc11: FromToFunc[N11[T], B11],

        abc12: FromToFunc[N12[T], B12],

        abc13: FromToFunc[N13[T], B13],

        abc14: FromToFunc[N14[T], B14],

        abc15: FromToFunc[N15[T], B15],

        abc16: FromToFunc[N16[T], B16],

        abc17: FromToFunc[N17[T], B17],

        abc18: FromToFunc[N18[T], B18],

        abc19: FromToFunc[N19[T], B19],

        abc20: FromToFunc[N20[T], B20],

        abc21: FromToFunc[N21[T], B21],

        abc22: FromToFunc[N22[T], B22]
      ): M[B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22]
    }

    trait Release[F[_[_]]] {
      def append[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_], N8[
        _
      ], N9[_], N10[_], N11[_], N12[_], N13[_], N14[_], N15[_], N16[_], N17[_], N18[_], N19[_], N20[_], N21[_], N22[_]](
        appender: Appender[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22],
        zero: One[M, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22]
      ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7], F[N8], F[N9], F[N10], F[N11], F[N12], F[N13], F[N14], F[N15], F[N16], F[N17], F[
        N18
      ], F[N19], F[N20], F[N21], F[N22]]
    }
  }

}
