package com.example.homeworkandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkandroid.adapter.ItemsAdapter
import com.example.homeworkandroid.listener.ItemsListener
import com.example.homeworkandroid.model.ItemsModel
import java.time.LocalDate

class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private  val viewModel:ItemsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner){listItems->
            itemsAdapter.submitList(listItems)

        }
viewModel.msg.observe(viewLifecycleOwner){msg->
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()

}
viewModel.bundle.observe(viewLifecycleOwner){navBundle->
    val detailsFragment = DetailsFragment()
    val bundle = Bundle()
    bundle.putString(Constance.TITLE, navBundle.title)
    bundle.putString(Constance.TIME, navBundle.time)
    bundle.putString(Constance.DESCRIPTION,navBundle.description)
    bundle.putInt(Constance.IMAGE_VIEW,navBundle.image)
    detailsFragment.arguments = bundle

    parentFragmentManager
        .beginTransaction()
        .add(R.id.activity_container, detailsFragment)
        .addToBackStack(getString(R.string.details))
        .commit()

}

    }

    override fun onClick() {
      viewModel.imageViewClicked()

    }
    override fun onElementSelected(title:String, time:String,description:String, imageView: Int,imageView2: Int,) {

        viewModel.elementClicked(title,time,description,imageView,imageView2)
    }
}