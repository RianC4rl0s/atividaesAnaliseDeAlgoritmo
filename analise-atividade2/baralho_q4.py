def embaralhar(baralho, n):
  embaralhado = [];

  for i in range(n):
    embaralhado.append(baralho[i + n])
    embaralhado.append(baralho[i])

  return embaralhado;

def contar(p):
  n = int(p / 2)

  baralho = list(range(1, p+1))
  print(f'original: {baralho}')

  embaralhado = embaralhar(baralho, n)
  cont = 0

  while embaralhado[0] != 1:
    embaralhado = embaralhar(baralho, n)
    cont = cont + 1
    print(f'{cont}: {embaralhado}')
    baralho = embaralhado

  return cont


print(contar(int(input())))