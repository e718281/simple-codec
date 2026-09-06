package net.scalax.simple.adt
package nat
package support
package v5

object SimpleRunnerIt10Codengen { SimpleRunnerIt10Codengen =>

  def toItera[F[_[_]], T](spc: AppenderSupport4[F]): AppenderSupport4[({ type TPF[MXX[_]] = F[({ type XUU[_] = MXX[T] })#XUU] })#TPF] = {
    type TPF[MXX[_]] = F[({ type XUU[_] = MXX[T] })#XUU]
    new AppenderSupport4[TPF] {

      override def simpleRelease1: AppenderSupport1.Simple1.Release[TPF] = new AppenderSupport1.Simple1.Release[TPF] {
        override def append[M[_], N1[_]](
          sAppender: AppenderSupport1.Simple1.Appender[M, N1],
          sOne: AppenderSupport1.Simple1.One[M, N1]
        ): M[TPF[({ type NXX[_] = N1[T] })#NXX]] =
          spc.simpleRelease1.append[M, ({ type NXX[_] = N1[T] })#NXX](
            new AppenderSupport1.Simple1.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                C1
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                ma: M[B1]
              ): M[C1] = sAppender.append[
                T,
                B1,
                C1
              ](abc1, ma)
            },
            new AppenderSupport1.Simple1.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX
            ] {
              override def one[
                U1,
                B1
              ](
                func1: FromToFunc[N1[T], B1]
              ): M[B1] = sOne.one[
                T,
                B1
              ](func1)
            }
          )
      }

      override def simpleRelease2: AppenderSupport1.Simple2.Release[TPF] = new AppenderSupport1.Simple2.Release[TPF] {
        override def append[M[_, _], N1[_], N2[_]](
          sAppender: AppenderSupport1.Simple2.Appender[M, N1, N2],
          sOne: AppenderSupport1.Simple2.One[M, N1, N2]
        ): M[TPF[({ type NXX[_] = N1[T] })#NXX], TPF[({ type NXX[_] = N2[T] })#NXX]] =
          spc.simpleRelease2.append[M, ({ type NXX[_] = N1[T] })#NXX, ({ type NXX[_] = N2[T] })#NXX](
            new AppenderSupport1.Simple2.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                B2,
                C1,
                C2
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                abc2: ABCFunc[N2[T], B2, C2],
                ma: M[B1, B2]
              ): M[C1, C2] = sAppender.append[
                T,
                B1,
                B2,
                C1,
                C2
              ](abc1, abc2, ma)
            },
            new AppenderSupport1.Simple2.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX
            ] {
              override def one[
                U1,
                B1,
                B2
              ](
                func1: FromToFunc[N1[T], B1],
                func2: FromToFunc[N2[T], B2]
              ): M[B1, B2] = sOne.one[
                T,
                B1,
                B2
              ](func1, func2)
            }
          )
      }

      override def simpleRelease3: AppenderSupport1.Simple3.Release[TPF] = new AppenderSupport1.Simple3.Release[TPF] {
        override def append[M[_, _, _], N1[_], N2[_], N3[_]](
          sAppender: AppenderSupport1.Simple3.Appender[M, N1, N2, N3],
          sOne: AppenderSupport1.Simple3.One[M, N1, N2, N3]
        ): M[TPF[({ type NXX[_] = N1[T] })#NXX], TPF[({ type NXX[_] = N2[T] })#NXX], TPF[({ type NXX[_] = N3[T] })#NXX]] =
          spc.simpleRelease3.append[M, ({ type NXX[_] = N1[T] })#NXX, ({ type NXX[_] = N2[T] })#NXX, ({ type NXX[_] = N3[T] })#NXX](
            new AppenderSupport1.Simple3.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                B2,
                B3,
                C1,
                C2,
                C3
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                abc2: ABCFunc[N2[T], B2, C2],
                abc3: ABCFunc[N3[T], B3, C3],
                ma: M[B1, B2, B3]
              ): M[C1, C2, C3] = sAppender.append[
                T,
                B1,
                B2,
                B3,
                C1,
                C2,
                C3
              ](abc1, abc2, abc3, ma)
            },
            new AppenderSupport1.Simple3.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX
            ] {
              override def one[
                U1,
                B1,
                B2,
                B3
              ](
                func1: FromToFunc[N1[T], B1],
                func2: FromToFunc[N2[T], B2],
                func3: FromToFunc[N3[T], B3]
              ): M[B1, B2, B3] = sOne.one[
                T,
                B1,
                B2,
                B3
              ](func1, func2, func3)
            }
          )
      }

      override def simpleRelease4: AppenderSupport1.Simple4.Release[TPF] = new AppenderSupport1.Simple4.Release[TPF] {
        override def append[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]](
          sAppender: AppenderSupport1.Simple4.Appender[M, N1, N2, N3, N4],
          sOne: AppenderSupport1.Simple4.One[M, N1, N2, N3, N4]
        ): M[TPF[({ type NXX[_] = N1[T] })#NXX], TPF[({ type NXX[_] = N2[T] })#NXX], TPF[({ type NXX[_] = N3[T] })#NXX], TPF[
          ({ type NXX[_] = N4[T] })#NXX
        ]] =
          spc.simpleRelease4.append[
            M,
            ({ type NXX[_] = N1[T] })#NXX,
            ({ type NXX[_] = N2[T] })#NXX,
            ({ type NXX[_] = N3[T] })#NXX,
            ({ type NXX[_] = N4[T] })#NXX
          ](
            new AppenderSupport1.Simple4.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                B2,
                B3,
                B4,
                C1,
                C2,
                C3,
                C4
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                abc2: ABCFunc[N2[T], B2, C2],
                abc3: ABCFunc[N3[T], B3, C3],
                abc4: ABCFunc[N4[T], B4, C4],
                ma: M[B1, B2, B3, B4]
              ): M[C1, C2, C3, C4] = sAppender.append[
                T,
                B1,
                B2,
                B3,
                B4,
                C1,
                C2,
                C3,
                C4
              ](abc1, abc2, abc3, abc4, ma)
            },
            new AppenderSupport1.Simple4.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX
            ] {
              override def one[
                U1,
                B1,
                B2,
                B3,
                B4
              ](
                func1: FromToFunc[N1[T], B1],
                func2: FromToFunc[N2[T], B2],
                func3: FromToFunc[N3[T], B3],
                func4: FromToFunc[N4[T], B4]
              ): M[B1, B2, B3, B4] = sOne.one[
                T,
                B1,
                B2,
                B3,
                B4
              ](func1, func2, func3, func4)
            }
          )
      }

      override def simpleRelease5: AppenderSupport1.Simple5.Release[TPF] = new AppenderSupport1.Simple5.Release[TPF] {
        override def append[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]](
          sAppender: AppenderSupport1.Simple5.Appender[M, N1, N2, N3, N4, N5],
          sOne: AppenderSupport1.Simple5.One[M, N1, N2, N3, N4, N5]
        ): M[
          TPF[({ type NXX[_] = N1[T] })#NXX],
          TPF[({ type NXX[_] = N2[T] })#NXX],
          TPF[({ type NXX[_] = N3[T] })#NXX],
          TPF[({ type NXX[_] = N4[T] })#NXX],
          TPF[({ type NXX[_] = N5[T] })#NXX]
        ] =
          spc.simpleRelease5.append[
            M,
            ({ type NXX[_] = N1[T] })#NXX,
            ({ type NXX[_] = N2[T] })#NXX,
            ({ type NXX[_] = N3[T] })#NXX,
            ({ type NXX[_] = N4[T] })#NXX,
            ({ type NXX[_] = N5[T] })#NXX
          ](
            new AppenderSupport1.Simple5.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX,
              ({ type NXX[_] = N5[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                B2,
                B3,
                B4,
                B5,
                C1,
                C2,
                C3,
                C4,
                C5
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                abc2: ABCFunc[N2[T], B2, C2],
                abc3: ABCFunc[N3[T], B3, C3],
                abc4: ABCFunc[N4[T], B4, C4],
                abc5: ABCFunc[N5[T], B5, C5],
                ma: M[B1, B2, B3, B4, B5]
              ): M[C1, C2, C3, C4, C5] = sAppender.append[
                T,
                B1,
                B2,
                B3,
                B4,
                B5,
                C1,
                C2,
                C3,
                C4,
                C5
              ](abc1, abc2, abc3, abc4, abc5, ma)
            },
            new AppenderSupport1.Simple5.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX,
              ({ type NXX[_] = N5[T] })#NXX
            ] {
              override def one[
                U1,
                B1,
                B2,
                B3,
                B4,
                B5
              ](
                func1: FromToFunc[N1[T], B1],
                func2: FromToFunc[N2[T], B2],
                func3: FromToFunc[N3[T], B3],
                func4: FromToFunc[N4[T], B4],
                func5: FromToFunc[N5[T], B5]
              ): M[B1, B2, B3, B4, B5] = sOne.one[
                T,
                B1,
                B2,
                B3,
                B4,
                B5
              ](func1, func2, func3, func4, func5)
            }
          )
      }

      override def simpleRelease6: AppenderSupport1.Simple6.Release[TPF] = new AppenderSupport1.Simple6.Release[TPF] {
        override def append[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]](
          sAppender: AppenderSupport1.Simple6.Appender[M, N1, N2, N3, N4, N5, N6],
          sOne: AppenderSupport1.Simple6.One[M, N1, N2, N3, N4, N5, N6]
        ): M[
          TPF[({ type NXX[_] = N1[T] })#NXX],
          TPF[({ type NXX[_] = N2[T] })#NXX],
          TPF[({ type NXX[_] = N3[T] })#NXX],
          TPF[({ type NXX[_] = N4[T] })#NXX],
          TPF[({ type NXX[_] = N5[T] })#NXX],
          TPF[({ type NXX[_] = N6[T] })#NXX]
        ] =
          spc.simpleRelease6.append[
            M,
            ({ type NXX[_] = N1[T] })#NXX,
            ({ type NXX[_] = N2[T] })#NXX,
            ({ type NXX[_] = N3[T] })#NXX,
            ({ type NXX[_] = N4[T] })#NXX,
            ({ type NXX[_] = N5[T] })#NXX,
            ({ type NXX[_] = N6[T] })#NXX
          ](
            new AppenderSupport1.Simple6.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX,
              ({ type NXX[_] = N5[T] })#NXX,
              ({ type NXX[_] = N6[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6,
                C1,
                C2,
                C3,
                C4,
                C5,
                C6
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                abc2: ABCFunc[N2[T], B2, C2],
                abc3: ABCFunc[N3[T], B3, C3],
                abc4: ABCFunc[N4[T], B4, C4],
                abc5: ABCFunc[N5[T], B5, C5],
                abc6: ABCFunc[N6[T], B6, C6],
                ma: M[B1, B2, B3, B4, B5, B6]
              ): M[C1, C2, C3, C4, C5, C6] = sAppender.append[
                T,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6,
                C1,
                C2,
                C3,
                C4,
                C5,
                C6
              ](abc1, abc2, abc3, abc4, abc5, abc6, ma)
            },
            new AppenderSupport1.Simple6.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX,
              ({ type NXX[_] = N5[T] })#NXX,
              ({ type NXX[_] = N6[T] })#NXX
            ] {
              override def one[
                U1,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6
              ](
                func1: FromToFunc[N1[T], B1],
                func2: FromToFunc[N2[T], B2],
                func3: FromToFunc[N3[T], B3],
                func4: FromToFunc[N4[T], B4],
                func5: FromToFunc[N5[T], B5],
                func6: FromToFunc[N6[T], B6]
              ): M[B1, B2, B3, B4, B5, B6] = sOne.one[
                T,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6
              ](func1, func2, func3, func4, func5, func6)
            }
          )
      }

      override def simpleRelease7: AppenderSupport1.Simple7.Release[TPF] = new AppenderSupport1.Simple7.Release[TPF] {
        override def append[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]](
          sAppender: AppenderSupport1.Simple7.Appender[M, N1, N2, N3, N4, N5, N6, N7],
          sOne: AppenderSupport1.Simple7.One[M, N1, N2, N3, N4, N5, N6, N7]
        ): M[
          TPF[({ type NXX[_] = N1[T] })#NXX],
          TPF[({ type NXX[_] = N2[T] })#NXX],
          TPF[({ type NXX[_] = N3[T] })#NXX],
          TPF[({ type NXX[_] = N4[T] })#NXX],
          TPF[({ type NXX[_] = N5[T] })#NXX],
          TPF[({ type NXX[_] = N6[T] })#NXX],
          TPF[({ type NXX[_] = N7[T] })#NXX]
        ] =
          spc.simpleRelease7.append[
            M,
            ({ type NXX[_] = N1[T] })#NXX,
            ({ type NXX[_] = N2[T] })#NXX,
            ({ type NXX[_] = N3[T] })#NXX,
            ({ type NXX[_] = N4[T] })#NXX,
            ({ type NXX[_] = N5[T] })#NXX,
            ({ type NXX[_] = N6[T] })#NXX,
            ({ type NXX[_] = N7[T] })#NXX
          ](
            new AppenderSupport1.Simple7.Appender[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX,
              ({ type NXX[_] = N5[T] })#NXX,
              ({ type NXX[_] = N6[T] })#NXX,
              ({ type NXX[_] = N7[T] })#NXX
            ] {
              override def append[
                U1,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6,
                B7,
                C1,
                C2,
                C3,
                C4,
                C5,
                C6,
                C7
              ](
                abc1: ABCFunc[N1[T], B1, C1],
                abc2: ABCFunc[N2[T], B2, C2],
                abc3: ABCFunc[N3[T], B3, C3],
                abc4: ABCFunc[N4[T], B4, C4],
                abc5: ABCFunc[N5[T], B5, C5],
                abc6: ABCFunc[N6[T], B6, C6],
                abc7: ABCFunc[N7[T], B7, C7],
                ma: M[B1, B2, B3, B4, B5, B6, B7]
              ): M[C1, C2, C3, C4, C5, C6, C7] = sAppender.append[
                T,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6,
                B7,
                C1,
                C2,
                C3,
                C4,
                C5,
                C6,
                C7
              ](abc1, abc2, abc3, abc4, abc5, abc6, abc7, ma)
            },
            new AppenderSupport1.Simple7.One[
              M,
              ({ type NXX[_] = N1[T] })#NXX,
              ({ type NXX[_] = N2[T] })#NXX,
              ({ type NXX[_] = N3[T] })#NXX,
              ({ type NXX[_] = N4[T] })#NXX,
              ({ type NXX[_] = N5[T] })#NXX,
              ({ type NXX[_] = N6[T] })#NXX,
              ({ type NXX[_] = N7[T] })#NXX
            ] {
              override def one[
                U1,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6,
                B7
              ](
                func1: FromToFunc[N1[T], B1],
                func2: FromToFunc[N2[T], B2],
                func3: FromToFunc[N3[T], B3],
                func4: FromToFunc[N4[T], B4],
                func5: FromToFunc[N5[T], B5],
                func6: FromToFunc[N6[T], B6],
                func7: FromToFunc[N7[T], B7]
              ): M[B1, B2, B3, B4, B5, B6, B7] = sOne.one[
                T,
                B1,
                B2,
                B3,
                B4,
                B5,
                B6,
                B7
              ](func1, func2, func3, func4, func5, func6, func7)
            }
          )
      }

    }
  }

}
