package com.app.passwordchecker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.passwordchecker.model.PasswordStrength
import com.app.passwordchecker.utils.PasswordUtils

class PasswordViewModel : ViewModel() {

    private val _strength = MutableLiveData<PasswordStrength>()
    val strength : LiveData<PasswordStrength> get() = _strength

    fun evaluatePassword(password: String){
        _strength.value = PasswordUtils.checkStrength(password)
    }
}
