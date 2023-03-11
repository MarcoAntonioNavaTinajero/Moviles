package com.example.practica1android

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Array
import kotlin.String
import kotlin.jvm.JvmStatic

public data class SecondFragmentArgs(
  public val orden: Array<String>
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putStringArray("orden", this.orden)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("orden", this.orden)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SecondFragmentArgs {
      bundle.setClassLoader(SecondFragmentArgs::class.java.classLoader)
      val __orden : Array<String>?
      if (bundle.containsKey("orden")) {
        __orden = bundle.getStringArray("orden")
        if (__orden == null) {
          throw IllegalArgumentException("Argument \"orden\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"orden\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__orden)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SecondFragmentArgs {
      val __orden : Array<String>?
      if (savedStateHandle.contains("orden")) {
        __orden = savedStateHandle["orden"]
        if (__orden == null) {
          throw IllegalArgumentException("Argument \"orden\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"orden\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__orden)
    }
  }
}
