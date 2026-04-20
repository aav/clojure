(ns lecture)


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
{:key "value" "another_key" 123}

;
; all ops log2(N)