package com.app.passwordchecker.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.app.passwordchecker.model.PasswordStrength

object PasswordUtils {
    fun checkStrength(password: String): PasswordStrength {
        return when {
            password.length < 6 -> PasswordStrength.WEAK
            password.matches(Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$")) -> PasswordStrength.STRONG
            password.matches(Regex("^(?=.*[A-Za-z])(?=.*\\d).{6,}$")) -> PasswordStrength.MEDIUM
            else -> PasswordStrength.WEAK
        }
    }

    @BindingAdapter("afterTextChanged")
    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

}
