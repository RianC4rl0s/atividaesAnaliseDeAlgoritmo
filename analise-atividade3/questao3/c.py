costs = input().split()#dividindo o input no espaço
price = int(costs[0])#valor 1
refund = int(costs[1])#valor 2

permutation = list(input()) #recebe a lista de W e B
length = len(permutation)
valueToPay = 0

firstIndexOfW = permutation.index('W')#pega o primeiro W
lastIndexOfB = length - permutation[::-1].index('B') - 1 #pega o ultimo B

while firstIndexOfW < lastIndexOfB: #enquanto branco tiver antes do preto
    distance = lastIndexOfB - firstIndexOfW #calc distancia
    valueToPay += min(distance * (price - refund), price)# a distancia * o preço - a devolução ou o preço puro, depende do menor

    permutation[firstIndexOfW] = 'B' #troca o W por B no indice atual
    permutation[lastIndexOfB] = 'W' #troca o B por W no indice atual

    firstIndexOfW = permutation.index('W') #calcula o proximo primeiro indice de W
    lastIndexOfB = length - permutation[::-1].index('B') - 1 #calcula o priximo ultimo indice de B

print(valueToPay) #mostra o quanto o homi ta devendo