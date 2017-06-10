# lists
players = [29, 58, 66, 71, 87]

print(players[2])
print(players + [90, 91, 98])
print(players)

players.append(102)
print(players)
players[:2] = [0, 0]
print(players[:2])
print(players)
players[:2] = []
print(players)
players[:] = []
print(players)

# for each loops
foods = ['bacon', 'tuna', 'ham', 'beef']

for f in foods:
    print(f, end=' ')
    print(len(f))

for x in range(10):
    print('yea', end=' ')

for x in range(10, 40, 10):
    print(x, end=' ')

# function that take numbers of args
def add_numbers(*args):
    total = 0
    for a in args:
        total += a
    print(total)

add_numbers(3)
add_numbers(2378934, 23, -1239887)
add_numbers(3, 2, 4, 6, 9, 6)

#if elif else

age = 21

if age < 21:
    print('you can go to war!')
elif age >= 21:
    print('you can do all the things!')
else:
    print('your too young son!')


# test outputs
#
# 66
# [29, 58, 66, 71, 87, 90, 91, 98]
# [29, 58, 66, 71, 87]
# [29, 58, 66, 71, 87, 102]
# [0, 0]
# [0, 0, 66, 71, 87, 102]
# [66, 71, 87, 102]
# []
# bacon 5
# tuna 4
# ham 3
# beef 4
# yea yea yea yea yea yea yea yea yea yea 10 20 30 3
# 1139070
# 30
# you can do all the things!
