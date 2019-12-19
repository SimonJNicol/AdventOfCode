(defvar count 0)
(defun is-triangle (a b c)
    (if 
        (> (* (+ a b c) (- (+ a b c) a) (- (+ a b c) b) (- (+ a b c) c)) 0)
        (return-from is-triangle 1)
        (return-from is-triangle 0)))


(with-open-file (in "input.txt")
    (loop for line = (read-line in nil) while line do 
        (incf count
            (is-triangle 
                (parse-integer (subseq line 2 5) :junk-allowed t) 
                (parse-integer (subseq line 7 10) :junk-allowed t) 
                (parse-integer (subseq line 12 15) :junk-allowed t)))))

(format t "Number of triangles for part 1: ~a~%" count)