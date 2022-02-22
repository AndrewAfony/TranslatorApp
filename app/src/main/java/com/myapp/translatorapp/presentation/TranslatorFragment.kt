package com.myapp.translatorapp.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.addTextChangedListener
import com.myapp.translatorapp.R
import com.myapp.translatorapp.databinding.FragmentTranslatorBinding

class TranslatorFragment : Fragment() {

    private var _binding: FragmentTranslatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTranslatorBinding.inflate(inflater, container, false)

        binding.textFromTranslate.addTextChangedListener {
            binding.responseText.text = it.toString()
        }

        binding.enterTextCard.setOnClickListener {
            openKeyboard(binding.textFromTranslate)
        }

        binding.exitTextCard.setOnClickListener {
            copyToClipboard(binding.responseText.text.toString())
            Toast.makeText(activity, "Copied translation", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun openKeyboard(editText: EditText) {
        editText.requestFocus()

        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

    private fun copyToClipboard(text: String) {
        val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("response", text)
        clipboard.setPrimaryClip(clip)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}