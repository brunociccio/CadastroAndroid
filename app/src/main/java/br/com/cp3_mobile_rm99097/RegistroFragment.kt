package br.com.cp3_mobile_rm99097

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.cp3_mobile_rm99097.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    private var _binding: FragmentRegistroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            val nome = binding.etNome.text.toString().trim()
            val idade = binding.etIdade.text.toString().trim()
            val endereco = binding.etEndereco.text.toString().trim()
            val telefone = binding.etTelefone.text.toString().trim()
            val nacionalidade = binding.etNacionalidade.text.toString().trim()
            val ocupacao = binding.etOcupacao.text.toString().trim()
            val hobby = binding.etHobby.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            if (nome.isEmpty() || idade.isEmpty() || endereco.isEmpty() || telefone.isEmpty() ||
                nacionalidade.isEmpty() || ocupacao.isEmpty() || hobby.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(activity, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                val prefs = activity?.getSharedPreferences("user_prefs", 0)
                val editor = prefs?.edit()
                editor?.putString("nome", nome)
                editor?.putString("idade", idade)
                editor?.putString("endereco", endereco)
                editor?.putString("telefone", telefone)
                editor?.putString("nacionalidade", nacionalidade)
                editor?.putString("ocupacao", ocupacao)
                editor?.putString("hobby", hobby)
                editor?.putString("email", email)
                editor?.putString("senha", senha)
                editor?.apply()

                Toast.makeText(activity, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()
                (activity as MainActivity).loadFragment(LoginFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
