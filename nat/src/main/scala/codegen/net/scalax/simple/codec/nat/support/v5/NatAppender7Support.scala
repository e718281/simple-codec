package net.scalax.simple.adt
package nat
package support

import net.scalax.simple.append.support.collectioncount7.typeparameter5.SimpleAppender

object NatNext1 {

  trait Support1[
    M[_ <: HLLike1],
    HLLike1,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    HCollection1 <: HLLike1
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: Nothing,
            X3 <: Nothing,
            X4 <: Nothing,
            X5 <: Nothing,
            X6 <: Nothing,
            X7 <: Nothing
          ] = M[H1]
        })#XM1,
        HLLike1,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        HCollection1,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        Nothing
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support1[
      M,
      HLLike1,
      APRHLLike1,
      APRHLLike1[T1, HCollection1]
    ]
  }

  trait Support2[
    M[_ <: HLLike1, _ <: HLLike2],
    HLLike1,
    HLLike2,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    APRHLLike2[_, _ <: HLLike2] <: HLLike2,
    HCollection1 <: HLLike1,
    HCollection2 <: HLLike2
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: HLLike2,
            X3 <: Nothing,
            X4 <: Nothing,
            X5 <: Nothing,
            X6 <: Nothing,
            X7 <: Nothing
          ] = M[H1, X2]
        })#XM1,
        HLLike1,
        HLLike2,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike2] =
            APRHLLike2[T1, H1]
        })#AppLike,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        HCollection1,
        HCollection2,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        Nothing
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support2[
      M,
      HLLike1,
      HLLike2,
      APRHLLike1,
      APRHLLike2,
      APRHLLike1[T1, HCollection1],
      APRHLLike2[T1, HCollection2]
    ]
  }

  trait Support3[
    M[_ <: HLLike1, _ <: HLLike2, _ <: HLLike3],
    HLLike1,
    HLLike2,
    HLLike3,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    APRHLLike2[_, _ <: HLLike2] <: HLLike2,
    APRHLLike3[_, _ <: HLLike3] <: HLLike3,
    HCollection1 <: HLLike1,
    HCollection2 <: HLLike2,
    HCollection3 <: HLLike3
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: HLLike2,
            X3 <: HLLike3,
            X4 <: Nothing,
            X5 <: Nothing,
            X6 <: Nothing,
            X7 <: Nothing
          ] = M[H1, X2, X3]
        })#XM1,
        HLLike1,
        HLLike2,
        HLLike3,
        Nothing,
        Nothing,
        Nothing,
        Nothing,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike2] =
            APRHLLike2[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike3] =
            APRHLLike3[T1, H1]
        })#AppLike,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        HCollection1,
        HCollection2,
        HCollection3,
        Nothing,
        Nothing,
        Nothing,
        Nothing
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support3[
      M,
      HLLike1,
      HLLike2,
      HLLike3,
      APRHLLike1,
      APRHLLike2,
      APRHLLike3,
      APRHLLike1[T1, HCollection1],
      APRHLLike2[T1, HCollection2],
      APRHLLike3[T1, HCollection3]
    ]
  }

  trait Support4[
    M[_ <: HLLike1, _ <: HLLike2, _ <: HLLike3, _ <: HLLike4],
    HLLike1,
    HLLike2,
    HLLike3,
    HLLike4,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    APRHLLike2[_, _ <: HLLike2] <: HLLike2,
    APRHLLike3[_, _ <: HLLike3] <: HLLike3,
    APRHLLike4[_, _ <: HLLike4] <: HLLike4,
    HCollection1 <: HLLike1,
    HCollection2 <: HLLike2,
    HCollection3 <: HLLike3,
    HCollection4 <: HLLike4
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: HLLike2,
            X3 <: HLLike3,
            X4 <: HLLike4,
            X5 <: Nothing,
            X6 <: Nothing,
            X7 <: Nothing
          ] = M[H1, X2, X3, X4]
        })#XM1,
        HLLike1,
        HLLike2,
        HLLike3,
        HLLike4,
        Nothing,
        Nothing,
        Nothing,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike2] =
            APRHLLike2[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike3] =
            APRHLLike3[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike4] =
            APRHLLike4[T1, H1]
        })#AppLike,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        Nothing,
        Nothing,
        Nothing
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support4[
      M,
      HLLike1,
      HLLike2,
      HLLike3,
      HLLike4,
      APRHLLike1,
      APRHLLike2,
      APRHLLike3,
      APRHLLike4,
      APRHLLike1[T1, HCollection1],
      APRHLLike2[T1, HCollection2],
      APRHLLike3[T1, HCollection3],
      APRHLLike4[T1, HCollection4]
    ]
  }

  trait Support5[
    M[_ <: HLLike1, _ <: HLLike2, _ <: HLLike3, _ <: HLLike4, _ <: HLLike5],
    HLLike1,
    HLLike2,
    HLLike3,
    HLLike4,
    HLLike5,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    APRHLLike2[_, _ <: HLLike2] <: HLLike2,
    APRHLLike3[_, _ <: HLLike3] <: HLLike3,
    APRHLLike4[_, _ <: HLLike4] <: HLLike4,
    APRHLLike5[_, _ <: HLLike5] <: HLLike5,
    HCollection1 <: HLLike1,
    HCollection2 <: HLLike2,
    HCollection3 <: HLLike3,
    HCollection4 <: HLLike4,
    HCollection5 <: HLLike5
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: HLLike2,
            X3 <: HLLike3,
            X4 <: HLLike4,
            X5 <: HLLike5,
            X6 <: Nothing,
            X7 <: Nothing
          ] = M[H1, X2, X3, X4, X5]
        })#XM1,
        HLLike1,
        HLLike2,
        HLLike3,
        HLLike4,
        HLLike5,
        Nothing,
        Nothing,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike2] =
            APRHLLike2[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike3] =
            APRHLLike3[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike4] =
            APRHLLike4[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike5] =
            APRHLLike5[T1, H1]
        })#AppLike,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        Nothing,
        Nothing
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support5[
      M,
      HLLike1,
      HLLike2,
      HLLike3,
      HLLike4,
      HLLike5,
      APRHLLike1,
      APRHLLike2,
      APRHLLike3,
      APRHLLike4,
      APRHLLike5,
      APRHLLike1[T1, HCollection1],
      APRHLLike2[T1, HCollection2],
      APRHLLike3[T1, HCollection3],
      APRHLLike4[T1, HCollection4],
      APRHLLike5[T1, HCollection5]
    ]
  }

  trait Support6[
    M[_ <: HLLike1, _ <: HLLike2, _ <: HLLike3, _ <: HLLike4, _ <: HLLike5, _ <: HLLike6],
    HLLike1,
    HLLike2,
    HLLike3,
    HLLike4,
    HLLike5,
    HLLike6,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    APRHLLike2[_, _ <: HLLike2] <: HLLike2,
    APRHLLike3[_, _ <: HLLike3] <: HLLike3,
    APRHLLike4[_, _ <: HLLike4] <: HLLike4,
    APRHLLike5[_, _ <: HLLike5] <: HLLike5,
    APRHLLike6[_, _ <: HLLike6] <: HLLike6,
    HCollection1 <: HLLike1,
    HCollection2 <: HLLike2,
    HCollection3 <: HLLike3,
    HCollection4 <: HLLike4,
    HCollection5 <: HLLike5,
    HCollection6 <: HLLike6
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: HLLike2,
            X3 <: HLLike3,
            X4 <: HLLike4,
            X5 <: HLLike5,
            X6 <: HLLike6,
            X7 <: Nothing
          ] = M[H1, X2, X3, X4, X5, X6]
        })#XM1,
        HLLike1,
        HLLike2,
        HLLike3,
        HLLike4,
        HLLike5,
        HLLike6,
        Nothing,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike2] =
            APRHLLike2[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike3] =
            APRHLLike3[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike4] =
            APRHLLike4[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike5] =
            APRHLLike5[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike6] =
            APRHLLike6[T1, H1]
        })#AppLike,
        net.scalax.simple.adt.nat.support.CodegenHelper.AppendNothing,
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        Nothing
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support6[
      M,
      HLLike1,
      HLLike2,
      HLLike3,
      HLLike4,
      HLLike5,
      HLLike6,
      APRHLLike1,
      APRHLLike2,
      APRHLLike3,
      APRHLLike4,
      APRHLLike5,
      APRHLLike6,
      APRHLLike1[T1, HCollection1],
      APRHLLike2[T1, HCollection2],
      APRHLLike3[T1, HCollection3],
      APRHLLike4[T1, HCollection4],
      APRHLLike5[T1, HCollection5],
      APRHLLike6[T1, HCollection6]
    ]
  }

  trait Support7[
    M[_ <: HLLike1, _ <: HLLike2, _ <: HLLike3, _ <: HLLike4, _ <: HLLike5, _ <: HLLike6, _ <: HLLike7],
    HLLike1,
    HLLike2,
    HLLike3,
    HLLike4,
    HLLike5,
    HLLike6,
    HLLike7,
    APRHLLike1[_, _ <: HLLike1] <: HLLike1,
    APRHLLike2[_, _ <: HLLike2] <: HLLike2,
    APRHLLike3[_, _ <: HLLike3] <: HLLike3,
    APRHLLike4[_, _ <: HLLike4] <: HLLike4,
    APRHLLike5[_, _ <: HLLike5] <: HLLike5,
    APRHLLike6[_, _ <: HLLike6] <: HLLike6,
    APRHLLike7[_, _ <: HLLike7] <: HLLike7,
    HCollection1 <: HLLike1,
    HCollection2 <: HLLike2,
    HCollection3 <: HLLike3,
    HCollection4 <: HLLike4,
    HCollection5 <: HLLike5,
    HCollection6 <: HLLike6,
    HCollection7 <: HLLike7
  ] extends SimpleAppender[
        ({
          type XM1[
            H1 <: HLLike1,
            X2 <: HLLike2,
            X3 <: HLLike3,
            X4 <: HLLike4,
            X5 <: HLLike5,
            X6 <: HLLike6,
            X7 <: HLLike7
          ] = M[H1, X2, X3, X4, X5, X6, X7]
        })#XM1,
        HLLike1,
        HLLike2,
        HLLike3,
        HLLike4,
        HLLike5,
        HLLike6,
        HLLike7,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike1] =
            APRHLLike1[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike2] =
            APRHLLike2[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike3] =
            APRHLLike3[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike4] =
            APRHLLike4[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike5] =
            APRHLLike5[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike6] =
            APRHLLike6[T1, H1]
        })#AppLike,
        ({
          type AppLike[T1, T2, T3, T4, T5, H1 <: HLLike7] =
            APRHLLike7[T1, H1]
        })#AppLike,
        HCollection1,
        HCollection2,
        HCollection3,
        HCollection4,
        HCollection5,
        HCollection6,
        HCollection7
      ] {
    override def next[T1, T2, T3, T4, T5]: NatNext1.Support7[
      M,
      HLLike1,
      HLLike2,
      HLLike3,
      HLLike4,
      HLLike5,
      HLLike6,
      HLLike7,
      APRHLLike1,
      APRHLLike2,
      APRHLLike3,
      APRHLLike4,
      APRHLLike5,
      APRHLLike6,
      APRHLLike7,
      APRHLLike1[T1, HCollection1],
      APRHLLike2[T1, HCollection2],
      APRHLLike3[T1, HCollection3],
      APRHLLike4[T1, HCollection4],
      APRHLLike5[T1, HCollection5],
      APRHLLike6[T1, HCollection6],
      APRHLLike7[T1, HCollection7]
    ]
  }

}
