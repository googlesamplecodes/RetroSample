package com.google.retrosample.dashboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.retrosample.R
import com.google.retrosample.dashboard.adapters.ShowAdapter
import com.google.retrosample.dashboard.daggers.components.DaggerMainComponents
import com.google.retrosample.dashboard.viewmodels.SelectionViewModels

import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfirmFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recylerview: RecyclerView
    lateinit var showAdapter: ShowAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val selectionViewModels: SelectionViewModels by activityViewModels(){
        viewModelFactory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm, container, false)
        DaggerMainComponents.builder().build().inject(this)
        init(view)
        initRecylerview()
        observerViewModels()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConfirmFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun init(view: View) {
        recylerview = view.findViewById(R.id.recylerview)
        showAdapter = ShowAdapter(requireActivity())
    }

    fun initRecylerview() {
        recylerview.apply {
            layoutManager = LinearLayoutManager(activity)
            setItemAnimator(DefaultItemAnimator())
            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )
            setHasFixedSize(true)
            adapter = showAdapter
        }
    }

    fun observerViewModels() {
       // selectionViewModels = ViewModelProvider(this, viewModelFactory).get(SelectionViewModels::class.java)
        selectionViewModels.getFruits().observe(viewLifecycleOwner, {
            it?.let {
                showAdapter.setData(it.values.toList())

            }
        })
    }


}