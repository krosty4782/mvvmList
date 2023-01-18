package com.mvvmlist.util

import androidx.annotation.MainThread
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class AbstractViewBindingDelegate<in R, T : ViewBinding>(
    private val viewBinder: (R) -> T
) : ReadOnlyProperty<R, T> {

    private var viewBinding: T? = null
    private val lifecycleObserver = BindingLifecycleObserver()

    protected abstract fun getLifecycleOwner(thisRef: R): LifecycleOwner

    @MainThread
    override fun getValue(thisRef: R, property: KProperty<*>): T {
        viewBinding?.let { return it }

        getLifecycleOwner(thisRef).lifecycle.addObserver(lifecycleObserver)
        return viewBinder(thisRef).also { viewBinding = it }
    }

    private inner class BindingLifecycleObserver : DefaultLifecycleObserver {

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)
            viewBinding = null
        }
    }
}

internal class FragmentViewBindingDelegate<F : Fragment, T : ViewBinding>(
    viewBinder: (F) -> T
) : AbstractViewBindingDelegate<F, T>(viewBinder) {

    override fun getLifecycleOwner(thisRef: F) = thisRef.viewLifecycleOwner
}

internal class ActivityViewBindingDelegate<A : ComponentActivity, T : ViewBinding>(
    viewBinder: (A) -> T
) : AbstractViewBindingDelegate<A, T>(viewBinder) {

    override fun getLifecycleOwner(thisRef: A) = thisRef
}
