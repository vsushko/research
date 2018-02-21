;(def someList (list "Moe" "Larry" "Curly"))

;(println (count someList))

;(defstruct person :frist-name :last-name)

;(def me (struct person "Vasiliy" "Sushko"))

;(println (:first-name me))
;(println (:last-name me))

;(println (take 10 (iterate inc 1)))

;(def v [1 2 3 4 5 "string"])
;(println (v 5))

;(def m {:1 1 :abc 33 :2 "2"})
;(println (m :abc))

;(defn fibo
;  ([] (concat [1 1] (fibo 1 1)))
;  ([a b]
;   (let [n (+ a b)]
;     (lazy-seq (cons n (fibo b n))))))

;(def many-fibs (take 100000000 (fibo)))

;(println (nth many-fibs 55))

;(comment
;(load-file "scr/inspertor.clj")
;(refer  'inspector)
;(inspect-tree  {:a  1  :b  2  :c  [1  2  3  {:d  4  :e  5  :f  [6  7  8]}]})
;(inspect-table  [[1  2  3][4  5  6][7  8  9][10  11  12]])
;)

(comment
  ; определение пременной
  (def x)
  (println x)

  (def my-var 10)
  (println my-var)

  (def var1 22/7)
  (println var1)

  (def x1 22)
  (def x2 7)
  (println (/ x1 x2))

  ;(def x (/ 1.0 5.0))
  ;(def y (/ 5.0 1.0))
  ;(println (* x y))

  ;(def p (* x x x x x x x x x x))
  ;(def q (* y y y y y y y y y y))
  ;(println (* p q))
  (def x (/ 1 5))
  (def y (/ 5 1))
  (println (* x y))

  (println (/ 22.0 7))

  (println (+ 1 (/ 0.00001 1000000000000000000)))
  (println (+  1  (/  0.00001M  1000000000000000000)))

  (println (class (+  1  (/  0.00001M  1000000000000000000))))

  (println (class (* 10 10 10)))
  (println (class (* 9000 9000 9000)))

  ; форматирование вывода
  (println (format "%.10f" 1.2345))

  ; возвращает список символов
  (def my-str (concat "Hello" " World"))
  (println my-str)

  ; функция str конкатенирует список аргументов
  (def my-hello-world-string (str "Hello" " World"))
  (println my-hello-world-string)

  ; ключевое слвоо
  (println :foo)

  ; вывести строку которая конкатенирутся из аргументов и в которой
  ; что-то вычисляется
  (println "You are" (/ 979000000 60.0 60 24 365) "years old")
  (println "You are" (float (/ 979000000 60 60 24 365)) "years old")
  (println "There are" (* 60 24 365) "minutes in a year")

  ; списки
  (println ())
  (println (class ()))
  (println '(a b c))
  (println (class '(a b c)))

  ; векторы
  (println [1 2 3])
  (println [])
  (println (class [1 2 3]))

  ; получаем элемент из вектора по индексу
  (println (["hello" "world" 1 2 3] 1))

  ; множества
  (println #{})
  (println (class #{}))
  (println #{:a :b :c})

  (println (sorted-set "Mandy" "Anita" "Rich"))
  (println (hash-set "Mandy" "Anita" "Rich"))
  (println (hash-set "Rich" "Mandy" "Anita" "Rich"))

  ; карты
  (println {})
  (println (class {}))
  (println {:Ruby "Matz" :Clojure "Hickey"})

  ; достаем по ключу
  (println ({:Ruby "Matz" :Clojure "Hickey"} :Ruby))
  (println (:a {:a 1, :b 2}))

  ; сохраняем map в переменную
  (def inverntors {:Ruby "Matz" :Clojure "Hickey"})

  ; достаем значение по ключу (основной способ)
  (println (:Clojure inverntors))
  (println (:Java inverntors))

  ; достаем ключи
  (println (keys inverntors))

  ; достаем значенияpr
  (println (vals inverntors))

  ; записываем данные в переменные
  ;(import '(java.util.Scanner))
  (def scanner (java.util.Scanner. *in*))
  (def str1 (.nextLine scanner))

  (println "Line from console is: " str1)
  ; функции для работы с коллекциями

  ; количество элементов
  (println (count [22 "green" false]))
  (println (count '()))

  ; инверсирование элементов списка
  (println (reverse [2 42 72]))
  (println (reverse '(2 42 72)))

  (println (reverse "hello"))

  ; вычисляет значения из аргументов
  (println (apply + [34 23 9]))
  (println (map * [1 2 3 4] [1 2 3 4]))

  ; последовательности
  (println (seq [1 2 3]))
  (println (seq []))

  (def aseq [1 2 3])
  ; выводит первый элемент последовательности
  (println (first aseq))
  (println (first [32 23 15]))

  ; выводит любой, кроме первого
  (println (rest [32 23 15]))
  (println (class (rest [])))

  ; строит новую последовательность добавляя элемент
  (println (cons 1 [2 3 4]))

  ; следующий элемент
  (def vectors [1 2 3 4])
  (println (next (next vectors)))

  ; вставляет элемент в начало списка
  (println (conj '(10 20 30) :a))
  (println (into '(10 20 30) '(:a :b :c)))

  ; добавляет элемент в конец списка
  (println (conj [10 20 30] :a))
  (println (into '[10 20 30] [:a :b :c]))

  ; возвращает последовательность отрезка которые отличаются на шаг
  (println (range 10 20 2))

  ; список из повторяющихся элементов n раз
  (println (repeat 5 "p"))

  ; список из элементов от 1 до 10
  (println (take 10 (iterate inc 1)))

  (def natural-numbers (iterate inc 0))
  (println (take 5 natural-numbers))

  ; конкатенирует последовательности
  (println (concat [22 "green" false] [33 44]))

  ; две коллекции различных типов
  (println (concat #{22 "green" false} '(33 44)))


;flow control
(println (if (< 34 100) "yes" "no"))
(println (if 0 "Zero is true" "Zero is false"))

;(println (+ (Integer/parseInt (read-line)) (Integer/parseInt (read-line))))

(println (if (< 5000 100) "yes"))

; условие если тест не прошел
;(if-not test consequent alternative?)

(def x 10)
; вариант не совсем case с условием в clojure
(cond
  (< x 0) (println "Negative!")
  (= x 0) (println "Zero!"))

(cond
  (< x 0) (println "Negative!")
  (= x 0) (println "Zero!")
  :default (println "Positive!"))

; вариант case в clojure
(println (condp = 1
           1 "Clojure"
           2 "Ruby"
           3 "java"
           "Sorry, no match"))

; как if, только более одного условия может быть добавлено
(println (when true "do-this-first" "then-that" "finally this"))
(println (when-not true "do-this-frist" "then-that" "finally this "))
(println (when-not false "do-this-first" "then-that" "finally this"))

; запускает количество операций в последовательности, do
; возвращает результат в последнем выражении, перед этим выполняя все выражения
(println (do (println "Hello." (+ 2 2 ))))
(println (do (println "Hello.") (println "Hello again.") (+ 2 2)))

; do полезно, когда вы хотите включить последовательность действий, где
; ожидает только один результат например в ветке if
(if (odd? 3) (println "First true form") (println "Second true form will not print"))

; определение функций
; макрос defn - определяет функцию
(defn my-function
  "returns a String"                                        ; опциональный doc
  [name]                                                    ; список параметров (это один параметр)
  (str "Goodbye, " name)) ; concatenation

(println (my-function "Satish"))

; defn- функция может определятся после её первого использования
; функции определенные с defn макросом приватные и видимы только в namespace в котором они определены
(ns sqr)                                                    ; namespace здесь как-то правильно нужно определить
(defn- sq [x] (* x x))
(defn sum-of-squares [p q] (+ (sq p) (sq q)))

(println (sum-of-squares 4 5))
(println (sq 5))

(defn dating [person & who-all]
  (println person "are dating" (count who-all) "people."))

(dating "You" "1" "2" "3")

; функция без параметров и с одним параметром
(defn greet
  ([] (greet "world"))
  ([name] (str "Hello " name)))

(println (greet ))
(println (greet "asf" ))

; анонимная функция определяется через fn
(println ((fn [x] (+ x 1)) 9))

(def plus-one
  (fn [x] (+ x 1)))

(println (plus-one 9))

; # - короткая запись объявления анонимной функции
(println (#(apply str %1 %2) "Hello " "World"))

(defn convert
  [fahr]
  (float (* (- fahr 32) 5/9)))

(println (str "The temprature in Celcius = " (convert 75)))

(defn leap-year?
  [input-year]
  (or (and (= (rem input-year 4) 0) (> (rem input-year 100) 0)) (= (rem input-year 400) 0)))

(println (leap-year? 2100))

(defn divides?
  "Dowd divisor divide dividend evenly?"
  [dividend divisor]
  (zero? (rem dividend divisor)))

; clojure and java
;(import 'java.util.Random')

(import '(java.util Random Locale)
        '(java.text MessageFormat))

; create java object
(Random.)                                                   ; note .

(macroexpand '(Date.))                                      ; (new Date)

(def rnd (Random.))

; доступ к методам
(println (.nextInt rnd 10))

(macroexpand '(.toString (Date.)))
(println (.. '(1 2) getClass getProtectionDomain getCodeSource getLocation))

; установка пропертей через doto
(doto  (System/getProperties)
  (.setProperty  "name"  "Stuart")
  (.setProperty  "favoriteColor"  "blue"))

; доступ к функциям
(println (Math/PI))
(println (System/getProperty "java.home"))

; доступ к полям
(println (System/currentTimeMillis))
(println (java.util.Date. (long (.nextInt (Random.)))))
(println (-> (Random.) (.nextInt) (long) (java.util.Date.)))



; обработка исклюдчений
;(println (/ 1 0))

(try (/ 1 0)
  (catch Exception e (prn " in catch"))
  (finally (prn "in finally")))

(println (.toUpperCase "hello"))
(println (.length "hello"))

(defn parse [s]
  (try (Double/parseDouble (.trim s))
  (catch NumberFormatException e nil)))

(println (parse "22"))
(println (parse "      23.2323   "))
(println (parse "asdfas"))

(defn display [n]
  (str (Math/round (float n))))

(println (display 22.5))
(println (display 22/7))

(use 'clojure.inspector)
(println (inspect (System/getProperties)))



; diving into clojure
; меняем namespace по умолчанию
(in-ns 'notes)
; общий вид ns
; (ns name & refereces)

(use 'clojure.contrib.math)
  )

(ns notes
  (:use [clojure.contrib.math :only (gcd, sqrt)])
  (:import (java.text NumberFormat) (javax.swing JFrame JLabel)))