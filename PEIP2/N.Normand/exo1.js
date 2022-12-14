'use strict'

function César(key,msg) {
    let msgTab = [...msg]
    let cryptTab = msgTab.map(i => (i.charCodeAt(0) - 65 + key) % 26 + 65).map(n => String.fromCharCode(n))

    return cryptTab.join('')
}

function mod(a,b) {
    const val = ((a%b)+b)%b;
    return val
}

function brutCésar(msg) {

    for (let i=0 ; i<26 ; i++) {
        console.log(César(i,msg),)
    }

}

function gcd(a,b) {

    while (b !== 0) {
        let k = Math.floor(a/b);
        [a,b] = [b,a-k*b];
    }
    return a
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

const Reels = {

    add: (a,b) => a+b,
    minus: (a,b) => a-b,
    times: (a,b) => a*b,
    divide: (a,b) => a/b

}

function GF(p) {
    return {
        add: (a,b) => mod(a+b,p),
        minus: (a,b) => mod(a-b,p),
        times: (a,b) => mod(a*b,p),
        divide: (a,b) => mod(extended_gcd(b,p)[0]*a,p)
    }
}

console.log(extended_gcd(9,13));
console.log(GF(17).add(13,5));
console.log(GF(17).minus(13,5));
console.log(GF(17).times(13,5))
console.log(GF(17).divide(13,5));

function exp_mod(x,nb,p) {

    let e = 0, y = 1;   

    for (const i of nb.toString(2)) {
        y = mod(y**2,p)
        e = e*2;

        if (i === '1') {
            y = mod(x*y,p);
            e = e + 1;
        }
    }

    return y
}