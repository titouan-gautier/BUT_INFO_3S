import math
import matplotlib.pyplot as plt
import numpy as np

def exo36_1() :

    x = np.array([1,3,5,7,10,13])
    y = np.array([3,2,0,1,-4,6])

    plt.plot(x,y)
    plt.show()

""" exo36_1() """


def f(x) :
    return x**(2) * math.sin(x) + 4

def g(x) :
    return 30 / (x**(2) + 1)

def exo36_2() :

    x = np.linspace(0,3*math.pi,100)

    tab1 = []
    tab2 = []

    for i in x :
        tab1.append(f(i))
        tab2.append(g(i))

    plt.plot(tab1)
    plt.plot(tab2)
    plt.show()
    
exo36_2()


