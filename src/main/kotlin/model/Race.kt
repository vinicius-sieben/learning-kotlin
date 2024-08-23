package model

enum class Race (val description: String, val abilityBonuses: Map<String, Int>) {
    DWARF("Anão", mapOf("Constituição" to 2)),
    ELF("Elfo", mapOf("Destreza" to 2)),
    HUMAN("Humano", mapOf("Força" to 1, "Destreza" to 1, "Constituição" to 1, "Inteligência" to 1, "Sabedoria" to 1, "Carisma" to 1)),
    HALFLING("Halfling", mapOf("Destreza" to 2));


}