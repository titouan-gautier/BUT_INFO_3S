'use strict'

// Pour (1,1)(2,3)(3,2)
//
// L1(x) = (x-2)(x-3)/(1-2)(1-3)
// On prend les deux parenthèse qui ne osnt pas 1
// On fait x - le prmeir chiffre de ces parenthèse
// diviser par le premier chiffre de la première parenthése - le chiffre du dessus

/* x = [1,2,3,4]
y = [1,3,2,2] */

//map accepte plusieur parametre le deuxieme est l'indice

// Le polynome de Lagrange c'est la somme de yi * Li(x)

function polynome(X,i) {

    return function(x) {
        let res = X.filter((_,j) => j !== i)
        res = res.map(xj => (x - xj)/(X[i]-xj))
        res = res.reduce((p,v) => p*v,1);
        return res
    }    
}

function FuncLagrange(X,Y) {

    let L = X.map((_,i) => polynome(X,i))

    let Lagrange = x => Y.map((yi,i) => yi*L[i](x))
                .reduce((s,v) => s+v,1)

    return Lagrange

}

function test(L,X) {
    for (const li of L) {
        console.log(X.map(x => li(x)))
    }
}


let X = [1,2,3,4]
let Y = [1,3,2,2]

let l = polynome([1,2,3,4],0);
console.log(l(1),l(2),l(3),l(4))

let Lag = FuncLagrange(X,Y)
console.log(Lag(1))

let L = X.map((_,i) => polynome(X,i))
console.log(test(L,[1,2,3,4]))


//Après il faut refaire le polynome dans un GF voir fonction d'avant
//Remplacer les opération dans polynome et FuncLagrange par les opération de GF

function mod(a,b) {
    const val = ((a%b)+b)%b;
    return val
}

function extended_gcd(a,b) {
    let [c1,d1,g1] = [Math.sign(a),0,a];
    let [c2,d2,g2] = [0,Math.sign(b),b];

    while (g2 !== 0) {
        let k = Math.floor(g1/g2);
        [c1,d1,g1,c2,d2,g2] = [c2,d2,g2,c1-k*c2,d1-k*d2,g1-k*g2];
    }
    
    return [c1,d1,g1]

}

function GF(p) {
    return {
        add: (a,b) => mod(a+b,p),
        minus: (a,b) => mod(a-b,p),
        times: (a,b) => mod(a*b,p),
        divide: (a,b) => mod(extended_gcd(b,p)[0]*a,p)
    }
}

const k = GF(17)

/* const k = {

    add: (a,b) => a+b,
    minus: (a,b) => a-b,
    times: (a,b) => a*b,
    divide: (a,b) => a/b

} */

function polynomeGF(X,i) {

    return function(x) {
        let res = X.filter((_,j) => j !== i)
        res = res.map(xj => k.divide((k.minus(x,xj)),(k.minus(X[i],xj))))
        res = res.reduce((p,v) => k.times(p,v),1);
        return res
    }    
}

function FuncLagrangeGF(X,Y) {

    let L = X.map((_,i) => polynomeGF(X,i))

    let Lagrange = x => Y.map((yi,i) => k.times(yi,L[i](x)))
                .reduce((s,v) => k.add(s,v))

    return Lagrange

}

function testGF(L,X) {
    for (const li of L) {
        console.log(X.map(x => li(x)))
    }
}

let XGF = [1,2,3,4]
let YGF = [1,3,2,2]

let lGF = polynomeGF(XGF,1);
console.log(lGF(1),lGF(2),lGF(3),lGF(4))

let LagGF = FuncLagrangeGF(XGF,YGF)
console.log(LagGF(1))

let LGF = XGF.map((_,i) => polynomeGF(XGF,i))
console.log(testGF(LGF,X))


//Méthode de shamir : Construire un polynome random ex : P(x) = 5x² + 3x + 6
// avec 6 = secret et les deux paramètre random et le degré = m(nombre de personne pour débloquer) -1
// Le but produire n secret (x,P(x)) avec x appartient à [1,n]
// Montrer qu'on reconstruit le secret avec m participant
// On met les m polynome (x,P(x)) dans Lagrange puis Lagrange(0) nous donnent le secret. 