package strategy

import model.Attributes

interface AttributeDistribution {
    fun distributeAttributes(points: Int): Attributes
}