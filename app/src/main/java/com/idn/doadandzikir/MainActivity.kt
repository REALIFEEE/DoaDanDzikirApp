package com.idn.doadandzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract.Data
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.UI.SetiapSaatDzikirActivity
import com.idn.doadandzikir.UI.qauliyahShalatActivity
import com.idn.doadandzikir.adapter.ArtikelAdapter
import com.idn.doadandzikir.utils.OnItemCallback

class MainActivity : AppCompatActivity() {
    private var keep = true
    private val run = Runnable { keep = false }

    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderIndicator: Array <ImageView?>

    private val listArtikel : ArrayList<Artikel> = arrayListOf()
    private val slidingCallBack = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size){
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.dot_slider)
                )
            }
            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.dot_sliders)
            )

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { keep }
        Handler().postDelayed(run, 2000)
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        val llsliderdots: LinearLayout = findViewById(R.id.slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size){
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,R.drawable.dot_sliders
                )
            )
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            param.setMargins(9,0,8,0)
            param.gravity = Gravity.CENTER_VERTICAL
            llsliderdots.addView(sliderIndicator[i],param)
        }
       sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_slider
            )
        )
    }

    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val kontenArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (i in titleArtikel.indices) {
            val data = Artikel(
                imageArtikel.getResourceId(i, 0),
                titleArtikel[i],
                kontenArtikel[i]
            )
            listArtikel.add(data)
        }
        imageArtikel.recycle()
    }

    private fun initView() {
        var ll_dzikir_doa_shalat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        ll_dzikir_doa_shalat.setOnClickListener{
            startActivity(Intent(this, qauliyahShalatActivity::class.java))
        }

        var ll_dzikir_setiap_saat : LinearLayout = findViewById<LinearLayout>(R.id.ll_dzikir_setiap_saat)
        ll_dzikir_setiap_saat.setOnClickListener{
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

//        var ll_dzikir_pagi_petang : LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
//        ll_dzikir_pagi_petang.setOnClickListener { startActivity(Intent(this,PagiPetang )) }

        vpArtikel = findViewById(R.id.vp_artikel)
       val mAdapter = ArtikelAdapter()
        mAdapter.setData(listArtikel)
        vpArtikel.adapter = mAdapter
       vpArtikel.registerOnPageChangeCallback(slidingCallBack)

        mAdapter.setOnItemClickCallback(object : OnItemCallback{
            override fun onItemClick(item: Artikel) {
                val intent = Intent(this@MainActivity,activity_detail_artikel::class.java)
                intent.putExtra("data",item)
                startActivity(intent)
            }

        }        )
    }
}