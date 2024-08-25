package org.example.strategy

import model.Attribute
import model.Attributes
import strategy.AttributeDistribution

class CustomAttributeDistribution : AttributeDistribution {
    override fun distributeAttributes(points: Int): Attributes {
        var remainingPoints = points
        val scores = mutableMapOf<String, Int>()
        val attributes = listOf("Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma")

        println("Você tem $remainingPoints pontos para distribuir entre os atributos.")

        attributes.forEach { attributeName ->
            var score = 8
            var currentCost = calculateCost(score)
            remainingPoints -= currentCost

            while (true) {
                println("-------------------------------------")
                println("Atribua pontos para $attributeName (atualmente $score, custo $currentCost, mínimo 8, máximo 15).")
                println("-------------------------------------")
                val input = readLine()?.toIntOrNull()

                if (input == null || input < 8 || input > 15) {
                    println("Erro: Valor inválido. Os pontos devem estar entre 8 e 15.")
                    continue
                }

                val newCost = calculateCost(input)
                val costDifference = newCost - currentCost

                if (input > score && remainingPoints < costDifference) {
                    println("Erro: Não há pontos suficientes para atribuir este valor. Pontos restantes: $remainingPoints")
                }
                else if (input >= 8 && input <= 15 && (input == score || remainingPoints >= costDifference)) {
                    remainingPoints -= costDifference
                    score = input
                    currentCost = newCost
                    println("Pontos restantes: $remainingPoints")
                    break
                }
                else {
                    println("Erro: Valor inválido ou insuficiente de pontos. Tente novamente.")
                }
            }
            scores[attributeName] = score
        }

        return Attributes(
            strength = Attribute(scores["Força"] ?: 10),
            dexterity = Attribute(scores["Destreza"] ?: 10),
            constitution = Attribute(scores["Constituição"] ?: 10),
            intelligence = Attribute(scores["Inteligência"] ?: 10),
            wisdom = Attribute(scores["Sabedoria"] ?: 10),
            charisma = Attribute(scores["Carisma"] ?: 10)
        )
    }

    private fun calculateCost(score: Int): Int = when (score) {
        8 -> 0
        9 -> 1
        10 -> 2
        11 -> 3
        12 -> 4
        13 -> 5
        14 -> 7
        15 -> 9
        else -> throw IllegalArgumentException("Score fora do intervalo permitido")
    }
}