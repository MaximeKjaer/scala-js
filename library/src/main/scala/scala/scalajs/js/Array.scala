/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js API               **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \    http://scala-lang.org/     **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */


/**
 * All doc-comments marked as "MDN" are by Mozilla Contributors,
 * distributed under the Creative Commons Attribution-ShareAlike license from
 * https://developer.mozilla.org/en-US/docs/Web/Reference/API
 */
package scala.scalajs.js

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 *  Arrays are list-like objects whose prototype has methods to perform
 *  traversal and mutation operations. Neither the length of a JavaScript
 *  array nor the types of its elements are fixed. Since an array's size
 *  length grow or shrink at any time, JavaScript arrays are not guaranteed
 *  to be dense. In general, these are convenient characteristics; but if
 *  these features are not desirable for your particular use, you might
 *  consider using typed arrays.
 *
 *  MDN
 *
 *  To construct a new array with uninitialized elements, use the constructor
 *  of this class. To construct a new array with specified elements, as if
 *  you used the array literal syntax in JavaScript, use the
 *  [[Array$.apply Array.apply]] method instead.
 *
 *  @tparam A Type of the elements of the array
 *
 *  @constructor Creates a new array of length 0.
 */
@js.native
@JSGlobal
class Array[A] extends js.Object with js.Iterable[A] {
  /** Creates a new array with the given length.
   *  @param arrayLength Initial length of the array.
   */
  def this(arrayLength: Int) = this()

  // Do not expose this one - use js.Array(item1, item2, ...) instead
  // def this(items: A*) = this()

  /** Length of the array. */
  def length: Int = js.native

  /** Sets the length of the array.
   *  If the new length is bigger than the old length, created slots are
   *  filled with `undefined` (irrespective of the type argument `A`!).
   *  If the new length is smaller than the old length, the array is shrunk.
   */
  def length_=(v: Int): Unit = js.native

  /** Access the element at the given index. */
  @JSBracketAccess
  def apply(index: Int): A = js.native
  /** Set the element at the given index. */
  @JSBracketAccess
  def update(index: Int, value: A): Unit = js.native

  /**
   * concat creates a new array consisting of the elements in the this object
   * on which it is called, followed in order by, for each argument, the
   * elements of that argument (if the argument is an array) or the argument
   * itself (if the argument is not an array).
   *
   * MDN
   */
  def concat[B >: A](items: js.Array[_ <: B]*): js.Array[B] = js.native

  /** <span class="badge badge-ecma6" style="float: right;">ECMAScript 6</span>
   *  JavaScript Iterator for this Array.
   */
  @JSName(js.Symbol.iterator)
  def jsIterator(): js.Iterator[A] = js.native

  /**
   * The join() method joins all elements of an array into a string.
   *
   * separator Specifies a string to separate each element of the array.
   * The separator is converted to a string if necessary. If omitted, the
   * array elements are separated with a comma.
   */
  def join(seperator: String = ","): String = js.native

  /**
   * The pop() method removes the last element from an array and returns that
   * element.
   *
   * MDN
   */
  def pop(): A = js.native

  /**
   * The push() method mutates an array by appending the given elements and
   * returning the new length of the array.
   *
   * MDN
   */
  def push(items: A*): Int = js.native

  /**
   * The reverse() method reverses an array in place. The first array element
   * becomes the last and the last becomes the first.
   *
   * MDN
   */
  @JSName("reverse")
  def reverseInPlace(): js.Array[A] = js.native

  /**
   * The shift() method removes the first element from an array and returns that
   * element. This method changes the length of the array.
   *
   * MDN
   */
  def shift(): A = js.native

  /**
   * The slice() method returns a shallow copy of a portion of an array.
   *
   * MDN
   */
  @JSName("slice")
  def jsSlice(start: Int = 0, end: Int = Int.MaxValue): js.Array[A] = js.native

  /**
   * The sort() method sorts the elements of an array in place and returns the
   * array. The sort is not necessarily stable. The default sort order is
   * lexicographic (not numeric).
   *
   * If compareFunction is not supplied, elements are sorted by converting them
   * to strings and comparing strings in lexicographic ("dictionary" or "telephone
   * book," not numerical) order. For example, "80" comes before "9" in
   * lexicographic order, but in a numeric sort 9 comes before 80.
   *
   * MDN
   */
  def sort(compareFn: js.Function2[A, A, Int] = ???): js.Array[A] = js.native

  /** Removes and adds new elements at a given index in the array.
   *
   *  This method first removes `deleteCount` elements starting from the index
   *  `index`, then inserts the new elements `items` at that index.
   *
   *  If `index` is negative, it is treated as that number of elements starting
   *  from the end of the array.
   *
   *  @param index       Index where to start changes
   *  @param deleteCount Number of elements to delete from index
   *  @param items       Elements to insert at index
   *  @return An array of the elements that were deleted
   */
  def splice(index: Int, deleteCount: Int, items: A*): js.Array[A] = js.native

  /**
   * The unshift() method adds one or more elements to the beginning of an array
   * and returns the new length of the array.
   *
   * MDN
   */
  def unshift(items: A*): Int = js.native
}

/** Factory for [[js.Array]] objects. */
object Array {
  @js.native
  @JSGlobal("Array")
  private object NativeArray extends js.Object {
    def isArray(arg: scala.Any): Boolean = js.native
  }

  /** Creates a new array with the given items. */
  def apply[A](items: A*): js.Array[A] = throw new java.lang.Error("stub")

  /** Returns true if the given value is an array. */
  @inline
  def isArray(arg: scala.Any): Boolean = NativeArray.isArray(arg)
}
