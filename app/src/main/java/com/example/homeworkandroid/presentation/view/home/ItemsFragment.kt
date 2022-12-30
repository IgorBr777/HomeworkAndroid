package com.example.homeworkandroid.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.databinding.FragmentItemsBinding
import com.example.homeworkandroid.model.ItemsModel
import com.example.homeworkandroid.presentation.adapter.ItemsAdapter
import com.example.homeworkandroid.presentation.adapter.listener.ItemsListener
import com.example.homeworkandroid.utils.BundleConstants
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()

    }


    override fun onClick() {
        itemsPresenter.imageViewClicked()

    }

    override fun onElementSelected(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int,
    ) {
        itemsPresenter.elementSelected(title, time, description, imageView, imageView2)

    }

    override fun itemsReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_LONG).show()

    }

    override fun itemClicked(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int
    ) {

        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(BundleConstants.TITLE, title)
        bundle.putString(BundleConstants.TIME, time)
        bundle.putString(BundleConstants.DESCRIPTION, description)
        bundle.putInt(BundleConstants.IMAGE_VIEW, imageView)
        detailsFragment.arguments = bundle

        NavigationExt.fmReplace(parentFragmentManager, detailsFragment, true)


    }


}