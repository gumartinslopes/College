# The knapsack problem

# This solution has a complexity of O(2^n)
def change_solver(m, n):
    if n > 0:
        t = [change_solver(m, n - i) for i in m]
        return 1 + min(t) 
    else: 
        return 0

print(change_solver(m, n))
