package io.github.keyurgolani.solitaire.backend

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import io.github.keyurgolani.solitaire.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by keyurgolani on 5/27/17.
 */
class FoundationPileView(context: Context, val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.size > 0) getResourceIDForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {  }) = ankoView({ FoundationPileView(it, index) }, 0, init)