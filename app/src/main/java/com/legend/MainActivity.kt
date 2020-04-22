package com.legend

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.legend.home.HomeFragment
import com.legend.mine.Minefragment
import com.legend.suprise.SupriseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var homeFragment:HomeFragment ?= null
    var findFragment:FindFragment ?= null
    var supriseFragment: SupriseFragment?= null
    var mineFragment: Minefragment?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setStatusBar()

        initFragments()
        addListeners()
    }

    private fun setStatusBar() {
        val statusBarHeight = getStatusBarHeight(resources)
        val layoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        layoutParams.topMargin = statusBarHeight
        fm_container.layoutParams = layoutParams
    }

    private fun initFragments() {
        homeFragment = HomeFragment()
        findFragment = FindFragment()
        supriseFragment = SupriseFragment()
        mineFragment = Minefragment()

        var beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.add(R.id.fm_container,homeFragment!!,"homefragment")
        beginTransaction.add(R.id.fm_container,findFragment!!,"findfragment")
        beginTransaction.add(R.id.fm_container,supriseFragment!!,"suprisefragment")
        beginTransaction.add(R.id.fm_container,mineFragment!!,"minefragment")
        beginTransaction.commitAllowingStateLoss()
    }

    private fun addListeners() {
        radioButton1.setOnClickListener { changeHomePage(ConstObject.HOME_BT_1) }
        radioButton2.setOnClickListener { changeHomePage(ConstObject.HOME_BT_2) }
        radioButton3.setOnClickListener { changeHomePage(ConstObject.HOME_BT_3) }
        radioButton4.setOnClickListener { changeHomePage(ConstObject.HOME_BT_4) }
    }

    private fun changeHomePage(homeBtNum: Int) {
        var beginTransaction = supportFragmentManager.beginTransaction()
        hideFragment(beginTransaction)
         when(homeBtNum){
             1 -> showHome(beginTransaction)
             2 -> showFind(beginTransaction)
             3 -> showSuprise(beginTransaction)
             4 -> showMy(beginTransaction)
         }
    }

    private fun showHome(transaction:FragmentTransaction) {
        transaction.show(homeFragment!!)
        transaction.commitAllowingStateLoss()
    }

    private fun showFind(transaction:FragmentTransaction) {
        transaction.show(findFragment!!)
        transaction.commitAllowingStateLoss()
    }

    private fun showSuprise(transaction: FragmentTransaction) {
        transaction.show(supriseFragment!!)
        transaction.commitAllowingStateLoss()
    }

    private fun showMy(transaction: FragmentTransaction) {
        transaction.show(mineFragment!!)
        transaction.commitAllowingStateLoss()
    }

    private fun hideFragment(beginTransaction: FragmentTransaction) {
        beginTransaction.hide(homeFragment!!)
        beginTransaction.hide(findFragment!!)
        beginTransaction.hide(supriseFragment!!)
        beginTransaction.hide(mineFragment!!)
    }


}
