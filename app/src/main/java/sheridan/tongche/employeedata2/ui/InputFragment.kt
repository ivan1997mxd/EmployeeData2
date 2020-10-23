package sheridan.tongche.employeedata2.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sheridan.tongche.employeedata2.R
import sheridan.tongche.employeedata2.databinding.FragmentInputBinding
import sheridan.tongche.employeedata2.model.Employee
import sheridan.tongche.employeedata2.ui.OutputFragment.Companion.EMPLOYEE

class InputFragment : Fragment() {
    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        binding.submit.setOnClickListener { showOutput() }

        return binding.root
    }

    private fun showOutput() {
        val name = binding.nameInput.text.toString().trim()
        if (name.isEmpty()) {
            val required = "Name Cannot be empty"
            binding.nameInput.error = required
            Toast.makeText(context, required, Toast.LENGTH_LONG).show()
        } else {
            val trained = binding.isTrained.isChecked
            val certified = binding.isCertified.isChecked
            val employee = Employee(name, trained, certified)
            val arguments = Bundle()
            arguments.putSerializable(EMPLOYEE, employee)
            findNavController().navigate(R.id.action_inputFragment_to_outputFragment, arguments)
        }
    }
}