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
