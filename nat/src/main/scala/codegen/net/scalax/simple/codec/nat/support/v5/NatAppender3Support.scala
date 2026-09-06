package net.scalax.simple.adt
package nat
package support
package v5

trait AppenderSupport3[HListLike, AppLike[_, _ <: HListLike] <: HListLike, HZero <: HListLike] { AppenderSupport3Self =>

  def appSupport2: AppenderSupport2[HListLike, AppLike]
  def hZero: HZero
  def fromToFunc[X1]: FromToFunc[X1, AppLike[X1, HZero]]

  final def genSimpleProduct[F[_[_]]](
    length: Int,
    toModel: HListLike => F[({ type AnyF[_] = Any })#AnyF],
    fromModel: F[({ type AnyF[_] = Any })#AnyF] => HListLike
  ): AppenderSupport4[F] = {
    val autalLen: Int = length - 1

    new AppenderSupport4[F] {

      override final def simpleRelease1: AppenderSupport1.Simple1.Release[F] = new AppenderSupport1.Simple1.Release[F] {
        override final def append[M[_], N1[_]](
          sAppender: AppenderSupport1.Simple1.Appender[M, N1],
          one: AppenderSupport1.Simple1.One[M, N1]
        ): M[F[N1]] = {
          val ctxPre                                            = AppenderSupport3Self.appSupport2
          val ctx                                               = new ctxPre.Support1Context(sAppender)
          val ap1: ctx.SupportInstance[AppLike[N1[Any], HZero]] =
            new ctx.SupportInstance[AppLike[N1[Any], HZero]](
              current = one.one[Any, AppLike[N1[Any], HZero]](
                AppenderSupport3Self.fromToFunc[N1[Any]]
              )
            )
          val ap2: ctx.SupportInstance[HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike]
          ): ctx.SupportInstance[HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            F[N1]
          ](
            simpleFunc1[N1],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

      override final def simpleRelease2: AppenderSupport1.Simple2.Release[F] = new AppenderSupport1.Simple2.Release[F] {
        override final def append[M[_, _], N1[_], N2[_]](
          sAppender: AppenderSupport1.Simple2.Appender[M, N1, N2],
          one: AppenderSupport1.Simple2.One[M, N1, N2]
        ): M[F[N1], F[N2]] = {
          val ctxPre                                                                     = AppenderSupport3Self.appSupport2
          val ctx                                                                        = new ctxPre.Support2Context(sAppender)
          val ap1: ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero]] =
            new ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero]](
              current = one.one[Any, AppLike[N1[Any], HZero], AppLike[N2[Any], HZero]](
                AppenderSupport3Self.fromToFunc[N1[Any]],
                AppenderSupport3Self.fromToFunc[N2[Any]]
              )
            )
          val ap2: ctx.SupportInstance[HListLike, HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike, HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike, HListLike]
          ): ctx.SupportInstance[HListLike, HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike, HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            HListLike,
            F[N1],
            F[N2]
          ](
            simpleFunc1[N1],
            simpleFunc1[N2],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

      override final def simpleRelease3: AppenderSupport1.Simple3.Release[F] = new AppenderSupport1.Simple3.Release[F] {
        override final def append[M[_, _, _], N1[_], N2[_], N3[_]](
          sAppender: AppenderSupport1.Simple3.Appender[M, N1, N2, N3],
          one: AppenderSupport1.Simple3.One[M, N1, N2, N3]
        ): M[F[N1], F[N2], F[N3]] = {
          val ctxPre = AppenderSupport3Self.appSupport2
          val ctx    = new ctxPre.Support3Context(sAppender)
          val ap1: ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero]] =
            new ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero]](
              current = one.one[Any, AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero]](
                AppenderSupport3Self.fromToFunc[N1[Any]],
                AppenderSupport3Self.fromToFunc[N2[Any]],
                AppenderSupport3Self.fromToFunc[N3[Any]]
              )
            )
          val ap2: ctx.SupportInstance[HListLike, HListLike, HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike, HListLike, HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike, HListLike, HListLike]
          ): ctx.SupportInstance[HListLike, HListLike, HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike, HListLike, HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            HListLike,
            HListLike,
            F[N1],
            F[N2],
            F[N3]
          ](
            simpleFunc1[N1],
            simpleFunc1[N2],
            simpleFunc1[N3],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

      override final def simpleRelease4: AppenderSupport1.Simple4.Release[F] = new AppenderSupport1.Simple4.Release[F] {
        override final def append[M[_, _, _, _], N1[_], N2[_], N3[_], N4[_]](
          sAppender: AppenderSupport1.Simple4.Appender[M, N1, N2, N3, N4],
          one: AppenderSupport1.Simple4.One[M, N1, N2, N3, N4]
        ): M[F[N1], F[N2], F[N3], F[N4]] = {
          val ctxPre = AppenderSupport3Self.appSupport2
          val ctx    = new ctxPre.Support4Context(sAppender)
          val ap1: ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[N4[Any], HZero]] =
            new ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[N4[Any], HZero]](
              current = one.one[Any, AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[N4[Any], HZero]](
                AppenderSupport3Self.fromToFunc[N1[Any]],
                AppenderSupport3Self.fromToFunc[N2[Any]],
                AppenderSupport3Self.fromToFunc[N3[Any]],
                AppenderSupport3Self.fromToFunc[N4[Any]]
              )
            )
          val ap2: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike]
          ): ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            F[N1],
            F[N2],
            F[N3],
            F[N4]
          ](
            simpleFunc1[N1],
            simpleFunc1[N2],
            simpleFunc1[N3],
            simpleFunc1[N4],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

      override final def simpleRelease5: AppenderSupport1.Simple5.Release[F] = new AppenderSupport1.Simple5.Release[F] {
        override final def append[M[_, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_]](
          sAppender: AppenderSupport1.Simple5.Appender[M, N1, N2, N3, N4, N5],
          one: AppenderSupport1.Simple5.One[M, N1, N2, N3, N4, N5]
        ): M[F[N1], F[N2], F[N3], F[N4], F[N5]] = {
          val ctxPre = AppenderSupport3Self.appSupport2
          val ctx    = new ctxPre.Support5Context(sAppender)
          val ap1: ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[
            N4[Any],
            HZero
          ], AppLike[N5[Any], HZero]] =
            new ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[
              N4[Any],
              HZero
            ], AppLike[N5[Any], HZero]](
              current =
                one.one[Any, AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[N4[Any], HZero], AppLike[N5[
                  Any
                ], HZero]](
                  AppenderSupport3Self.fromToFunc[N1[Any]],
                  AppenderSupport3Self.fromToFunc[N2[Any]],
                  AppenderSupport3Self.fromToFunc[N3[Any]],
                  AppenderSupport3Self.fromToFunc[N4[Any]],
                  AppenderSupport3Self.fromToFunc[N5[Any]]
                )
            )
          val ap2: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike]
          ): ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            F[N1],
            F[N2],
            F[N3],
            F[N4],
            F[N5]
          ](
            simpleFunc1[N1],
            simpleFunc1[N2],
            simpleFunc1[N3],
            simpleFunc1[N4],
            simpleFunc1[N5],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

      override final def simpleRelease6: AppenderSupport1.Simple6.Release[F] = new AppenderSupport1.Simple6.Release[F] {
        override final def append[M[_, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_]](
          sAppender: AppenderSupport1.Simple6.Appender[M, N1, N2, N3, N4, N5, N6],
          one: AppenderSupport1.Simple6.One[M, N1, N2, N3, N4, N5, N6]
        ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6]] = {
          val ctxPre = AppenderSupport3Self.appSupport2
          val ctx    = new ctxPre.Support6Context(sAppender)
          val ap1: ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[
            N4[Any],
            HZero
          ], AppLike[N5[Any], HZero], AppLike[N6[Any], HZero]] =
            new ctx.SupportInstance[AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[
              N4[Any],
              HZero
            ], AppLike[N5[Any], HZero], AppLike[N6[Any], HZero]](
              current =
                one.one[Any, AppLike[N1[Any], HZero], AppLike[N2[Any], HZero], AppLike[N3[Any], HZero], AppLike[N4[Any], HZero], AppLike[N5[
                  Any
                ], HZero], AppLike[N6[Any], HZero]](
                  AppenderSupport3Self.fromToFunc[N1[Any]],
                  AppenderSupport3Self.fromToFunc[N2[Any]],
                  AppenderSupport3Self.fromToFunc[N3[Any]],
                  AppenderSupport3Self.fromToFunc[N4[Any]],
                  AppenderSupport3Self.fromToFunc[N5[Any]],
                  AppenderSupport3Self.fromToFunc[N6[Any]]
                )
            )
          val ap2: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike]
          ): ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            F[N1],
            F[N2],
            F[N3],
            F[N4],
            F[N5],
            F[N6]
          ](
            simpleFunc1[N1],
            simpleFunc1[N2],
            simpleFunc1[N3],
            simpleFunc1[N4],
            simpleFunc1[N5],
            simpleFunc1[N6],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

      override final def simpleRelease7: AppenderSupport1.Simple7.Release[F] = new AppenderSupport1.Simple7.Release[F] {
        override final def append[M[_, _, _, _, _, _, _], N1[_], N2[_], N3[_], N4[_], N5[_], N6[_], N7[_]](
          sAppender: AppenderSupport1.Simple7.Appender[M, N1, N2, N3, N4, N5, N6, N7],
          one: AppenderSupport1.Simple7.One[M, N1, N2, N3, N4, N5, N6, N7]
        ): M[F[N1], F[N2], F[N3], F[N4], F[N5], F[N6], F[N7]] = {
          val ctxPre = AppenderSupport3Self.appSupport2
          val ctx    = new ctxPre.Support7Context(sAppender)
          val ap1: ctx.SupportInstance[
            AppLike[N1[Any], HZero],
            AppLike[N2[Any], HZero],
            AppLike[N3[Any], HZero],
            AppLike[N4[Any], HZero],
            AppLike[N5[Any], HZero],
            AppLike[N6[Any], HZero],
            AppLike[N7[Any], HZero]
          ] =
            new ctx.SupportInstance[
              AppLike[N1[Any], HZero],
              AppLike[N2[Any], HZero],
              AppLike[N3[Any], HZero],
              AppLike[N4[Any], HZero],
              AppLike[N5[Any], HZero],
              AppLike[N6[Any], HZero],
              AppLike[N7[Any], HZero]
            ](
              current = one.one[
                Any,
                AppLike[N1[Any], HZero],
                AppLike[N2[Any], HZero],
                AppLike[N3[Any], HZero],
                AppLike[N4[Any], HZero],
                AppLike[N5[Any], HZero],
                AppLike[N6[Any], HZero],
                AppLike[N7[Any], HZero]
              ](
                AppenderSupport3Self.fromToFunc[N1[Any]],
                AppenderSupport3Self.fromToFunc[N2[Any]],
                AppenderSupport3Self.fromToFunc[N3[Any]],
                AppenderSupport3Self.fromToFunc[N4[Any]],
                AppenderSupport3Self.fromToFunc[N5[Any]],
                AppenderSupport3Self.fromToFunc[N6[Any]],
                AppenderSupport3Self.fromToFunc[N7[Any]]
              )
            )
          val ap2: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike, HListLike] =
            ap1.asInstanceOf[ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike, HListLike]]

          @scala.annotation.tailrec
          def appendImpl1(
            len: Int,
            model: ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike, HListLike]
          ): ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike, HListLike] = {
            if (len > 0) {
              val nextModel = model
                .next[Any, Nothing, Nothing, Nothing, Nothing]
                .asInstanceOf[
                  ctx.SupportInstance[HListLike, HListLike, HListLike, HListLike, HListLike, HListLike, HListLike]
                ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              AppenderSupport3Self.appSupport2.abcGen.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              AppenderSupport3Self.appSupport2.abcGen.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(AppenderSupport3Self.appSupport2.abcGen.append[Any, HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            Any,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            HListLike,
            F[N1],
            F[N2],
            F[N3],
            F[N4],
            F[N5],
            F[N6],
            F[N7]
          ](
            simpleFunc1[N1],
            simpleFunc1[N2],
            simpleFunc1[N3],
            simpleFunc1[N4],
            simpleFunc1[N5],
            simpleFunc1[N6],
            simpleFunc1[N7],
            appendImpl1(autalLen - 1, ap2).current
          )
        }
      }

    }
  }

}
