package com.mvvmlist.util

import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

fun <F : Fragment, T : ViewBinding> F.viewBinding(viewBinder: (F) -> T): AbstractViewBindingDelegate<F, T> {
    return FragmentViewBindingDelegate(viewBinder)
}

fun <A : ComponentActivity, T : ViewBinding> A.viewBinding(viewBinder: (A) -> T): AbstractViewBindingDelegate<A, T> {
    return ActivityViewBindingDelegate(viewBinder)
}