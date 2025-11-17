(ns lecture)

; Number
; (java int)
10

; (java float)
3.14

; java.math??.BigDecimal java.lang.BigInteger
; BigInteger
10N

; BigDecimal
100.5M

; String (java.lang.String)
"Hello World"

; Character
; java: 'A'
\A
\Z

; boolean 
true
false

; NULL, null  is it a type??? :)
nil

; keyword
:helloWorld ; java?
:hello_world ; C,Rust
:hello-world! ; Clojure

; symbol
'hello-world

; STRUCTURAL (sequential)
; vector
[1 2 3, 4 5 6, 0 0 0]

; non-homogenious
[1 "hello" true :keyword]

; recursive
[[1 2 3] [3 4] :kw 10]
; index: get n'th element - O(1)
; append (conj): add element - O(N)
; count O(1)
; remove O(N)

'(1 2 3 4 5 6)
'(1 "hello", :k 10 another-symob)
'(1 (2 3 4) :x [1 2 3] my-symbol)
; index: O(N)
; append O(1)
; count O(N)
; remove O(1)

; Preserve order (Ordered)
; [1 2 3] != [2 3 1]
; (1 2 3) != (3 2 1)

; STRUCTURAL (associative)

; Map
{1 "One",
 2 "Two",
 3 "Three"}

{1 "One",
 "Two" 2
 :three [\t \h \r \e \e]}
; get O(log2)
; insert O(log2)
; count O(N)
; remove O(log2)
; search -> *

#{1 2 3 4 5 6 "Hello", true [1 2 3] #{5 6 7}}
#{2 1 3 4 5 6 "Hello", true [1 2 3] #{5 6 7}}

; no order
; require unique
; #{1 1 2}

; set on top of map
{"k1" true
 "k2" true}

; map on top of set
; set of k-v pairs
#{["k1" "value1"]
  ["k2" "value2"]
  ["k3" "value3"]}

; any Java class
; function

; Quote ???
'my-symbol
'(1 2 3 4)

; [write] -> compile -> run -> start over
; REPL Read -> Eval -> Print -> Loop (start over)

; literals are terminal
1234
"Hello World"
true
:keyword

; with the exception of symobl and list
'my-symbol
; a ~ 10
; my-function(a)
; my-function(10)
; function result 
; my-function('a)
; function result 

; list is a function application
(+ 2 3)

+

(+ 2 3)

(#function[+] 2 3)
5

; 2 + 3
; add(2, 3)
; no operator

; prefix
; func(a1, a2, a3....)
; (func a1, a2, a3....)

; infix
; (2 + 4) * 4

(* (+ 2 4) 4)
(+ (* 4 4) 2)

; arity
; fn x(a, b, c) ; arity is 3

; 2 + 3 ;  arity 2
; !x ; arity is 1
; c ? v1 : v2
(+ 1 2 3 4)

(if false 1 3)

({true "Yes"
  false "No"} false)

; Clojure -> Lisp

; application
(inc 2)

(fn [x]
  x)


;; ***********************

((fn [x]
   x) 1)


((fn [x]
   (+ x 1)) 1)

((fn [a]
   ((fn [add-one]
      (add-one a))
    (fn [x]
      (+ x 1)))) 5)

; ((x) -> x + 1)(1)

;function add_one(x) {
;   return x + 1                     
;}


((fn [add-one]
   ;T 
   (* (add-one 1)
      (add-one 3)))
 (fn [x] (+ 1 x)))

((fn [add-one]
   ;T 
   (* ((fn [x] (+ 1 x)) 1)
      ((fn [x] (+ 1 x)) 3)))
 (fn [x] (+ 1 x)))


(* ((fn [x] (+ 1 x)) 1)
   ((fn [x] (+ 1 x)) 3))

; 1 'abc' {x: 1, y: 2}
; if while function ...
;
(+ 1 2)


; homoiconicity
; clojure is homoiconic language
; code has the same form (shape) as data

(let [x 1]
  (+ x 1))

; is transformed to (let is a macro)

((fn [x]
   (+ x 1)) 1)


; AT HOME: simulate reduction steps (incl. let macro)
(let [add-one
      (fn [x] (+ x 1))]
  (* (add-one 1)
     (add-one 3)))


(let
 [my-add
  (fn [x]
    (fn [y]
      (+ x y)))]
  (my-add 1))

(let
 [my-add
  (fn [x]
    (fn [y]
      (+ x y)))]
  ((my-add 1) 3))

(let
 [my-add
  (fn [x y]
    (+ x y))]
  (+ 1 3))

((partial + 3) 4)

(let [add-one (partial + 1)]
  (add-one 1))

; higher order function
; partial function application
; Curry transformation

(apply + [1 2 3])
(apply + [1 2 3])































































































































































































































; Clojure -> JVM Byte Code









; a = 10;
;
; 










