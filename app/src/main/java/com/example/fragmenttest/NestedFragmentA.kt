package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragmenttest.databinding.FragmentNestedABinding
import com.example.fragmenttest.databinding.FragmentNestedBBinding

// Первый вложенный фрагмент
class NestedFragmentA : BindingFragment<FragmentNestedABinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNestedABinding {
        return FragmentNestedABinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * При нажатии на кнопку заменяем фрагмент, который находится внутри контейнера
         * "fragment_child_container", на новый
         */

        val name = (requireActivity() as RadioStorage).getRadio()
        FragmentNestedABinding.bind(view).nestedA.text = name + " 1"

        binding.button.setOnClickListener {
            // Тут транзакция реализована через extension-функцию, а не через цепочку из методов
            /*
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentB())
            }

             */
            (parentFragment as? SelectPage)?.navigateTo(page = 1)
        }
    }
}