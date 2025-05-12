(ns lecture)

; ~1930 Alonso Church - Lambda Calculus (lambda abstraction) (beta reduction)
; ~1950 Jim McArthy - Lisp (LISt Processing)
; ~1980 Common Lisp (ANSI)

; ~2008 Clojure - very close to common lisp
;   - functional, symbolic, not-pure (not like Haskell), dynamic typed
;   - good for: meta programming
;   - compiled -> JVM byte code, runs on JVM, Java interoperability
;   - ClojureScript 99.5% Clojure, compiles to JavaScript
; REPL
; Read Eval Print Loop 
; interactive facility 

; VS Code (Calva Extension)  ([n]vim, Emacs, Helix)
; 
; 

; Types

; String  
; java.lang.String
"Hello world"

; Integer
(class 1234)

; Float
(class 123.4)

; ___BigDecimal___ READ and UNDERSTAND
(class 123.4M)

; BigInteger
(class 123N)

; Rational
(class 2/3)

; Character
; char 'a'
\a

; logical (boolean)
true
false

; keyword (prolog, erlang: atom)
:hello-world
:very-long-keyword

; Symbol
'hello-world
'a.c.d/abc

; Structural

; Vector (array)
[1 2 3
 4 5 6]

; Non homogenious, recursive, ordered
[1 "hello" :kwd ["string" \a 'abcd]]
[1 1 1 1 1 1]
; O(1) - access
; O(n) - modification

; Lists
; Non homogenious, recursive, ordered
'(1 2 3 4 5) ; [1] -> [2] -> [3] -> [4] -> [5] -> 0
'(1 "hello" :kwd, '["string" \a  'abcd])
; O(N)  access
; O(1)  append
; ???O(N)  append last O(N)

; lists + vectors -> sequential

; map (dictionary, associative map, associative)
; Non homogenious, not ordered, recursive, unique (keys)
{"key1" "value1", :key2 "value2", 123 'my-symbol}
{[1 2] "Hello", [3 2] "World"}
; O(log2) access
; O(log2) change

; set
; Non homogenious, not ordered, recursive, unique (keys)
#{"key1" :key2 45 'abc-symbol #{1 2 3}}


; LECTURE #3
; for(;;) {
;      //
; }

; (3 + 4) * (9 - 3)
; 7(T)    * (9 - 3)
; 7(T)    * 6(T)
; 42(T)


; LECTURE #4

; identity
((fn [x]
   x) 1)

; reduced
; 1

; if (condition) {
;   return {a: 1, b: "xxx"}
; }
;
; let x = [0; 10]
; "hello world"
; homoiconic

; lambda
; list, first element -> symbol, [] of args (free vars), body -> T
; (fn [x] T)

; l-abstraction, b-reduction
;((fn [x] x) 1)

;(* 2 3 4)

((fn [x] (* x x)) 2)
; (* 2 2)
; 4

; (+ 2 3)
; (* 4 6)

; functions vs operators
; 2 + 3   4 * 6   add(2, 3)  mult(4, 6)
;
; (2 + 3) * 4
; binary ops  2 + 3
; unary ops  -1  !flag
; tertiary    flag ? 1 : 2

(* (+ 2 3) 4)
(* 5 4)
20
2 + 3 + 4
(+ 2 3 4)
;(f 2 3 4)
; (+ 2 4 5)


; a, b, c 

'a

;'(+ 2 3)

; binding
; connect symbol with some value

;const x = 124;
;f(x, 2, y(x, 3))

; ((fn [x]
;   f(x, 2, y(x, 3))) 124)

((fn [x]
   (* (+ x 20) x)) 124)

'x
'(+ 1 2)

'+

+

((fn [+]
   (+ 2 4)) *)


; LECTURE 5

((fn [x]
   (* x x)) 2)

((fn [square x]
   (square x))

 (fn [x]
   (* x x))
 2)

(let
 [square
  (fn [x]
    (* x x))
  x 2]
  (square x))


; add(a1 a2) ~ (+ a1 a2)

(((fn [a1]
    (fn [a2]
      (+ a1 a2))) 2) 3)

; Curry transformation
; partial function application


; higher order function

; (partial f a1 a2 a3 aN)
(let [increment (partial + 1)]
  (increment 2))

; (log! [severity category message]
;   ....
;   )
;
; (let [error! (partial log! "error" "my_module")]
;   (error! "Message 1")
;   ...
;   (error! "Message 2")
;
;  )

(let [x 1]
  ; T begin
  (+ x 1)
  ; T end
  )

; T: zzzz x zzzzz x zzzzz x 


(let [x 1]
  ; T x ~ 1
  (let [y 10]
    (+ x y) ; -> (+ 1 10)
    )
  ; x ~ 1
  )

; PLOP PLace Oriented Programming

; (def MY-CONSTANT 11) ; x <- 10

(def square
  (fn [x] 
    (* x x)))

(defn square' [x]
  (* x x))

(square' 2)

(def z 1)


((fn []
    (let [x 1]
      (def z 1))))

;z = 1


















































































































































































































































"hello world"

123




; 
;