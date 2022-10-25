import matplotlib.pyplot as plt

def exo18_1() :
    #1 - Son Univers c'est 1,2,3,4,5,6.
    
    #2
    X = 1/6
    tabx = []
    tabY = []
    for i in range(1,7) :
        tabY.append(X)
        tabx.append(i)

    plt.bar(tabx,tabY,0.05)
    plt.show()

exo18_1()




