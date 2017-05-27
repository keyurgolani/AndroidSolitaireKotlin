package io.github.keyurgolani.solitaire

/**
 * Created by keyurgolani on 5/26/17.
 */
class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init {
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    fun addCards(newCards: MutableList<Card>): Boolean {
        if (cards.size > 0) {
            if (newCards.first().value == cards.last().value - 1 && suitCheck(newCards.first(), cards.last())) {
                cards.addAll(cards)
                return true
            }
        } else if(newCards.first().value == 12) {
            cards.addAll(cards)
            return true
        }

        return false
    }

    fun removeCards(tappedIndex: Int) {
        for (i in tappedIndex..cards.lastIndex) {
            cards.removeAt(tappedIndex)
        }
        if (cards.size > 0) {
            cards.last().faceUp = true;
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        if ((redSuites.contains(c1.suit) && blackSuites.contains(c2.suit)) ||
                (blackSuites.contains(c1.suit) && redSuites.contains(c2.suit))) {
            return true
        }
        return false
    }
}