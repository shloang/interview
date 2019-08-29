# Interview task
The problem:

Box factory assembles boxes out of wooden panels.
 Each panel has a rectangular form. Width and height of a panel are represented by integer numbers. factory.Factory receives an order to  produce a box of a given volume (an integer number again). Chief engineer has a catalog of available panels stored as an array of (width, height) pairs. Your job is to select the cheapest set of three panels that will produce a box of the requested volume. Price of a panel is proportional to it's area. 

For example, given a panel list 

`(2, 4), (2, 3), (1, 3), (2, 2), (3, 5), (1, 2), (3, 4), (1, 4), (2, 5)]`
and a volume `12`, you should return panels
`[(2, 2), (2, 3), (2, 3)]`

# Value representation
Panel list in this implementation is represented by an `ArrayList` of `int[2]`.
It is chosen over an array of objects to enable potential duplicate deletion
# Exceptions and no fitting triplet of panels

If invalid input is given, for example a panel with 3 dimensions, `IllegalArgumentException` will be thrown

If there is no solution with given inputs `getResult` will return an empty list
# Testing
```sh
$ gradle test
```

> Use `gradlew.bat` if you're on Windows