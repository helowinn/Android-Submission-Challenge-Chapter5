package com.android.erwin.challenge5gamesuit.startup.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.android.erwin.challenge5gamesuit.TypeGameActivity
import com.android.erwin.challenge5gamesuit.databinding.FragmentLandingPage3Binding

class LandingPage3Fragment : Fragment() {

    private var _binding : FragmentLandingPage3Binding? = null
    private val binding : FragmentLandingPage3Binding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLandingPage3Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inpUsername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.imgNextPage.isVisible = s.toString().trim().isNotEmpty()
            }
        })

        binding.imgNextPage.setOnClickListener {
            if (binding.inpUsername.text.isNotEmpty()){
                val username = binding.inpUsername.text.toString()
                val intent = Intent(activity,TypeGameActivity::class.java)
                intent.putExtra("username",username)
                startActivity(intent)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}