package br.com.cp3_mobile_rm99097

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.cp3_mobile_rm99097.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(activity, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {

                val prefs = activity?.getSharedPreferences("user_prefs", 0)
                val storedEmail = prefs?.getString("email", null)
                val storedSenha = prefs?.getString("senha", null)

                if (email == storedEmail && senha == storedSenha) {
                    (activity as MainActivity).loadFragment(PerfilFragment())
                } else {
                    Toast.makeText(activity, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnCadastrar.setOnClickListener {
            (activity as MainActivity).loadFragment(RegistroFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
