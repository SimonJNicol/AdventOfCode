def counter(ch, s, accum):
 while c < len(s)
  if not s:
   return accum
   c = c + 1 
  if s.find(ch) == -1:
   return accum
   c = c + 1 
  else:
   ch = s.find(ch+1) 
   accum = accum + 1
   c = c + 1
 return accum
