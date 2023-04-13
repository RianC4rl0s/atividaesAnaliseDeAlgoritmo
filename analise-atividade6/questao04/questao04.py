n, t = map(int, input().split())

# cria uma lista de tuplas com comprimentos e valores de venda dos tubos
tubos = []
for i in range(n):
    c, v = map(int, input().split())
    tubos.append((c, v))

# cria uma tabela de programação dinâmica de tamanho (n+1)x(t+1)
dp = [[0 for j in range(t+1)] for i in range(n+1)]

# preenche a tabela
for i in range(1, n+1):
    for j in range(1, t+1):
        # opção 1: não cortar o tubo i
        dp[i][j] = dp[i-1][j]

        # opção 2: cortar o tubo i em pedaços e adicionar o valor correspondente
        c, v = tubos[i-1]
        if j >= c:
            dp[i][j] = max(dp[i][j], dp[i][j-c] + v)

# o resultado é a célula dp[n][t]
print(dp[n][t])