package com.example.hm8x
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hm8x.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val characterList = arrayListOf(
        CharacterModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjwayBi6zyvFZOnMpri62KeObE-WFIDDCu3Q&usqp=CAU", "Alive", "PO"),
        CharacterModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxa1Td-yPwFBk6Q_L0pVgDl9ksjeqKRMEifQ&usqp=CAU", "Alive", "Shifu"),
        CharacterModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFQ4DPyvIqQ3FhUlCJxspLbuA1s0hTczyhCw&usqp=CAU", "Alive", "Tigress"),
        CharacterModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFiAZx9ZLDYdQkiS6ev7hR85QYn-dCqicG0Q&usqp=CAU", "Alive", "Monkey"),
        CharacterModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1sabuwxSpC2jyKk5sfSPqrv6xcLUpEpfA2A&usqp=CAU", "Died", "Tai Lung"),
        CharacterModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4y1ke9vv1cA4HgpxipQSuIE3kaAa2mw3OxA&usqp=CAU", "Died", "Kai")

    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(characterList, this::onClick)
        binding.rvPerson.adapter = adapter
    }
    private fun onClick(position: Int) {
        val bundle = Bundle().apply {
            putString("image", characterList[position].picture)
            putString("live", characterList[position].data)
            putString("name", characterList[position].name)
        }
        findNavController().navigate(
            R.id.action_listFragment_to_detailsFragment,
            bundle
        )
    }
}