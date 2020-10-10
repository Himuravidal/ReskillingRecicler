package com.example.reskillingrecicler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), DogAdapter.PassData {

    lateinit var mAdapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = DogAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = recyclerDog
        recyclerView.layoutManager = LinearLayoutManager(context)
        //recyclerView.layoutManager = GridLayoutManager(context, 3)
        //recyclerView.layoutManager = StaggeredGridLayoutManager(2,1)
        recyclerView.adapter = mAdapter
        mAdapter.updateAdapter(getData())
    }


    fun getData(): List<String> {
        return listOf("https://unsplash.com/photos/N04FIfHhv_k/download?force=true&w=640",
            "https://unsplash.com/photos/qO-PIF84Vxg/download?force=true&w=640",
            "https://unsplash.com/photos/yihlaRCCvd4/download?force=true&w=640",
            "https://unsplash.com/photos/DziZIYOGAHc/download?force=true&w=640",
            "https://unsplash.com/photos/Qb7D1xw28Co/download?force=true&w=640"
        )
    }

    override fun passTheUrl(url: String) {
        Log.d("URL", url)
        Toast.makeText( context, url, Toast.LENGTH_LONG).show()
        val mBundle = Bundle()
        mBundle.putString("url", url)
        // pasar al segundo fragmento y mandando la URL en argumentos.
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)

    }


}