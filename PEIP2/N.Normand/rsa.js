'use strict'

//p = 13
//q = 3
//kPub = 3

function extended_gcd(a,b) {
    let [c1,d1,g1] = [Math.sign(a),0,a];
    let [c2,d2,g2] = [0,Math.sign(b),b];

    while (g2 !== 0) {
        let k = Math.floor(g1/g2);
        [c1,d1,g1,c2,d2,g2] = [c2,d2,g2,c1-k*c2,d1-k*d2,g1-k*g2];
    }
    
    return [c1,d1,g1]

}

function mod(a,b) {
    const val = ((a%b)+b)%b;
    return val
}

function generate_key(p,q) {

    let phi = (p-1) * (q-1)
    let d,e,g

    do {
        e = Math.random() * ((phi - 5) + 3)|0;
        [d,,g] = extended_gcd(e,phi);
        d = mod(d,phi)
    } while (g !== 1)
    
    return [e,d]

}

// e = clé public
// d = clé privé

