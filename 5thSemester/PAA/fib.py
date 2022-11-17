#Fibonacci Sequence
def fib(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)


def _fib_dynamic(n, memo):
    if memo[n] != None:
        return memo[n]
    elif n == 1 or n == 0:
        result = 1
    else:
        result = _fib_dynamic(n-1, memo) + _fib_dynamic(n-2, memo)
        memo[n] = result
        
    return result 


def fib_dynamic(n):
    memo = [None for _ in range(n + 1)]
    return _fib_dynamic(n, memo)


print('Fibonacci of 4: ', fib_dynamic(4))
print('Fibonacci of 5: ', fib_dynamic(5))
print('Fibonacci of 1: ', fib_dynamic(1))
print('Fibonacci of 8: ', fib_dynamic(8))
