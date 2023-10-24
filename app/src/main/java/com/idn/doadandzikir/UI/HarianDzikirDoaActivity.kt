package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Model.DoaDanDzikirItem
import com.idn.doadandzikir.R
import com.idn.doadandzikir.adapter.QauliyahAdapter
import com.idn.doadandzikir.databinding.ActivityHarianDzikirDoaBinding

class HarianDzikirDoaActivity : AppCompatActivity() {
    private var _binding : ActivityHarianDzikirDoaBinding ?= null
    private  val binding get() = _binding as ActivityHarianDzikirDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        provideDzikirData()
        initView()
    }

    private fun initView() {
       val mAdapter = QauliyahAdapter()
        mAdapter.setData(provideDzikirData())
        binding.rvDzikirDoaHarian.adapter = mAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun provideDzikirData() : List<DoaDanDzikirItem>{
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabic =  resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDanDzikirItem>()
        for (i in titleDzikir.indices) {
            val data = DoaDanDzikirItem(
                titleDzikir[i],
                arabic[i],
                terjemah[i]
            )
            listData.add(data)
        }
        return listData
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}