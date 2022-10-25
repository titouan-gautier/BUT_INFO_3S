from locale import ABDAY_1
import math
import matplotlib.pyplot as plt
import numpy as np

#1
""" 
P(1) = A(3-1)**2
     = A4
P(2) = A(3-2)**2
     = A*1
P(3) = A(3-3)**2
     = 0
P(4) = A(3-4)**2
     = A1 
P(5) = A(3-5)**2
     = A4 

1 = A4 + A1 + 0 + A1 + A4
1 = A(4+1+0+1+4)
1 = A10
A = 1/10
A = 0,1
"""
def p(X) :
    return 0.1*(3-X)**2

def exo17_2() :

    x = np.linspace(1,5)
 
    plt.bar(x,p(x), width=0.04)
    plt.show()

""" exo17_2() """

# Univers image = toute valeurs que prend la variable X, donc ici  1,2,3,4,5

def exo17_4() :
    x = []
    tab = [0]
    tot = 0
    
    for i in range(1,6) :
        x.append(p(i))
        print(p(i))

    for i in x :
        tot = tot + i
        tab.append(tot)
    
    

    for i in range(6) :
        plt.plot([i,i+1],[tab[i],tab[i]])

    np.insert(tab,0,0)
    print(tab)

    plt.show()

exo17_4()
