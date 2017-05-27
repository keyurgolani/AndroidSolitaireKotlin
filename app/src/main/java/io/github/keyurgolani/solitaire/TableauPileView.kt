package io.github.keyurgolani.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import android.widget.RelativeLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by keyurgolani on 5/27/17.
 */
class TableauPileView(context: Context, val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update() {
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(25)).toFloat()
                imageResource = if (card.faceUp) getResourceIDForCard(card) else cardbackDrawable
                onClick {
                    GamePresenter.onTableauTap(index, i)
                }
            }.lparams(width = context.cardWidth, height = context.cardHeight)
        }
    }
}

fun ViewManager.tableauPileView(index: Int, init: TableauPileView.() -> Unit = {  }) = ankoView({ TableauPileView(it, index) }, 0, init)