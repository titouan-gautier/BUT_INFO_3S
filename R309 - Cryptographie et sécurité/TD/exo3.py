    import math as mt
    import time
    import matplotlib.pyplot as plt
    import numpy as np
    from scipy.stats import linregress
    import random as rd

    # Exercice 3 - 1

    dict_cod={'a':1,'b':2,'c':3,'d':4,'e':5,'f':6,'g':7,'h':8,'i':9,'j':10,'k':11,'l':12,'m':13,'n':14,'o':15,'p':16,'q':17,\
                    'r':18,'s':19,'t':20,'u':21,'v':22,'w':23,'x':24,'y':25,'z':26,' ':27,',':28,'.':29,'?':30,':':0}

    # Exercice 3 - 2

    def chiff_affine(msg,a,b) : 

        print(msg)

        msg_code = []

        for i in msg :
            pos = (a*dict_cod[i]+b) % 31
            msg_code.append(pos)

        msg_crypt = ""
        
        for y in msg_code :
            for cle , valeur in dict_cod.items() :
                if y == valeur :
                    msg_crypt += cle

        return msg_crypt

    """ print(chiff_affine("allez nantes ?",2,1)) """

    # Exercice 3 - 3

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

    def dechiff_affine(msg,a,b,p) :

        msg_decod = []

        for i in msg :
            inverse_mod = extended_gcd(a,p)
            pos = ((dict_cod[i]-b)*inverse_mod) % 31
            msg_decod.append(str(round(pos)))

        msg_decrypt = ""

        for y in msg_decod :
            for cle , valeur in dict_cod.items() :
                if int(y) == valeur :
                    msg_decrypt += cle

        return msg_decrypt

    print(dechiff_affine(chiff_affine("allez nantes ?",2,1),2,1,31))

    # Exercice 3 - 4

    # Il y a 31*31 clé différente ce qui fait 961 clé différentes.

    def cass_chiff_affine(msg) :
        a = rd.randint(0,31)
        b = rd.randint(0,31)

