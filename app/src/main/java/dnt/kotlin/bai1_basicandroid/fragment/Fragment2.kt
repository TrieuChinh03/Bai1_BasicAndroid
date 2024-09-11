package dnt.kotlin.bai1_basicandroid.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dnt.kotlin.bai1_basicandroid.R


class Fragment2 : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment2", "onAttach")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment2", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment2", "onCreateView")
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Fragment2", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.d("Fragment2", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Fragment2", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Fragment2", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Fragment2", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Fragment2", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Fragment2", "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Fragment2", "onDestroy")
        super.onDetach()
    }

}