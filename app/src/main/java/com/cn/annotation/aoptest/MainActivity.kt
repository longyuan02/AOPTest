//package com.cn.annotation.aoptest
//
//import android.app.Activity
////import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.TextView
//import android.widget.Toast
//import com.cn.annotation.aoptest.aop.CheckLogin
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        //在activity中的使用姿势
//        val mTextView by bindView<TextView>(R.id.tv_text)
//        mTextView.text = "执行到我时，才会进行控件初始化"
//        mTextView.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                test()
//            }
//        })
//
//    }
//
//    //kotlin 封装：
//    fun <V : View> Activity.bindView(id: Int): Lazy<V> = lazy {
//        viewFinder(id) as V
//    }
//
//    //acitivity中扩展调用
//    private val Activity.viewFinder: Activity.(Int) -> View?
//        get() = { findViewById(it) }
//
//    @CheckLogin
//    fun test() {
//        Toast.makeText(this@MainActivity, "show", Toast.LENGTH_LONG).show()
//    }
//}
