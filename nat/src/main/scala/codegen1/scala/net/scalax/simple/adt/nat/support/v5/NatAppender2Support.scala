package net.scalax.simple.adt
package nat
package support
package v5

trait AppenderSupport2[HListLike, AppendLike[_, _ <: HListLike] <: HListLike] {
  AppenderSupport2Self =>

  def abcGen: net.scalax.simple.adt.nat.support.HListFunc[HListLike, AppendLike]

  class Support1Context[
    M[_],
    T1[_]
  ](
    simpleAppender: AppenderSupport1.Simple1.Appender[M, T1]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike
    ](override val current: M[HCollection1])
        extends NatNext1.Support1[
          M,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          HCollection1
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1]
      ](current = simpleAppender.append(AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1], SupportSelf.current))
    }
  }

  class Support2Context[
    M[_, _],
    T1[_],
    T2[_]
  ](
    simpleAppender: AppenderSupport1.Simple2.Appender[M, T1, T2]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike
    ](override val current: M[HCollection1, HCollection2])
        extends NatNext1.Support2[
          M,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          SupportSelf.current
        )
      )
    }
  }

  class Support3Context[
    M[_, _, _],
    T1[_],
    T2[_],
    T3[_]
  ](
    simpleAppender: AppenderSupport1.Simple3.Appender[M, T1, T2, T3]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike
    ](override val current: M[HCollection1, HCollection2, HCollection3])
        extends NatNext1.Support3[
          M,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          SupportSelf.current
        )
      )
    }
  }

  class Support4Context[
    M[_, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_]
  ](
    simpleAppender: AppenderSupport1.Simple4.Appender[M, T1, T2, T3, T4]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike
    ](override val current: M[HCollection1, HCollection2, HCollection3, HCollection4])
        extends NatNext1.Support4[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          SupportSelf.current
        )
      )
    }
  }

  class Support5Context[
    M[_, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_]
  ](
    simpleAppender: AppenderSupport1.Simple5.Appender[M, T1, T2, T3, T4, T5]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike
    ](override val current: M[HCollection1, HCollection2, HCollection3, HCollection4, HCollection5])
        extends NatNext1.Support5[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          SupportSelf.current
        )
      )
    }
  }

  class Support6Context[
    M[_, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_]
  ](
    simpleAppender: AppenderSupport1.Simple6.Appender[M, T1, T2, T3, T4, T5, T6]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike
    ](override val current: M[HCollection1, HCollection2, HCollection3, HCollection4, HCollection5, HCollection6])
        extends NatNext1.Support6[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          SupportSelf.current
        )
      )
    }
  }

  class Support7Context[
    M[_, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_]
  ](
    simpleAppender: AppenderSupport1.Simple7.Appender[M, T1, T2, T3, T4, T5, T6, T7]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike
    ](override val current: M[HCollection1, HCollection2, HCollection3, HCollection4, HCollection5, HCollection6, HCollection7])
        extends NatNext1.Support7[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          SupportSelf.current
        )
      )
    }
  }

  class Support8Context[
    M[_, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_]
  ](
    simpleAppender: AppenderSupport1.Simple8.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8
      ]
    ) extends NatNext1.Support8[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          SupportSelf.current
        )
      )
    }
  }

  class Support9Context[
    M[_, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_]
  ](
    simpleAppender: AppenderSupport1.Simple9.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9
      ]
    ) extends NatNext1.Support9[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          SupportSelf.current
        )
      )
    }
  }

  class Support10Context[
    M[_, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_]
  ](
    simpleAppender: AppenderSupport1.Simple10.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10
      ]
    ) extends NatNext1.Support10[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          SupportSelf.current
        )
      )
    }
  }

  class Support11Context[
    M[_, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_]
  ](
    simpleAppender: AppenderSupport1.Simple11.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11
      ]
    ) extends NatNext1.Support11[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          SupportSelf.current
        )
      )
    }
  }

  class Support12Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_]
  ](
    simpleAppender: AppenderSupport1.Simple12.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12
      ]
    ) extends NatNext1.Support12[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          SupportSelf.current
        )
      )
    }
  }

  class Support13Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_]
  ](
    simpleAppender: AppenderSupport1.Simple13.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13
      ]
    ) extends NatNext1.Support13[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          SupportSelf.current
        )
      )
    }
  }

  class Support14Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_]
  ](
    simpleAppender: AppenderSupport1.Simple14.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14
      ]
    ) extends NatNext1.Support14[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          SupportSelf.current
        )
      )
    }
  }

  class Support15Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_]
  ](
    simpleAppender: AppenderSupport1.Simple15.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15
      ]
    ) extends NatNext1.Support15[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          SupportSelf.current
        )
      )
    }
  }

  class Support16Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_]
  ](
    simpleAppender: AppenderSupport1.Simple16.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16
      ]
    ) extends NatNext1.Support16[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          SupportSelf.current
        )
      )
    }
  }

  class Support17Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_],
    T17[_]
  ](
    simpleAppender: AppenderSupport1.Simple17.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike,
      HCollection17 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16,
        HCollection17
      ]
    ) extends NatNext1.Support17[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16,
          HCollection17
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16],
          AppendLike[T17[XPoint], HCollection17]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16],
        AppendLike[T17[XPoint], HCollection17]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          AppenderSupport2Self.abcGen.toABCFunc[T17[XPoint], HCollection17],
          SupportSelf.current
        )
      )
    }
  }

  class Support18Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_],
    T17[_],
    T18[_]
  ](
    simpleAppender: AppenderSupport1.Simple18.Appender[M, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike,
      HCollection17 <: HListLike,
      HCollection18 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16,
        HCollection17,
        HCollection18
      ]
    ) extends NatNext1.Support18[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16,
          HCollection17,
          HCollection18
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16],
          AppendLike[T17[XPoint], HCollection17],
          AppendLike[T18[XPoint], HCollection18]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16],
        AppendLike[T17[XPoint], HCollection17],
        AppendLike[T18[XPoint], HCollection18]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          AppenderSupport2Self.abcGen.toABCFunc[T17[XPoint], HCollection17],
          AppenderSupport2Self.abcGen.toABCFunc[T18[XPoint], HCollection18],
          SupportSelf.current
        )
      )
    }
  }

  class Support19Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_],
    T17[_],
    T18[_],
    T19[_]
  ](
    simpleAppender: AppenderSupport1.Simple19.Appender[
      M,
      T1,
      T2,
      T3,
      T4,
      T5,
      T6,
      T7,
      T8,
      T9,
      T10,
      T11,
      T12,
      T13,
      T14,
      T15,
      T16,
      T17,
      T18,
      T19
    ]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike,
      HCollection17 <: HListLike,
      HCollection18 <: HListLike,
      HCollection19 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16,
        HCollection17,
        HCollection18,
        HCollection19
      ]
    ) extends NatNext1.Support19[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16,
          HCollection17,
          HCollection18,
          HCollection19
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16],
          AppendLike[T17[XPoint], HCollection17],
          AppendLike[T18[XPoint], HCollection18],
          AppendLike[T19[XPoint], HCollection19]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16],
        AppendLike[T17[XPoint], HCollection17],
        AppendLike[T18[XPoint], HCollection18],
        AppendLike[T19[XPoint], HCollection19]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          AppenderSupport2Self.abcGen.toABCFunc[T17[XPoint], HCollection17],
          AppenderSupport2Self.abcGen.toABCFunc[T18[XPoint], HCollection18],
          AppenderSupport2Self.abcGen.toABCFunc[T19[XPoint], HCollection19],
          SupportSelf.current
        )
      )
    }
  }

  class Support20Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_],
    T17[_],
    T18[_],
    T19[_],
    T20[_]
  ](
    simpleAppender: AppenderSupport1.Simple20.Appender[
      M,
      T1,
      T2,
      T3,
      T4,
      T5,
      T6,
      T7,
      T8,
      T9,
      T10,
      T11,
      T12,
      T13,
      T14,
      T15,
      T16,
      T17,
      T18,
      T19,
      T20
    ]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike,
      HCollection17 <: HListLike,
      HCollection18 <: HListLike,
      HCollection19 <: HListLike,
      HCollection20 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16,
        HCollection17,
        HCollection18,
        HCollection19,
        HCollection20
      ]
    ) extends NatNext1.Support20[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16,
          HCollection17,
          HCollection18,
          HCollection19,
          HCollection20
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16],
          AppendLike[T17[XPoint], HCollection17],
          AppendLike[T18[XPoint], HCollection18],
          AppendLike[T19[XPoint], HCollection19],
          AppendLike[T20[XPoint], HCollection20]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16],
        AppendLike[T17[XPoint], HCollection17],
        AppendLike[T18[XPoint], HCollection18],
        AppendLike[T19[XPoint], HCollection19],
        AppendLike[T20[XPoint], HCollection20]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          AppenderSupport2Self.abcGen.toABCFunc[T17[XPoint], HCollection17],
          AppenderSupport2Self.abcGen.toABCFunc[T18[XPoint], HCollection18],
          AppenderSupport2Self.abcGen.toABCFunc[T19[XPoint], HCollection19],
          AppenderSupport2Self.abcGen.toABCFunc[T20[XPoint], HCollection20],
          SupportSelf.current
        )
      )
    }
  }

  class Support21Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_],
    T17[_],
    T18[_],
    T19[_],
    T20[_],
    T21[_]
  ](
    simpleAppender: AppenderSupport1.Simple21.Appender[
      M,
      T1,
      T2,
      T3,
      T4,
      T5,
      T6,
      T7,
      T8,
      T9,
      T10,
      T11,
      T12,
      T13,
      T14,
      T15,
      T16,
      T17,
      T18,
      T19,
      T20,
      T21
    ]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike,
      HCollection17 <: HListLike,
      HCollection18 <: HListLike,
      HCollection19 <: HListLike,
      HCollection20 <: HListLike,
      HCollection21 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16,
        HCollection17,
        HCollection18,
        HCollection19,
        HCollection20,
        HCollection21
      ]
    ) extends NatNext1.Support21[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16,
          HCollection17,
          HCollection18,
          HCollection19,
          HCollection20,
          HCollection21
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16],
          AppendLike[T17[XPoint], HCollection17],
          AppendLike[T18[XPoint], HCollection18],
          AppendLike[T19[XPoint], HCollection19],
          AppendLike[T20[XPoint], HCollection20],
          AppendLike[T21[XPoint], HCollection21]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16],
        AppendLike[T17[XPoint], HCollection17],
        AppendLike[T18[XPoint], HCollection18],
        AppendLike[T19[XPoint], HCollection19],
        AppendLike[T20[XPoint], HCollection20],
        AppendLike[T21[XPoint], HCollection21]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          AppenderSupport2Self.abcGen.toABCFunc[T17[XPoint], HCollection17],
          AppenderSupport2Self.abcGen.toABCFunc[T18[XPoint], HCollection18],
          AppenderSupport2Self.abcGen.toABCFunc[T19[XPoint], HCollection19],
          AppenderSupport2Self.abcGen.toABCFunc[T20[XPoint], HCollection20],
          AppenderSupport2Self.abcGen.toABCFunc[T21[XPoint], HCollection21],
          SupportSelf.current
        )
      )
    }
  }

  class Support22Context[
    M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _],
    T1[_],
    T2[_],
    T3[_],
    T4[_],
    T5[_],
    T6[_],
    T7[_],
    T8[_],
    T9[_],
    T10[_],
    T11[_],
    T12[_],
    T13[_],
    T14[_],
    T15[_],
    T16[_],
    T17[_],
    T18[_],
    T19[_],
    T20[_],
    T21[_],
    T22[_]
  ](
    simpleAppender: AppenderSupport1.Simple22.Appender[
      M,
      T1,
      T2,
      T3,
      T4,
      T5,
      T6,
      T7,
      T8,
      T9,
      T10,
      T11,
      T12,
      T13,
      T14,
      T15,
      T16,
      T17,
      T18,
      T19,
      T20,
      T21,
      T22
    ]
  ) {
    class SupportInstance[
      HCollection1 <: HListLike,
      HCollection2 <: HListLike,
      HCollection3 <: HListLike,
      HCollection4 <: HListLike,
      HCollection5 <: HListLike,
      HCollection6 <: HListLike,
      HCollection7 <: HListLike,
      HCollection8 <: HListLike,
      HCollection9 <: HListLike,
      HCollection10 <: HListLike,
      HCollection11 <: HListLike,
      HCollection12 <: HListLike,
      HCollection13 <: HListLike,
      HCollection14 <: HListLike,
      HCollection15 <: HListLike,
      HCollection16 <: HListLike,
      HCollection17 <: HListLike,
      HCollection18 <: HListLike,
      HCollection19 <: HListLike,
      HCollection20 <: HListLike,
      HCollection21 <: HListLike,
      HCollection22 <: HListLike
    ](
      override val current: M[
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7,
        HCollection8,
        HCollection9,
        HCollection10,
        HCollection11,
        HCollection12,
        HCollection13,
        HCollection14,
        HCollection15,
        HCollection16,
        HCollection17,
        HCollection18,
        HCollection19,
        HCollection20,
        HCollection21,
        HCollection22
      ]
    ) extends NatNext1.Support22[
          M,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail] })#XUAPPendEach,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T22[X12], Tail] })#XUAPPendEach,
          HCollection1,
          HCollection2,
          HCollection3,
          HCollection4,
          HCollection5,
          HCollection6,
          HCollection7,
          HCollection8,
          HCollection9,
          HCollection10,
          HCollection11,
          HCollection12,
          HCollection13,
          HCollection14,
          HCollection15,
          HCollection16,
          HCollection17,
          HCollection18,
          HCollection19,
          HCollection20,
          HCollection21,
          HCollection22
        ] {
      SupportSelf =>
      override def next[XPoint, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21]
        : SupportInstance[
          AppendLike[T1[XPoint], HCollection1],
          AppendLike[T2[XPoint], HCollection2],
          AppendLike[T3[XPoint], HCollection3],
          AppendLike[T4[XPoint], HCollection4],
          AppendLike[T5[XPoint], HCollection5],
          AppendLike[T6[XPoint], HCollection6],
          AppendLike[T7[XPoint], HCollection7],
          AppendLike[T8[XPoint], HCollection8],
          AppendLike[T9[XPoint], HCollection9],
          AppendLike[T10[XPoint], HCollection10],
          AppendLike[T11[XPoint], HCollection11],
          AppendLike[T12[XPoint], HCollection12],
          AppendLike[T13[XPoint], HCollection13],
          AppendLike[T14[XPoint], HCollection14],
          AppendLike[T15[XPoint], HCollection15],
          AppendLike[T16[XPoint], HCollection16],
          AppendLike[T17[XPoint], HCollection17],
          AppendLike[T18[XPoint], HCollection18],
          AppendLike[T19[XPoint], HCollection19],
          AppendLike[T20[XPoint], HCollection20],
          AppendLike[T21[XPoint], HCollection21],
          AppendLike[T22[XPoint], HCollection22]
        ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1],
        AppendLike[T2[XPoint], HCollection2],
        AppendLike[T3[XPoint], HCollection3],
        AppendLike[T4[XPoint], HCollection4],
        AppendLike[T5[XPoint], HCollection5],
        AppendLike[T6[XPoint], HCollection6],
        AppendLike[T7[XPoint], HCollection7],
        AppendLike[T8[XPoint], HCollection8],
        AppendLike[T9[XPoint], HCollection9],
        AppendLike[T10[XPoint], HCollection10],
        AppendLike[T11[XPoint], HCollection11],
        AppendLike[T12[XPoint], HCollection12],
        AppendLike[T13[XPoint], HCollection13],
        AppendLike[T14[XPoint], HCollection14],
        AppendLike[T15[XPoint], HCollection15],
        AppendLike[T16[XPoint], HCollection16],
        AppendLike[T17[XPoint], HCollection17],
        AppendLike[T18[XPoint], HCollection18],
        AppendLike[T19[XPoint], HCollection19],
        AppendLike[T20[XPoint], HCollection20],
        AppendLike[T21[XPoint], HCollection21],
        AppendLike[T22[XPoint], HCollection22]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          AppenderSupport2Self.abcGen.toABCFunc[T2[XPoint], HCollection2],
          AppenderSupport2Self.abcGen.toABCFunc[T3[XPoint], HCollection3],
          AppenderSupport2Self.abcGen.toABCFunc[T4[XPoint], HCollection4],
          AppenderSupport2Self.abcGen.toABCFunc[T5[XPoint], HCollection5],
          AppenderSupport2Self.abcGen.toABCFunc[T6[XPoint], HCollection6],
          AppenderSupport2Self.abcGen.toABCFunc[T7[XPoint], HCollection7],
          AppenderSupport2Self.abcGen.toABCFunc[T8[XPoint], HCollection8],
          AppenderSupport2Self.abcGen.toABCFunc[T9[XPoint], HCollection9],
          AppenderSupport2Self.abcGen.toABCFunc[T10[XPoint], HCollection10],
          AppenderSupport2Self.abcGen.toABCFunc[T11[XPoint], HCollection11],
          AppenderSupport2Self.abcGen.toABCFunc[T12[XPoint], HCollection12],
          AppenderSupport2Self.abcGen.toABCFunc[T13[XPoint], HCollection13],
          AppenderSupport2Self.abcGen.toABCFunc[T14[XPoint], HCollection14],
          AppenderSupport2Self.abcGen.toABCFunc[T15[XPoint], HCollection15],
          AppenderSupport2Self.abcGen.toABCFunc[T16[XPoint], HCollection16],
          AppenderSupport2Self.abcGen.toABCFunc[T17[XPoint], HCollection17],
          AppenderSupport2Self.abcGen.toABCFunc[T18[XPoint], HCollection18],
          AppenderSupport2Self.abcGen.toABCFunc[T19[XPoint], HCollection19],
          AppenderSupport2Self.abcGen.toABCFunc[T20[XPoint], HCollection20],
          AppenderSupport2Self.abcGen.toABCFunc[T21[XPoint], HCollection21],
          AppenderSupport2Self.abcGen.toABCFunc[T22[XPoint], HCollection22],
          SupportSelf.current
        )
      )
    }
  }

}
