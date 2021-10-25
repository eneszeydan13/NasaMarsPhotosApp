package com.example.nasaproject.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nasaproject.PopUpActivity
import com.example.nasaproject.R
import com.example.nasaproject.filterList
import com.example.nasaproject.model.Photos
import com.example.nasaproject.service.OpportunityNetwork
import com.example.nasaproject.viewholder.FeedItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_opportunity.*
import retrofit2.Call
import retrofit2.Response


class OpportunityFragment : Fragment() {

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opportunity, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Assigning GroupAdapter to the recyclerView
        opportunityRecyclerView.adapter = adapter
        loadOpportunityPhotos()

    }

    private fun loadOpportunityPhotos(){

        val call = OpportunityNetwork.retrofit.getOpportunityPhotos()
        call.enqueue(object: retrofit2.Callback<Photos>{
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        //For every photo that the api returns, we create a feedItem
                        it.photos.forEach{
                            //Checking to see if the returned photo's camera is filtered out
                            if(filterList.isEmpty()){
                                adapter.add(FeedItem(it))
                            }else if(filterList.contains(it.camera.name)){
                                adapter.add(FeedItem(it))
                            }
                            adapter.setOnItemClickListener { item, view ->
                                val feedItem = item as FeedItem
                                createPopUp(feedItem)

                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                println(t.localizedMessage)
            }

        })
    }
    fun createPopUp(feedItem: FeedItem){
        //When user clicks on an item, it creates a new activity above MainActivity
        activity?.let {
            val intent = Intent(it, PopUpActivity::class.java)
            intent.putExtra("photo",feedItem.photo)
            startActivity(intent)
        }

    }


}