# Rod cutting problem
# Given a rod of length n inches and a table of prices for each length,
# determine the maximum revenue obtainable by cutting up the rod and selling 
# the pieces.


#n = rod length
#p = list of prices
# Solution in O(2^n)
def rod_cutting(p, n):
	# base case
	if n == 0:
		return 0
	# recursive case
	best_opt = 0
	for i in range(n):
		best_opt = max(best_opt, p[i] + rod_cutting(p, n - i - 1))
	return best_opt

# Solution in O(n^2)
def _dynamic_rod_cutting(p, n, memo):
	if n == 0:
		return 0
	elif memo[n] > 0:
		return memo[n]
	best_opt = 0
	for i in range(n):
		best_opt = max(best_opt, p[i] + _dynamic_rod_cutting(p, n - i - 1, memo))
	memo[n] = best_opt
	return best_opt
		

def dynamic_rod_cutting(p, n):
	memo = [0 for i in range(n + 1)]
	return _dynamic_rod_cutting(p, n, memo)

def bottom_up_rod_cutting(p, n):
	r = [0 for k in range(n + 1)]
	r[0] = 0
	for length in range(n + 1):
		best = 0
		for cut in range(length):
			best = max(best, p[cut] + r[length - cut - 1])
		r[length] = best
	return r[n]

prices = [1, 5, 8, 9, 10, 17, 17, 20, 24, 30]

for i in range(11):
    print(f'Best revenue in a rod of length{i}:', rod_cutting(prices, i))
print('\n\n')
for i in range(11):
    print(f'Best revenue in a rod of length{i}:', dynamic_rod_cutting(prices, i))
print('\n\n')
for i in range(11):
    print(f'Best revenue in a rod of length{i}:', bottom_up_rod_cutting(prices, i))