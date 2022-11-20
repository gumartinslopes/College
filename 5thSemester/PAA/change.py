# The coin change Problem
# Given a collection of coins project an algorithm that computes the minimum quantity of coins
# that satisfies the change.


# This solution has a complexity of O(2^n)
def change_solver(m, n):
    if n > 0:
        t = [change_solver(m, n - i) for i in m]
        return 1 + min(t) 
    else: 
        return 0

def _change_solver_dynamic(m, n, memo):
    if(n <= 0):
        return 0
    elif memo[n] != None:
        return memo[n]
    else:
        best_change = float('inf')
        for coin in m:
            best_change = min(best_change, 1 + _change_solver_dynamic(m, n - coin, memo))
        memo[n] = best_change
    return best_change

def change_solver_dynamic(m, n):
    memo = [None for i in range(n + 1)]
    return _change_solver_dynamic(m, n, memo)

coins = [1,2,3]
change = 8
print('Amount of coins to pay the change calculated recursively: ', change_solver(coins, change))
print('Amount of coins to pay the change calculated with dynamic programming: ', change_solver_dynamic(coins, change))
