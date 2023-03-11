package com.example.practica1android

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class SecondFragmentDirections private constructor() {
  public companion object {
    public fun actionSecondFragmentToFirstFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_SecondFragment_to_FirstFragment)
  }
}
