def contar(n):
  p = 2 
  t = 1

  while p != 1:
      if p <= n/2:
          p += p
      else:
          p -= (n - p + 1)
      
      t += 1

  return t

n = int(input())
print(contar(n))