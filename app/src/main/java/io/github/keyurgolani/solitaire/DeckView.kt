package io.github.keyurgolani.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by keyurgolani on 5/27/17.
 */
class DeckView(context: Context) : ImageView(context) {
    init {
        imageResource = cardbackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update() {
        val cards = GameModel.deck.cardsInDeck
        imageResource = if (cards.size > 0) cardbackDrawable else emptyPileDrawable
    }
}

fun ViewManager.deckView(init: DeckView.() -> Unit = {  }) = ankoView({ DeckView(it) }, 0, init)