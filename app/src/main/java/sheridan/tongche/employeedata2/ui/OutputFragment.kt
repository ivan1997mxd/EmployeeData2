package sheridan.tongche.employeedata2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.tongche.employeedata2.R
import sheridan.tongche.employeedata2.databinding.FragmentOutputBinding
import sheridan.tongche.employeedata2.model.Employee

class OutputFragment : Fragment() {

    companion object {
        const val EMPLOYEE = "employee"
    }

    private lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        binding.employee = arguments?.getSerializable(EMPLOYEE) as Employee
        binding.back.setOnClickListener { findNavController().navigate(R.id.action_outputFragment_to_inputFragment) }
        return binding.root
    }

}