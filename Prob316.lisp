(defun is-triangle (side-a side-b side-c)
    (format t "Part 1, triangles ~a~%" side-a)
    (format t "Part 1, triangles ~a~%" side-b)
    (format t "Part 1, triangles ~a~%" side-c))


(with-open-file (in "input.txt")
    (loop for line = (read-line in nil) while line do 
        (is-triangle 
            (parse-integer (subseq line 2 5) :junk-allowed t) 
            (parse-integer (subseq line 7 10) :junk-allowed t) 
            (parse-integer (subseq line 12 15) :junk-allowed t))))