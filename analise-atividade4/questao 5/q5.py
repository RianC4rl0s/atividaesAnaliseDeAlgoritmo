alphabet = ['N', 'O', 'P']

def generate(n, genoma = 'N'):
    length = len(genoma)

    last = genoma[length - 1]   
    options = [n for n in alphabet if n != last]
    
    if n == 0:
        return ''
    
    if length == n:
        return genoma

  
    elif length == 1 or length == 2:
        return generate(n, genoma + options[0])
  
    else:
        for i in range(len(options)):
            if compare(genoma + options[i]):
               return generate(n, genoma + options[i])
        
        
        


def compare(test):
    if len(test) % 2 != 0 and len(test) > 1:
        test = test[1:]
        
    slice = int(len(test)/2)
    if slice == 0:
        return True
        
    first_half = test[:slice]
    second_half = test[slice:]
    
    if first_half == second_half:
        return False
    
    if compare(second_half):
        return True


while True:
    n = int(input())
    print(generate(n))
    
    if n == 0:
        break
