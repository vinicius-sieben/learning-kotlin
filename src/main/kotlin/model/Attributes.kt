package model

class Attribute (var score: Int){
    val modifier: Int
        get() = (score - 10) / 2
}

class Attributes (
    var strength: Attribute,
    var dexterity: Attribute,
    var constitution: Attribute,
    var intelligence: Attribute,
    var wisdom: Attribute,
    var charisma: Attribute
)