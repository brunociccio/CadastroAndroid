package br.com.cp3_mobile_rm99097

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.cp3_mobile_rm99097.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = activity?.getSharedPreferences("user_prefs", 0)

        binding.tvNome.text = "Nome: " + prefs?.getString("nome", "")
        binding.tvIdade.text = "Idade: " + prefs?.getString("idade", "")
        binding.tvEndereco.text = "Endereço: " + prefs?.getString("endereco", "")
        binding.tvTelefone.text = "Telefone: " + prefs?.getString("telefone", "")
        binding.tvNacionalidade.text = "Nacionalidade: " + prefs?.getString("nacionalidade", "")
        binding.tvOcupacao.text = "Ocupação: " + prefs?.getString("ocupacao", "")
        binding.tvHobby.text = "Hobby: " + prefs?.getString("hobby", "")
        binding.tvEmail.text = "Email: " + prefs?.getString("email", "")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
