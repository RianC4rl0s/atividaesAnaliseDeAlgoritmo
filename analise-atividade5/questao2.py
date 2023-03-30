def sum(v):
    size = len(v)
    if size == 1:
        return v[0]
    
    half = int(size/2)
    a = sum(v[0:half])
    b = sum(v[half:size])

    return a + b

v = []
size = int(input("Tamanho do array: "))
for i in range(size):
    v.append(int(input(f'{i+1}: ')))

print('Soma:', sum(v))