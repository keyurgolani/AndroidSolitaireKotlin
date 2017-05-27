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
class WastePileView(context: Context) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }

    fun update() {
        val cards = GameModel.wastePile
        imageResource = if (cards.size > 0) getResourceIDForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {  }) = ankoView({ WastePileView(it) }, 0, init)