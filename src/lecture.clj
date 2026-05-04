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




























































































