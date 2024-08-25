package model

enum class CharClass(val hitDice: Int, val description: String) {
    WARRIOR(10, "Guerreiro"), // D10 para PV
    MAGE(6, "Mago"), // D6 para PV
    ROGUE(8, "Ladino"), // D8 para PV
    CLERIC(8, "Clérigo") // D8 para PV
}