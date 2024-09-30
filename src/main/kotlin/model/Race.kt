package model

enum class Race (val description: String, val attributeBonuses: Map<String, Int>) {
    DWARF("Anão", mapOf("Constituição" to 2)),
    ELF("Elfo", mapOf("Destreza" to 2)),
    HUMAN("Humano", mapOf("Força" to 1, "Destreza" to 1, "Constituição" to 1, "Inteligência" to 1, "Sabedoria" to 1, "Carisma" to 1)),
    HALFLING("Halfling", mapOf("Destreza" to 2));

    fun applyRacialBonuses(attributes: Attributes) {
        attributeBonuses.forEach { (attribute, bonus) ->
            when (attribute) {
                "Força" -> attributes.strength.score += bonus
                "Destreza" -> attributes.dexterity.score += bonus
                "Constituição" -> attributes.constitution.score += bonus
                "Inteligência" -> attributes.intelligence.score += bonus
                "Sabedoria" -> attributes.wisdom.score += bonus
                "Carisma" -> attributes.charisma.score += bonus
            }
        }
    }

}