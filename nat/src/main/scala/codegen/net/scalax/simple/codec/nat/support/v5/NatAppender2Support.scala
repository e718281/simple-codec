package net.scalax.simple.adt
package nat
package support
package v5

trait AppenderSupport2[HListLike, AppendLike[_, _ <: HListLike] <: HListLike] { AppenderSupport2Self =>

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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
        AppendLike[T1[XPoint], HCollection1]
      ] = new SupportInstance[
        AppendLike[T1[XPoint], HCollection1]
      ](current =
        simpleAppender.append(
          AppenderSupport2Self.abcGen.toABCFunc[T1[XPoint], HCollection1],
          SupportSelf.current
        )
      )
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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
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
      override def next[XPoint, X1, X2, X3, X4]: SupportInstance[
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

}
