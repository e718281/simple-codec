package net.scalax.simple.adt.codegen

import java.nio.file.Paths

object CodegenAction {
  def main(arr: Array[String]): Unit = {
    val pathImpl = Paths.get("").toAbsolutePath
    val pathRoot = os.Path(pathImpl) / "nat" / "src" / "main" / "scala" / "codegen" / "net" / "scalax" / "simple" / "codec"

    val natRoot = pathRoot / "nat" / "support"
    val v5Root  = natRoot / "v5"

    os.write.over(target = v5Root / "NatAppender1Support.scala", data = net.scalax.txt.NatAppender1Support(22).body, createFolders = true)
    os.write.over(target = v5Root / "NatAppender4Support.scala", data = net.scalax.txt.NatAppender4Support(22).body, createFolders = true)
    os.write.over(target = v5Root / "NatAppender3Support.scala", data = net.scalax.txt.NatAppender3Support(22).body, createFolders = true)
    os.write.over(target = v5Root / "NatAppender5Support.scala", data = net.scalax.txt.NatAppender5Support(22).body, createFolders = true)
  }
}
