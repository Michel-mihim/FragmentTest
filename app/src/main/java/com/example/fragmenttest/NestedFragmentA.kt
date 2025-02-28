package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragmenttest.databinding.FragmentNestedABinding

// Первый вложенный фрагмент
class NestedFragmentA : Fragment() {

    private var _binding: FragmentNestedABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNestedABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * При нажатии на кнопку заменяем фрагмент, который находится внутри контейнера
         * "fragment_child_container", на новый
         */

        FragmentNestedABinding.bind(view).nestedA.text = (requireActivity() as RadioStorage).getRadio()

        binding.button.setOnClickListener {
            // Тут транзакция реализована через extension-функцию, а не через цепочку из методов
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentB())
            }
        }
    }
}