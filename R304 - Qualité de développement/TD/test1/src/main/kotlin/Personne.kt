class Personne(nom : String, prenom : String) {

    private var nom :String
    private var prenom : String

    init {
        this.nom = nom
        this.prenom = prenom
    }

    fun donneNomComplet() : String {
        return "$prenom ${nom.uppercase()}"
    }

}