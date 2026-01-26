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


;; LECTURE 6

(let [a 1]
  (let [b 2 a 2]
    (+ a b))
  a)

(let [+ *]
  (+ 2 3))

(let [a 1]
  ;T
  a)

;(def my-pi 3.314)

; canonical way
(def my-add
  (fn [a b]
    (+ a b)))

; practical way
(defn my-add' [a b]
  (+ a b))

(defn my-func []
  (def n 1) ; VERY BAD!!!
  (let [n 1]
    ;..
    ))

;(partial + 1)
;(my-add' 2 3)

; (fn [a b c])  arity is 3


; destructuring (binding)



; 123 "hello"


[1 2 3 4]


(let [[_ _ [v31 v32 :as all-inner] :as all] [1 2 [3 4 5]]]
  [v31 v32 all all-inner])


(let [[a & rest :as all] [1 2 3 4 5 6]]
  [a rest all])

(let [[a a a] [1 2 3]]
  a)

(let [a 1]
  a)

((fn [a]
   a) 1)

((fn [[a & rest :as all]]
   [a rest all])
 [1 2 3 4 5 6])


(defn my-fn [[a & rest :as all]]
  [a rest all])

(my-fn [1 2 3 4 5 6])

;[1 2 3 4 5 6]

(let [{b :b c :c x :x :as all} {:a 1 :b 2 :c 3}]
  [b all])

(let [{:keys [b c x] :as all} {:a 1 :b 2 :c 3}]
  [b all])

(defn my-fn-1 [a b {:keys [opt1 opt2]}]
  ; 
  )

(my-fn-1 1 2 {})


(let [[a {b :b} c]  [1 {:b 2} 3]]
  [a b c])


; LECTURE 7
(= 1 2)
(= "hello" "hello")
(= [1 2 3] [1 2 3])
(=
 {:a 1 :b [1 2 3] :c "hello"}
 {:a 1 :b [1 2 3] :c "hello"})
(= #{1 2 3} #{3 2 1})

(let [a [1 2 3]
      b [1 2 3]]
  (= a b))

(not (= 2 3))
(not= 2 3)

; (= a b c)
(+ 1 2 3)

(let [a [1 1 1]]
  (apply = a))

; [1 2 3 4 5 6 7]

(let [l1 '(1 2 3)
      l2 (conj l1 0)]
  (let [l3 (rest l1)]
    [l1 l2 l3]))

(first [1 2 3])
(rest [1 2 3])

(conj [1 2 3] 4)
(conj '(1 2 3) 0)
(conj #{1 2 3} 4)

(concat [1 2] [3 4])

(assoc {:a 1} :b 2)
(dissoc {:a 1 :b 2} :a)
(merge {:a 1} {:b 2} {:c 3})

(nth [1 2 3 4] 2)

(let [a '(1 2) b '(3 4)]
  [a b (concat a b)])

(let [a [1 2 3 4 5 6 7]
      b (rest a)]
  [a b])

; conditionals 
(if true 1 2)

(if false 1)


(defn f1 []
;  (log "f1 is called")
  3)

(f1)

(defn log [_])

(if false
  (do
    (log "condition is true")
    3))

; is equal to

(when true
  (log "condition is true")
  3)

(if-not true 1 2)
(when-not true 1)

(defn zero-odd-even [n]
  (cond
    (= 0 n) "Zero"
    (odd? n) "Odd"
    :else "Even"))

(zero-odd-even 2)

(defn as-string [n]
  (case n
    0 "Zero"
    1 "One"
    2 "Two"
    nil))



; my if-not, my-when, my-when-not, my-cond, my-case

(as-string 3)



; LECTURE 8

; create seq
(seq [1 2 3])
(seq '(1 2 3))
(seq #{1 2 3})
(seq {:a 1 :b 2 :c 3})

(seq [])
(seq {})

(def abc [1 2 3])

(if (seq abc)
  "not empty" "empty")

; transform seq
(let [in [1 2 3 4 5]]
  (map inc in))

(let [in [1 2 3 4 5 6 7 8]]
  (filter even? in))

(let [in1 [1 2 3 4]
      in2 [5 6 7 8]]
  (concat in1 in2))

; consume seq
(into '(0) (filter even? [1 2 3 4 5 6 7]))

; fold / reduce
; ((((1 + 2) + 3) + 4) + 5) + 6 + 7 

(reduce + [1 2 3 4 5 6])
(reduce * [1 2 3 4 5 6])


; (range)
(take 10 (range))

(type
 (take 200
       (filter even?
               (range))))



(count [1 2 3 4 5])


(defn my-count [s]
  (if (empty? s)
    0
    (inc (my-count (rest s)))))


(defn my-count-tco [s n]
  (if (empty? s)
    n
    (recur (rest s) (inc n))))


(defn my-count-tco-rp [s]
  (loop [s s n 0]
    (if (empty? s)
      n
      (recur (rest s) (inc n)))))

; my_count([], N) -> N;
; my_count([_ | T], N) -> my_count(T, N+1).

; my_count(L) -> my_count(L, 0).



; Erlang

[]






; recusrsion point
; recur -> the closest recursion point


(my-count-tco [1 2 3 4] 5)


; TCO Tail Call Optimization


(range 10)
(take 10 (range))
(my-count-tco-rp (range 10000000))

; seq N  == 1 + (seq of N-1 elements)


(defmacro my-macro [all] ; 
  (type all))

(defn my-function [all] ; all ~ 2
  (type all))

(my-macro
 (let [a 1]
   (inc a)))

(defmacro my-comment [& _])

(my-comment
 (+ 1 2))

(comment
  (+ 1 2))


; (defn xxx [args] ....)

(def xxx
  (fn [args] ....))



(list 1 2 3 4)

(defmacro my-defn [name args & body]
  (list 'def name
        (concat (list 'fn args) body)))

(my-defn aa [a b]
         (+ a b))

(let [a 1
      b 2
      c 3]
  ; T
  )

((fn [a b c] T) 1 2 3)

(aa 1 2)


(defmacro my-defn [name args & body]
  (list 'def name
        (concat (list 'fn args) body)))

(defmacro my-defn' [name args & body]
  `(def ~name
     (fn ~args
       ~@body)))



(my-defn' aa' [a b]
          (+ a b))


; regular quote
'(1 2 3 4)

; syntax quote
`(1 2 3 4)

; unquote ~
(let [a 0]
  `(1 2 3 4 5 ~a))

; splice unquote ~@
(let [a [6 7 8 9]]
  `(1 2 3 4 5 ~@a))

(+ 1 2)

(defmacro infix [[a1 op a2]]
  `(~op ~a1 ~a2))

(infix (1 + 2 + 2))


(macroexpand '(infix (1 + 2 + 2)))

(macroexpand 
  '(defn a [b x] [d e]))


(macroexpand '(let* [a 1] a))



(take 10 
      (filter even? 
              (range)))

; thread last
(->> 
 (range)
 (filter even?)
 (take 10)
 (reduce +))

; thread first
(-> 
 10 (+ 5) (* 8))


(macroexpand 
 '(->
   10 (+ 5) (* 8)))

(defmacro my-> [x & forms] 
  (loop [x x forms forms]
    (if (empty? forms)
      x
      (let [form (first forms)
            threaded `(~(first form) ~x ~@(next form))]
        (recur threaded (next forms))))))
  
(my->
 10 (+ 5) (* 8))

















































































; true values are: everything else
; false values are: false, nil






























































































































































































































































































































































; Clojure -> JVM Byte Code









; a = 10;
;
; 










