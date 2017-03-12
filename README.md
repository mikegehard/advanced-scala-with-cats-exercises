# Solutions for exercises in Advanced Scala with Cats

The book can be found here:
http://underscore.io/books/advanced-scala/

## Running

* Open an SBT console: `sbt console`
* Import the files you need.
* Enjoy.

For example, to play with the exercises from Chapter 1:

```
$ sbt console
scala> import advancedScala.chapter1._

```

There may be other imports that you need, especially for type class instances.

For example, from Chapter 1:

```
$ sbt console
scala> import advancedScala.chapter1._

scala> PrintSyntax.format("Hello")
<console>:15: error: could not find implicit value for parameter printable: advancedScala.chapter1.Printable[String]
       PrintSyntax.format("Hello")
scala> import advancedScala.chapter1.PrintableInstances._

scala> PrintSyntax.format("Hello")
res1: String = Hello
```

There are also main programs for each chapter that exercise the code. You can run these via `sbt run-main`.

For example:
```
$ sbt "run-main advancedScala.chapter1.ShowMain"
```
## Running in IntelliJ

1. Install IntelliJ Community Edition from https://www.jetbrains.com/idea/download/#section=mac
2. Open IntelliJ
3. Select `File -> New -> Project from existing sources...` or `Import Project`
4. Select the `build.sbt` file for this project from the file selection dialog.
5. Let IntelliJ do all of the work it needs to do.
6. Once a little stacked blue window looking icon shows up next to one of the `main` methods, you should be ready to go. You can click on this icon to run the main method.
