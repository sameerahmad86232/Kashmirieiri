package com.kashmirieiri.keyboard

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button

class KashmiriKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val keyboardView = LayoutInflater.from(this).inflate(R.layout.keyboard_view, null)
        bindButtons(keyboardView)
        return keyboardView
    }

    private fun bindButtons(view: View) {
        when (view) {
            is Button -> view.setOnClickListener { handleKeyPress(view.tag?.toString() ?: view.text.toString()) }
            is ViewGroup -> {
                for (i in 0 until view.childCount) {
                    bindButtons(view.getChildAt(i))
                }
            }
        }
    }

    private fun handleKeyPress(value: String) {
        val inputConnection = currentInputConnection ?: return
        when (value) {
            "KEY_DELETE" -> {
                if (!inputConnection.deleteSurroundingText(1, 0)) {
                    inputConnection.sendKeyEvent(
                        KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL)
                    )
                    inputConnection.sendKeyEvent(
                        KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL)
                    )
                }
            }

            "KEY_SPACE" -> inputConnection.commitText(" ", 1)
            "KEY_ENTER" -> {
                val editorInfo = currentInputEditorInfo
                val actionId = editorInfo?.imeOptions?.and(EditorInfo.IME_MASK_ACTION) ?: EditorInfo.IME_ACTION_NONE
                if (actionId != EditorInfo.IME_ACTION_NONE && actionId != EditorInfo.IME_ACTION_UNSPECIFIED) {
                    inputConnection.performEditorAction(actionId)
                } else {
                    inputConnection.commitText("\n", 1)
                }
            }

            else -> inputConnection.commitText(value, 1)
        }
    }
}
