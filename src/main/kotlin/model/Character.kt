package model

import strategy.AttributeDistribution

class Character(
    val name: String,
    val race: Race,
    val charClass: CharClass,
    distributionStrategy: AttributeDistribution
) {
    var level: Int = 1
    val attributes: Attributes = distributionStrategy.distributeAttributes(27)
    val hitPoints: Int = calculateInitialHitPoints()

    private fun calculateInitialHitPoints(): Int {
        return charClass.hitDice + attributes.constitution.modifier
    }

    override fun toString(): String {
        return """
            |Nome: $name
            |Raça: ${race.description}
            |Classe: ${charClass.description}
            |Nível: $level
            |Pontos de Vida: $hitPoints
            |Força: ${attributes.strength.score} (Modificador: ${attributes.strength.modifier})
            |Destreza: ${attributes.dexterity.score} (Modificador: ${attributes.dexterity.modifier})
            |Constituição: ${attributes.constitution.score} (Modificador: ${attributes.constitution.modifier})
            |Inteligência: ${attributes.intelligence.score} (Modificador: ${attributes.intelligence.modifier})
            |Sabedoria: ${attributes.wisdom.score} (Modificador: ${attributes.wisdom.modifier})
            |Carisma: ${attributes.charisma.score} (Modificador: ${attributes.charisma.modifier})
        """.trimMargin()
    }
}