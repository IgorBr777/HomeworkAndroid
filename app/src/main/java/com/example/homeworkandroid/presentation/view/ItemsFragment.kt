package com.example.homeworkandroid.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homeworkandroid.R
import com.example.homeworkandroid.databinding.FragmentItemsBinding
import com.example.homeworkandroid.presentation.adapter.ItemsAdapter
import com.example.homeworkandroid.presentation.adapter.listener.ItemsListener
import com.example.homeworkandroid.utils.BundleConstants

class ItemsFragment : Fragment(), ItemsListener {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)

        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_LONG).show()

        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {

                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString(BundleConstants.TITLE, navBundle.title)
                bundle.putString(BundleConstants.TIME, navBundle.time)
                bundle.putString(BundleConstants.DESCRIPTION, navBundle.description)
                bundle.putInt(BundleConstants.IMAGE_VIEW, navBundle.image)
                detailsFragment.arguments = bundle

                parentFragmentManager
                    .beginTransaction()
                    .add(R.id.activity_container, detailsFragment)
                    .addToBackStack(getString(R.string.details))
                    .commit()

            }

        }
    }


    override fun onClick() {

        viewModel.imageViewClicked()
    }

    override fun onElementSelected(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int,
    ) {
        viewModel.elementClicked(title, time, description, imageView, imageView2)

    }

}