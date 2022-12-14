import random as rd
import math as mt
import numpy as np

# Exercice 4 - 1

# g est un générateur Z/pz* si et seulement si pour tout nombre x appartenant a [1;p-1] 
# il existe un nombre ke appartenant a [1;p-1] tel que il existe x = g^k %p

# exemple: 2 est il un générateur -> 
# 2⁰ = 1 %7
# 2¹ = 2 %7
# 2² = 4 %7
# 2⁷ = 1 %7
# Avec 3
# 3⁰ = 1 %7
# 3¹ = 3 %7
# 3³ = 6 %7
# 3⁴ = 4 %7
# 3⁵ = 5 %7
# 3⁶ = 1 %7

# Generateur car pas de 1 entre premier et dernier

def generateurP(p) :

    # p est Premier

    while True :
        nb = rd.randint(2,p-2)
        if (is_generator(nb, p)) :
            return nb
        

def is_generator(a, p) :
    acc = a
    for k in range(2, p-1) :
        acc *= a
        if acc % p == 1 :
            return False
    return True

""" print(generateurP(4999)) """

# Exercice 4 - 2


def log_discret(a,g,p) :

    # g est le générateur
    # p est le modulo
    # a est le résultat

    for k in range(0,p) :
        if pow(g,k) % p == a :
            return "La puissance est", k

print(log_discret(3,7,3))

# Exercice 4 - 3

def extended_gcd(a, b):
    if a < b:
        a, b = b, a
    u0, u1 = 1, 0
    v0, v1 = 0, 1
    while b != 0:
        q = int(a/b)
        b, a = a % b, b
        u0, u1, v0, v1 = v0, v1, u0-q*v0, u1-q*v1
    return u1

def Shanks(a,p,g) :

    # g est le générateur
    # p est le modulo
    # a est le résultat

    s = 1 + int(np.floor(mt.sqrt(p)))
    acc = 1
    baby_steps = {1 : 0}
    for k in range(1,s) :
        acc = (acc*g) % p
        baby_steps[acc] = k
    
    g_to_m = (acc * g) % p
    g_to_minus_m = extended_gcd(g_to_m,p)
    current_value = a
    i = 0

    while not current_value in baby_steps:
        i += 1
        current_value = (current_value*g_to_minus_m) % p

    return (baby_steps[current_value] +i*s ) % p

print(Shanks(123,4999,1985))
    


