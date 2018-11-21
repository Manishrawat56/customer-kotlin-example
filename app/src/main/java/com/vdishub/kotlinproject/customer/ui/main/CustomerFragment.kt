package com.vdishub.kotlinproject.customer.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vdishub.kotlinproject.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_fragment.*

class CustomerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerFragment()
        private val TAG = CustomerFragment::class.java.simpleName
    }

    private lateinit var viewModel: CustomerViewModel
    private val disposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java)
        // TODO: Use the ViewModelUserActivity
        recyclerView.layoutManager= LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DividerItemDecoration(activity,LinearLayoutManager.VERTICAL))
        Log.e("viewModel@@"    ,""+viewModel.getCustomerAdpater())
        recyclerView.adapter=viewModel.getCustomerAdpater()
    }

    override fun onStart() {
        super.onStart()
        disposable.add(viewModel.getAllcustomer()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ if (it!=null){
                progressBar.visibility=View.GONE
                viewModel.getCustomerAdpater().updateCustomerList(it)
            }
            },
                { error -> Log.e(CustomerFragment.TAG, "Unable to get customer list", error) }))
    }


    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

}
