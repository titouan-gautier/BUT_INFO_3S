import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as sp
import statistics as stats

def exo31() :

    data_file = pd.ExcelFile('video_etu.xlsx')

    data_films = pd.read_excel(data_file, 'films')

    duree_films=data_films['FILM_DUREE']

    res_moy = []
    res_ecart_type = []

    for i in range(1000) :
        echantillon =np.random.choice(duree_films,size=50)
        res_moy.append(echantillon.mean())
        res_ecart_type.append(echantillon.std())

    print(res_moy)
    
    plt.hist(res_moy,bins=10,density=True,label="Répartitions moyenne des échantillons",color='green')
    plt.legend()

    x_min = min(res_moy)
    x_max = max(res_moy)

    mean = stats.mean(res_moy)
    std = stats.pstdev(res_ecart_type)

    x = np.linspace(x_min, x_max, 1000)
    y = sp.norm.ppf(x,mean,std)
    plt.plot(x,y, color='coral')


    plt.show()


exo31()