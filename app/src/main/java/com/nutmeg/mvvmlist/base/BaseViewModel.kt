package com.nutmeg.mvvmlist.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.nutmeg.mvvmlist.MVVMApplication

open class BaseViewModel(protected val useCases: UseCases) : ViewModel() {

}