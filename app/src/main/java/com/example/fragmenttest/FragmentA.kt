package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.fragmenttest.databinding.FragmentABinding

// Родительский класс, в который положим вложенные классы NestedFragmentA и NestedFragmentB.
class FragmentA : BindingFragment<FragmentABinding>(), SelectPage {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentABinding {
        return FragmentABinding.inflate(inflater, container, false)
    }

    /*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentABinding.inflate(inflater, container, false).root
    }

     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radio = requireArguments().getString(RADIO_KEY)
        FragmentABinding.bind(view).fragmentA.text = radio

        (requireActivity() as RadioStorage).setRadio(radio)
        // Добавляем первый вложенный фрагмент
        /*
        childFragmentManager.beginTransaction()
            .add(R.id.fragment_child_container, NestedFragmentA())
            .commit()

         */

         val adapter = PagerAdapter(hostFragment = this)
         binding.pager.adapter = adapter
    }

    override fun navigateTo(page: Int) {
        binding.pager.currentItem = page
    }

    companion object {
        const val RADIO_KEY = "RADIO_KEY"

        fun getInstance(radio: String) = FragmentA().apply {
            arguments = bundleOf(RADIO_KEY to radio)
        }
    }
}