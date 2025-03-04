package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragmenttest.databinding.FragmentNestedABinding
import com.example.fragmenttest.databinding.FragmentNestedBBinding

// Второй вложенный фрагмент
class NestedFragmentB : BindingFragment<FragmentNestedBBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNestedBBinding {
        return FragmentNestedBBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Тут также при нажатии на кнопку заменяем фрагмент из "fragment_child_container" на
         * другой.
         */

        val name = (requireActivity() as RadioStorage).getRadio()
        FragmentNestedBBinding.bind(view).nestedB.text = name + " 2"

        binding.button.setOnClickListener {
            /*
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentA())
            }

             */

            (parentFragment as? SelectPage)?.navigateTo(page = 0)
        }
    }
}