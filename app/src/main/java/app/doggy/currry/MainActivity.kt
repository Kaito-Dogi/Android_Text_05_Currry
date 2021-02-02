package app.doggy.currry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //現状を管理する変数を設定。
    var statusNum = 0

    //配列を用意。
    val rices: Array<String> = arrayOf("ごはん", "食パン", "うどん")
    val currys: Array<String> = arrayOf("おふくろの", "グリーン", "マッサマン", "うんち味の")
    val kake: Array<String> = arrayOf("かける！", "かけない！")

    //画像の配列を用意。
    val riceImages: Array<Int> = arrayOf(
        R.drawable.rice,
        R.drawable.shokupan,
        R.drawable.udon)

    val curryImages: Array<Int> = arrayOf(
        R.drawable.curry,
        R.drawable.green,
        R.drawable.matsaman,
        R.drawable.unchi)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //クリックリスナを設定。
        button.setOnClickListener(TryYourLuckListener())

    }

    private inner class TryYourLuckListener: View.OnClickListener {
        override fun onClick(view: View) {

            //statusNumの値によって処理を変える。
            when(statusNum) {
                0 -> {
                    //乱数を設定。
                    var randomNum = Random.nextInt(3)

                    //画像を表示。
                    riceImageView.setImageResource(riceImages[randomNum])

                    //文字を表示。
                    riceTextView.text = rices[randomNum] + "に"

                    //statusNumを更新。
                    statusNum += 1
                }

                1 -> {
                    //乱数を設定。
                    var randomNum = Random.nextInt(4)

                    //画像を表示。
                    curryImageView.setImageResource(curryImages[randomNum])

                    //文字を表示。
                    curryTextView.text = currys[randomNum] + "カレーを"

                    //statusNumを更新。
                    statusNum += 1
                }

                2 -> {
                    //乱数を設定。
                    var randomNum = Random.nextInt(2)

                    //文字を表示。
                    kakeTextView.text = kake[randomNum]

                    //statusNumを更新。
                    statusNum += 1

                    //ボタンのテキストを変える。
                    button.text = "リセット"
                }

                3 -> {
                    //画像をリセット。
                    riceImageView.setImageResource(R.drawable.question)
                    curryImageView.setImageResource(R.drawable.question)

                    //文字をリセット。
                    riceTextView.text = "？？？に"
                    curryTextView.text = "？？？を"
                    kakeTextView.text = "かける？かけない？"

                    //ボタンのテキストをリセット。
                    button.text = "うんだめし"

                    //statusNumを更新。
                    statusNum = 0
                }
            }
        }
    }
}