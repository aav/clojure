(ns lecture)

; Hello world, comment!

; numbers
1234
1234.56

; bool
true
false

; string
"Hello World!"

; single char (line 'c' in C-like languages)
\c

; nothing (bottom) 
nil

; keyword
:mykeyword

; symbol
'mysymbol

:asdd1234-324ddda
; my-function!


;; sequential

; vectors
[1 2 3 4]

; not homogenious
[1 "hello" :kw nil]

; not unique
[1 1 1 1 1 1 1]

; recursive
[1 [1 2 3] :kw]

; ordered
[1 2 3 4 5]

; nth O(1)
; append/remove O(n)
; conj O(1) - end

; list
'(1 2 3 4 5 6)

; not homogenious

'(1 :two "three")

; recursive
'(1 '(1 2 3) [1 2 :hello {:one "one"}])

; ordered
'(1 2 3 4 5)

; not unique
'(1 1 1 1 1)

; nth O(n)
; conj O(1) - head

; set
#{1 2 3 4 5}

; not homogenious
#{1 "hello" :kw nil}

; recursive

; unique
#{1 2 3 4}
; all ops log2(N)


;; associative
; even number of elemets
{:key "value", "another_key" 123}
; all ops log2(N)



;;; Reduction

; terminal state
; (2 + 3) * (5 + 6)
; 5       * (5 + 6)
; 5       * 11
; 55
; T
; 4       / 0


;; symbols and lists are not terminal

;;; Binding
; my-symbol <-> some-value
; a <-> 1
; a
; 1


; symbols are replaced by something they are bound to (exception if no)
; ' - quote
'hello

; list reduction

; list is reduced by applying it's first element to remaining elements (args)
; if the first element is not a function -> fail
'(+ 2 3)
'(1 2 3 4 5)

'({1 "one" 2 "two" 3 "three"} 2)

'symb
(+ 2 3 4)

; 1 + 3
; + 1 3

; 1 + 2 + 3, !flag, flag ? 1 : 3
; f(1, 2, 3, ...)
; Arity - number of parameters

; function applications only!
(+ 1 2 3 4 5 6 7 8 9 10)

; 2 + 3 * 4 
(+ 2 (* 3 4))

; var: x
; abs: λx.T
; red: T N

; var -> sumbols

; abs: 
(fn [x]
  ; T
  )


; special form

; Lisp -> Common Lisp (ANSI) -> Clojure
; 1957

+

((fn [x]
   (+ x 1)) 2)

((fn [abc]
   abc) 3)

; homoiconicity
; 123 'sss' {aa: "x"} true  JSON
; if function switch 

(let [abc 3]
  abc)

; 1:1 

((fn [abc]
   abc) 3)

((fn [a b]
   (+ a b)) 2 3)

; Curry transformation

; Partial application

((fn [a]
   (fn [b]
     (+ a b))) 2)

(fn [b]
  (+ 2 b))

(+ 2 3)

5

(((fn [a]
    (fn [b]
      (+ a b))) 2) 3)

(fn [a b]
  (+ a b))

; Haskell
; myFunction 1 2 3
; (((myFunction 1) 2) 3) 

; Higher order function

(partial + 1)

(let [my-inc (partial + 1)]
  (my-inc 4))

((fn [my-inc]
   (my-inc 4)) (partial + 1))

(fn [x]
  (fn [y]
    (+ x y)))

(fn [x]
  (fn [x]
    (+ x x)))

((fn [x]
   (fn [x]
     (+ x x))) 2)

(let [x 2]
  (let [x 3]
    (+ x x)))

(let [* +]
  (* 10 2))


;(let [* <mult>]
;  (let [+ <plus>]))

(def PI 3.14)

(def my-inc
  (fn [x]
    (+ x 1)))

(defn my-inc' [x]
  (+ x 1))

(my-inc' 3)
(my-inc 2)

(let [my-inc'' (fn [x] (+ x 1))]
  (my-inc'' 4))

;(fn2 3)

; dynamic
(def ^:dynamic *X* 0)

(defn fn1 []
  (inc *X*))

(defn fn2 [x]
  (binding [*X* x]
    (fn1)))

(fn2 3)

; thread local variables

; xx = 10
(def xx 10)

; xx = 11
(def xx 11)

(defn add-3 [a b c]
  (+ a b c))

(add-3 1 2 3)

(let [a 1
      b 2
      c 3
      c (+ a b)]
  (+ a b c))


; conditionals
true
false

(if false 1 2)
; cond ? 1 : 2

(if false "Yes" nil)
(if "No" 1 2)
(if nil 1 2)


; FALSE: false, nil
; TRUE: anything else

(if-not true 1 2)

(if true
  (do
    (println "Yes")
    "Yes"))

(when true
  (println "Yes")
  "Yes")

; (when-not)

; if, if-not, when, when-not
(defn f [n]
  (cond
    (even? n) "Even"
    (odd? n) "Odd"
    :else "Else"))

(defn f [n]
  (case n
    1 "One"
    2 "Two"
    3 "Three"
    "Unknown"))

; FizzBuzz problem with cond

;; Lecture 5



;(if <cond> <true-b> <false-b>)


(if (= 2 3) (+ 4 5) (* 6 7))
(if false (+ 4 5) (* 6 7))
(if false 9 (* 6 7))
(if false 9 42)
42


; Lazy evaluation

;; lazy
; a = 4 + 5
; if (false) {
;   b = a + a
; }

; false ? f1() : f2()
; f(f1(), f2())

(def d
  (delay
    (+ 2 3)))

(deref d)

(let [a (delay (+ 2 3))
      b (delay (* 4 6))]
  (deref (if false a b)))

(let [a (memoize (fn [] (+ 2 3)))
      b (memoize (fn [] (* 4 6)))]
  ((if false a b)))

(let [f
      (fn []
        (Thread/sleep 5000)
        (+ 2 3))]
  (* (f) (f)))


;; Destructuring (binding)

; 4
; "abc"

[1 2 3]
'(1 2 3)
{1 "one" 2 "two"}


(let [[a b c] [1 2 3]]
  [a c])

((fn [[a b c]]
   [a c]) [1 2 3])


(defn my-fn [[a b c]]
  a)

(my-fn [1 2 3])

(let [[a [b1 b2 & b-rest :as b] & others :as complete] [1 [11 12 13 14] 3 4 5 6]]
  [b a b1 b2 b-rest others complete])


(let [{:keys [phone lname] [fname _] :fname  :as complete :or {phone "Unknown"}} {:fname ["Alexey" "Walter"] :lname "Aristov" :age 51 :phone "12345"}]
  [fname phone lname])



; core.match 






























































































































































































