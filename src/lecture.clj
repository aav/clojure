(ns lecture
  (:require [clojure.core.match :refer [match]]))


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


; not good!
((fn []
   (let [x 1]
     (def z 1))))

;z = 1

;; LECTURE 6

; Java
; String s1 = new String("s");
; String s2 = new String("s")
;
; (s1 == s2) => false ; compare identity
; s1.equals(s2) => true ; compare values

;
; Clojure
; has no identity equivalence
; 
; just value equivalance


(= 1 1 1)

(= "hello" "hello") ; -> s1.equals(s2)

(let [a 1 b 1]
  (= a b))

(= [1 2] [1 2])

(= [2 1 #{1 2}] [2 1 #{2 1}])

(not (= 1 2)) ; !(1 == 2) 1 != 2

(not= 1 2)

{#{1 2} 2, #{2 1 3} 4}

;; Destructuring (binding)

(let [[_ _ v3] [1 2 3]]
  v3)


(let [v [1 [4 5] 3]]
  (let [[_ [_ v22]] v]
    [v v22]))

(let [[_ [_ v22 :as v-inner] :as v] [1 '(4 5) 3]]
  [v v-inner v22])

((fn [[_ [_ v22 :as v-inner] :as v]]
   [v v-inner v22]) [1 '(4 5) 3])

(defn my-function [[_ x]]
  (* x x))

(my-function [1 2])

(let [{[_ x :as q] :k :as all} {:k [3 4] :v 3}]
  [x all q])

; tuple [k v]
(let [m {:k1 1 :k2 2 :k3 3}
      a (into '() m)]
  (= (into {} a) m))

(let [[_ a] (into [] #{1 2 3})]
  a)

(into [] "hello")
; core.match

(first [1 2 3 4])
(first '(1 2 3 4))

(rest [1 2 3 4])
(rest '(1 2 3 4))

(let [s (first (rest [1 2 3 4]))]
  s)

(let [[_ s] [1 2 3 4]]
  s)

(nth [1 2 3 4] 2)   ; index O(1)
(nth '(1 2 3 4) 2)  ; index O(n)

(take 3 [1 2 3 4 5 6 7])
(take 3 '(1 2 3 4 5 6 7))

(get {:k1 1 :k2 2 :k3 3} :k2)

({:k1 1 :k2 2 :k3 3} :k2)

(let [nums {:k1 1 :k2 2 :k3 3}]
  (nums :k4 "default"))

; y = f(x)   table x -> y


;; LECTURE 7

; sequences / lazy sequences / lazyness 

; sequence

; interface MyIterator {
;     Object next();
; }

(seq [1 2 3])

; seq -> seq
(take 3 [1 2 3 4 5 6])

; seq -> value
(first [1 2 3])

; value -> seq
[1 2 3 4]

; 10 -> .....
(class (range))

(= (take 10 (range)) (range 10))

(take 5 (take 10 (range)))

; seq -> seq
(map (partial + 1) [1 2 3 4 5])

(println "hello")

(defn slow-inc [x]
  (Thread/sleep 1000)
  (inc x))

(slow-inc 1)

; (time (take 10 (map slow-inc (range))))

; seq -> value
(into [0 0 0 0] (take 5 (range)))

(into []
      (take 10
            (map inc
                 (map (partial * 10) (range)))))


(map (partial + 1000)
     (take 10
           (map (partial * 3)
                (filter odd?
                        (range)))))

(->> (range)
     (filter odd?)
     (map (partial * 3))
     (map (partial + 1000))
     (map (fn [n] (- n 1)))
     (take 10))


; acc = vector();
; counter = 0;
; for(n=1; n<MAX_INT && counter < 10; n++) {
;   if is_odd(n) {
;      n*3+1000
;      counter++;
;      acc.insert(n)
;   } 
; }



;; LECTURE 8

(conj '(1 2) 0)
(conj [1 2] 3)

(let [a '(1 2)]
  (let [b (conj a 0)]
    a))

(assoc {:a 1 :b 2} :c 3)

(let [a {:a 1 :b 2}]
  (let [b (assoc a :c 3)]
    (let [c (dissoc b :a)]
      [a b c])))



;; LECTURE 9
; if 

; arity 2 or 3
(if false (+ 3 4) (- 6 2))

(if nil "Troothy" "Falsey")
; falsey: false nil
; troothy: all the rest

;(when <cond> 
;  <troothy branch>)

(let [a 2]
  (if-not (not (= a 1))
    (println "Log" a)
    "Yes"))

; = not=  -> == !=

(let [a 1]
  (when-not (= a 2)
    (println "Log" a)
    "Yes"))


(defn my-not [a]
  (if a false true))


; if, [if-not, when, when-not]
; case, cond

(defn n-str [n]
  (case n
    1 "One"
    2 "Two"
    3 "Three"
    "Unknown"))

(defn my-fn [n]
  (cond
    (nil? n) "Nil!"
    (even? n) "Even"
    (odd? n) "Odd"
    :else "Default"))
; condp

(my-fn nil)
(n-str 2)

; if when
; special form

; (<fn> a1 a2 aN)
; (if ...)
; (fn ...)
; (def ..)
; (do )

; (if <cond> <t-branch> [f-branch])

; if(<cond>) {
;  <required>
; }[else {
; 
; }]

; let x;
; = if c x = 1 else x = 2;

; x = c ? 1 : 2;

; + ; arity 2
; ~ ; arity 1
; ? ; arity 3

(map inc (range 10))

; for while, repeat until loop goto
; recursion 


(count [1 2 3])

(defn my-count [s]
  (if (empty? s)
    0
    (+ (my-count (rest s)) 1)))

; 

; LECTURE 10

(defn my-count' [s c]
  (if (empty? s)
    c
    (recur (rest s) (+ c 1))))


(defn my-count'' [input]
  (loop [s input c 0]
    (if (empty? s)
      c
      (recur (rest s) (+ c 1)))))

; recursion point

(my-count [1 2 3 4])
(my-count'' (range 10000000))

(my-count' [1 2 3] 0)

; list = [1 2 3 4]
; but_one(list)
; but_one([1 2 3 4]) -> [2 3 4]
; length([]) = 0;
; length(l) = length(but_one(list)) + 1;
; homoiconic

(take 10
      (map (fn [x] (* 3 x))
           (filter even?
                   (range))))

; -> thread first
; ->> thread last


(let [x 10]
  x)

((fn [x] x) 10)


(->>
 (range)
 (filter even?)
 (map (fn [x] (* 3 x)))
 (take 10))

(->>
 (filter even? (range))
 (map (fn [x] (* 3 x)))
 (take 10))

(->>
 (map (fn [x] (* 3 x)) (filter even? (range)))
 (take 10))

(->>
 (take 10 (map (fn [x] (* 3 x)) (filter even? (range)))))

(take 10
      (map (fn [x] (* 3 x))
           (filter even?
                   (range))))

(let [x 2]
  '(println 1 x 3))

(let [x [2 [3 4] 5]]
  `(println 1 ~x 3))

; ` - back quote
; ~ - unquote
; ~@ - splice unquote


(take 10
      (map (fn [x] (* 3 x))
           (filter even?
                   (range))))


(->> (range)
     (filter even?)
     (map (fn [x] (* 3 x)))
     (take 10))

(defn ->>fn [x & forms]
  (loop [x x forms forms]
    (if-not (empty? forms)
      (let
       [form (first forms)

        threaded
        `(~(first form) ~@(rest form) ~x)]
        
        (recur threaded (rest forms)))

      x)))


(->> 10)

(->> 10
     (+ 1 2 3 4)
     (* 10))

(->> (+ 1 2 3 4 10)
     (* 10))

(->> (* 10 (+ 1 2 3 4 10)))

(* 10 (+ 1 2 3 4 10))


(defmacro my->> [x & forms]
  (loop [x x forms forms]
    (if-not (empty? forms)
      (let
       [form (first forms)

        threaded
        `(~(first form) ~@(rest form) ~x)]

        (recur threaded (rest forms)))

      x)))



(->>fn 10 '(+ 1 2 3 4) '(* 11))

(->> 10 (+ 1 2 3 4) (* 11))


(->>fn
 '(range)
 '(filter even?)
 '(map (fn [x] (* 3 x)))
 '(take 10))










































































































































































































































































































"hello world"

123




; 
;