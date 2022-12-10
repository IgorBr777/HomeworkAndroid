package com.example.homeworkandroid.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.R
import com.example.homeworkandroid.data.ItemsRepositoryImpl
import com.example.homeworkandroid.databinding.FragmentItemsBinding
import com.example.homeworkandroid.domain.ItemsInteractor
import com.example.homeworkandroid.model.ItemsModel
import com.example.homeworkandroid.presentation.adapter.ItemsAdapter
import com.example.homeworkandroid.presentation.adapter.listener.ItemsListener
import com.example.homeworkandroid.utils.BundleConstants

class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter
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
        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()

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

    override fun dataReceive(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_LONG).show()

    }

    override fun goToDetails(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int,
    ) {

        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(BundleConstants.TITLE, title)
        bundle.putString(BundleConstants.TIME, time)
        bundle.putString(BundleConstants.DESCRIPTION, description)
        bundle.putInt(BundleConstants.IMAGE_VIEW, imageView)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .add(R.id.activity_container, detailsFragment)
            .addToBackStack(getString(R.string.details))
            .commit()

    }


}