(defvar count 0)
(defun is-triangle (a b c)
    (if (> (* (/ (+ a b c) 2) (- (/ (+ a b c) 2) a) (- (/ (+ a b c) 2) b) (- (/ (+ a b c) 2) c)) 0) ;https://www.afralisp.net/autolisp/tutorials/cond-vs-if.php, https://www.tutorialspoint.com/lisp/lisp_operators.htm
        (return-from is-triangle 1)
        (return-from is-triangle 0)))


(with-open-file (in "input.txt") ;https://www.tutorialspoint.com/lisp/lisp_file_io.htm
    (loop for line = (read-line in nil) while line do 
        (incf count
            (is-triangle 
                (parse-integer (subseq line 2 5) :junk-allowed t) ;http://clhs.lisp.se/Body/f_parse_.html
                (parse-integer (subseq line 7 10) :junk-allowed t) ;http://cl-cookbook.sourceforge.net/strings.html
                (parse-integer (subseq line 12 15) :junk-allowed t))))) 
                

(format t "Number of triangles for part 1: ~a~%" count) 