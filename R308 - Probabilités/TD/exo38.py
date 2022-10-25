import math
from random import randint
import scipy
def tirage() :

    data = ['B','B','B','B','B','B','B','N','N','N']
    tirer = []
    total = 0
    tot2Blanches = 0
    totAuMoins1B = 0

    for j in range(1000000) :
        for i in range(4) :
            tirer.append(data[randint(0,9)])

        tot2Blanches += deuxBlanches(tirer)
        totAuMoins1B += auMoins1Blanches(tirer)
        
        tirer = []
        total +=1

    f2Blanches = "Fréquences 2 boules blanches :" ,tot2Blanches / total
    f1Blanches = "Fréquences au moins 1 boules blanches :", totAuMoins1B / total
    

    return f2Blanches, f1Blanches

def deuxBlanches(tirer) :

    n = 0

    for i in tirer :
        if i == 'B' :
            n+=1
    
    if n == 2 :
        return 1
    else :
        return 0

def auMoins1Blanches(tirer) :

    n = 0

    for i in tirer :
        if i == 'B' :
            n+=1
    
    if n >= 1 :
        return 1
    else :
        return 0


print(tirage())
