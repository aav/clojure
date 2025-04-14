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







































































































































"hello world"

123




; 
;