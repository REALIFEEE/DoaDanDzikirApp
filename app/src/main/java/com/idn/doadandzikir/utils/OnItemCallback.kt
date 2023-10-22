package com.idn.doadandzikir.utils

import com.idn.doadandzikir.Model.Artikel

interface OnItemCallback {
    fun onItemClick(item: Artikel)
}