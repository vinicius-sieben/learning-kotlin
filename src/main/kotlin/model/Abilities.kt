package model

class Ability (val score: Int){
    val modifier: Int
        get() = (score - 10) / 2
}

class Abilities (
    val strenght: Ability,
    val dexterity: Ability,
    val constituition: Ability,
    val intelligence: Ability,
    val wisdom: Ability,
    val charisma: Ability
)