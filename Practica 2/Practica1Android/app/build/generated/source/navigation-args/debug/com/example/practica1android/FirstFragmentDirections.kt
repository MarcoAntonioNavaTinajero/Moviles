package com.example.practica1android

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Array
import kotlin.Int
import kotlin.String

public class FirstFragmentDirections private constructor() {
  private data class ActionFirstFragmentToSecondFragment(
    public val orden: Array<String>
  ) : NavDirections {
    public override val actionId: Int = R.id.action_FirstFragment_to_SecondFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putStringArray("orden", this.orden)
        return result
      }
  }

  public companion object {
    public fun actionFirstFragmentToSecondFragment(orden: Array<String>): NavDirections =
        ActionFirstFragmentToSecondFragment(orden)
  }
}
