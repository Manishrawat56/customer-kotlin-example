package com.vdishub.kotlinproject.customer.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vdishub.kotlinproject.R
import com.vdishub.kotlinproject.customer.persistance.Customer
import kotlinx.android.synthetic.main.customer_item.view.*

class CustomerAdapter :
    RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {
    private lateinit var customerList: List<Customer>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.customer_item,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return if (::customerList.isInitialized) customerList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.name.text = customerList.get(position).name
        holder.itemView.phone.text = customerList.get(position).phone
        holder.itemView.city.text = customerList.get(position).address
        //holder.itemView.txtPostBody.text = customerList.get(position).

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun updateCustomerList(customerList: List<Customer>) {
        this.customerList = customerList
        notifyDataSetChanged()
    }
}