
; https://github.com/jamesread/advent-of-code-2019-lisp/blob/master/day1.1/main.lisp
; syntax was grabbed from this repository, and a series of youtube videos from O'Reilly,
; part 2 (of the video series, not problem) can be found here https://www.youtube.com/watch?v=jvnwXHsL8eo
(defvar currentMass 0)
(defvar additionalFuel 0)
(defun calcFuel2 (mass)
    (setf currentMass mass)
    (loop while (>= currentMass 0) ;I tried to figure this out recursively, but ran into some LISP syntax issues and couldn't figure it out.
        do
        (incf additionalFuel currentMass)
        (setf currentMass (- (floor (/ currentMass 3)) 2))
                )
    (return-from calcFuel2 additionalFuel))
(defun calcFuel (mass)
    (- (floor (/ mass 3)) 2))
; Definition of floor function from google: Simplified Common Lisp reference - floor. FLOOR function returns two values, the first is result of dividing number by divisor and truncating toward negative infinity. Second result remainder that satisfies equation: quotient * divisor + remainder = number.
; In this case, floor truncates our return from mass/3

(with-open-file (in "input.txt") ;from the github link at the top
    (loop for line = (read-line in nil) while line do 
        (calcFuel2 (parse-integer line)))) ;incf is the same as +=

(format t "Part 2, fuel required: ~a~%" additionalFuel)