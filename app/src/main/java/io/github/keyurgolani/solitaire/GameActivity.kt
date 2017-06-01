package io.github.keyurgolani.solitaire

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import io.github.keyurgolani.solitaire.backend.FoundationPileView
import io.github.keyurgolani.solitaire.backend.foundationPileView
import org.jetbrains.anko.*

class GameActivity : AppCompatActivity(), GameView {

    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null
    val foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)
    val tableauPileViews: Array<TableauPileView?> = arrayOfNulls(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame()

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)
            linearLayout {
                deckView = deckView().lparams(width = cardWidth, height = cardHeight)
                wastePileView = wastePileView().lparams(width = cardWidth, height = cardHeight)
                view().lparams(width = cardWidth, height = 0)
                for (i in 0..3) {
                    foundationPileViews[i] = foundationPileView(i).lparams(width = cardWidth, height = cardHeight)
                }
            }
            linearLayout {
                for (i in 0..6) {
                    tableauPileViews[i] = tableauPileView(i).lparams(width = cardWidth, height = matchParent)
                }
            }.lparams(height = matchParent) {
                topMargin = cardHeight / 2
            }
        }
    }

    override fun update() {
        deckView!!.update()
        wastePileView!!.update()
        foundationPileViews.forEach { it!!.update() }
        tableauPileViews.forEach { it!!.update() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val startOverButton: MenuItem = menu.add("♻")
        startOverButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        GameModel.resetGame()
        update()
        return true
    }
}
