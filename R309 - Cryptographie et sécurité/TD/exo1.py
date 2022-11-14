import math as mt
import time
import matplotlib.pyplot as plt
import numpy as np
from scipy.stats import linregress
import random as rd

# Exercice 1 - 1

def estPremier(n) :
    if n < 2 or n%2 == 0 :
        return False
    d = 3
    while d*d < n :
        if n % d == 0 :
            return False
        d += 2
    return True

""" print(estPremier(52)) """


# Exercice 1 - 2

def tabPremier(n) :
    d = 3
    tab = [2]
    while d < n :
        prime = True
        for p in tab :
            if d % p == 0 :
                prime = False
                break
            if p*p > d :
                break
        if prime :
            tab.append(d)
        d += 1
    return len(tab)

""" print(tabPremier(53)) """

def q12() :
    xs = range(10,10000,10)
    ys1 = [tabPremier(n)/n for n in xs]
    ys2 = [1/(np.log(n)-1) for n in xs]
    plt.scatter(xs,ys1)
    plt.plot(xs,ys2)
    plt.show()

""" q12() """

# Exercice 1 - 3


# Exercice 1 - 4a

def tabTestPremier(list) :

    tab = []
    
    for i in list :
        t1 = time.process_time()
        res = estPremier(i)
        t2 = time.process_time()
        tab.append(t2-t1)
    
    return tab

list_nb_a_tester=[13,1009,10007,100003,1000003,10000019,100000007,1000000007,10000000019,100000000003,1000000000039,100000000000031]
print(tabTestPremier(list_nb_a_tester))

# Exercice 1 - 4b

def graphTestPremier(list) :
    decimal = [1+np.floor(np.log10(x)) for x in list]
    time = tabTestPremier(list)
    plt.scatter(decimal,time)
    plt.show()

""" graphTestPremier(list_nb_a_tester) """

# Exercice 1 - 4c

def graphTestPremierLog(list) :
    decimal = [1+np.floor(np.log10(x)) for x in list]
    time = [np.log(x) for x in tabTestPremier(list)]
    plt.scatter(decimal,time)
    plt.show()

""" graphTestPremierLog(list_nb_a_tester) """

def graphTestPremierRegLin(list) :
    decimal = [1+np.floor(np.log10(x)) for x in list]
    time = [np.log(x) for x in tabTestPremier(list)]

    reg = linregress(decimal,time)
    
    plt.scatter(decimal,time)
    plt.plot(decimal,[x*reg[0]+reg[1] for x in decimal], color='red')
    plt.show()

graphTestPremierRegLin(list_nb_a_tester)


