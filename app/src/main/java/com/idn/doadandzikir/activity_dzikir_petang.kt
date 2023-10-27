package com.idn.doadandzikir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.adapter.QauliyahAdapter
import com.idn.doadandzikir.databinding.ActivityDzikirPetangBinding
import com.idn.doadandzikir.databinding.ActivityPagiPetangDzikirBinding
import com.idn.doadandzikir.databinding.ActivityQauliyahShalat2Binding

class activity_dzikir_petang : AppCompatActivity() {
    private var _binding : ActivityDzikirPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Petang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvDzikirPetang.apply {
            val mAdapter = QauliyahAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPetang)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }




    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}