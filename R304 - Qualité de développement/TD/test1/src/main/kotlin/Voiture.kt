class Voiture(mod : String, coul: String, vCourante : Double, vitMax : Double, enMarche : Boolean) {

    private var mod : String
    private var coul : String
    private var vCourante : Double = 0.0
    private var vitMax : Double
    private var enMarche : Boolean = false

    private var proprietaire : Personne?

    init {
        this.mod = mod
        this.coul = coul
        this.vCourante = vCourante
        this.vitMax = vitMax
        this.enMarche = enMarche
        proprietaire = null
    }

    fun acheter(acheteur : Personne) {
        proprietaire = acheteur
    }

    fun demarrer() {
        enMarche = true
    }
    fun arreter() {
        enMarche = false
    }

    fun estEnMarche() : Boolean {
        return enMarche
    }

    fun repeindre(new : String) {
        coul = new
    }

    fun accelerer(acceleration : Double) : Double {
        if (estEnMarche()) {
            vCourante += acceleration
            if (vCourante > vitMax) {
                return vitMax
            }
        }
        return vCourante
    }

    fun decelerer(deceleration : Double) : Double {
        if (estEnMarche()) {
            vCourante -= deceleration
            if (vCourante > 0) {
                return 0.0
            }
        }
        return vCourante
    }



}