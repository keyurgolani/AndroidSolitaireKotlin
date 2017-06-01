package io.github.keyurgolani.solitaire

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

val cardbackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1

fun View.getResourceIDForCard(card: Card): Int {
    val resourceName = "card${card.suit}${cardsMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

val Context.cardWidth: Int
        get() = (displayMetrics.widthPixels - dip(8)) / 7
val Context.cardHeight: Int
        get() = cardWidth * 190 / 140

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            imageView {
                id = 50
                imageResource = R.drawable.welcomeimage
            }.lparams {
                width = (displayMetrics.widthPixels) * 3 / 4
                height = width * 642 / 953
                leftMargin = width / 6
                topMargin = displayMetrics.heightPixels / 4
            }
            button {
                text = "Play"
                onClick {
                    val intent: Intent = Intent(baseContext, GameActivity::class.java)
                    startActivity(intent)
                }
            }.lparams {
                topMargin = displayMetrics.heightPixels / 4
                gravity = Gravity.CENTER_HORIZONTAL
            }
        }
    }
}
