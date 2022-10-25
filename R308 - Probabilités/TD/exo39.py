
import scipy.stats as sc
import matplotlib.pyplot as plt
import numpy as np

def exo39() :

    y = sc.binom.rvs(10,0.3,size=1000)

    y = np.unique(y, return_counts=True)

    x = np.arange(0,10)



    plt.bar(y[0],y[1]/1000,0.5)
    plt.vlines(x,0,sc.binom.pmf(x,n=10,p=0.3), color = 'r')
    plt.show()

   


    plt.show()

exo39()