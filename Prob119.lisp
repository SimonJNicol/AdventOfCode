; https://github.com/jamesread/advent-of-code-2019-lisp/blob/master/day1.1/main.lisp
; syntax was grabbed from this repository, and a series of youtube videos from O'Reilly,
; part 2 can be found here https://www.youtube.com/watch?v=jvnwXHsL8eo
(defun calcFuel (mass)
    (- (floor (/ mass 3)) 2))
; Definition of floor function from google: Simplified Common Lisp reference - floor. FLOOR function returns two values, the first is result of dividing number by divisor and truncating toward negative infinity. Second result remainder that satisfies equation: quotient * divisor + remainder = number.
; In this case, floor truncates our return from mass/3
(defvar fuelRequired 0)

(with-open-file (in "input") ;from the github link at the top
    (loop for line = (read-line in nil) while line do (
        incf fuelRequired (calcFuel (parse-integer line)))))

(format t "Total fuel needed: ~a~%" fuelRequired)