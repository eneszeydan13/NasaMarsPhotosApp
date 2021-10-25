package com.example.nasaproject

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.view.Window
import android.widget.PopupWindow
import com.example.nasaproject.adapters.ViewPagerAdapter
import com.example.nasaproject.fragments.CuriosityFragment
import com.example.nasaproject.fragments.OpportunityFragment
import com.example.nasaproject.fragments.SpiritFragment
import com.example.nasaproject.viewholder.FeedItem
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


val filterList : MutableList<String> = mutableListOf()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpTabs()

    }

    private fun setUpTabs(){
        //We add our fragments to TabLayout
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CuriosityFragment(),"Curiosity")
        adapter.addFragment(OpportunityFragment(),"Opportunity")
        adapter.addFragment(SpiritFragment(),"Spirit")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Creating our menu with checkboxes for filtering
        menuInflater.inflate(R.menu.filter_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //If the item is checked it will be unchecked when it's clicked and its name will be added/removed from filterList
        return when(item.itemId){
            R.id.fhaz -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("FHAZ")){
                    filterList.remove("FHAZ")
                    setUpTabs()
                }else {filterList.add("FHAZ")
                setUpTabs()}
                true
            }

            R.id.rhaz -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("RHAZ")){
                    filterList.remove("RHAZ")
                    setUpTabs()
                }else {filterList.add("RHAZ")
                setUpTabs()}
                true
            }

            R.id.mast -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("MAST")){
                    filterList.remove("MAST")
                    setUpTabs()
                }else {filterList.add("MAST")
                setUpTabs()}
                true
            }

            R.id.chemcam -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("CHEMCAM")){
                    filterList.remove("CHEMCAM")
                    setUpTabs()
                }else {filterList.add("CHEMCAM")
                setUpTabs()}
                true
            }

            R.id.mahli -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("MAHLI")){
                    filterList.remove("MAHLI")
                    setUpTabs()
                }else {filterList.add("MAHLI")
                    setUpTabs()
                }
                true
            }

            R.id.mardi -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("MARDI")){
                    filterList.remove("MARDI")
                    setUpTabs()
                }else {filterList.add("MARDI")
                setUpTabs()}
                true
            }

            R.id.navcam -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("NAVCAM")){
                    filterList.remove("NAVCAM")
                    setUpTabs()
                }else {filterList.add("NAVCAM")
                setUpTabs()}
                true
            }

            R.id.pancam -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("PANCAM")){
                    filterList.remove("PANCAM")
                    setUpTabs()
                }else {filterList.add("PANCAM")
                setUpTabs()}
                true
            }

            R.id.minites -> {
                item.isChecked = !item.isChecked
                if (filterList.contains("MINITES")){
                    filterList.remove("MINITES")
                    setUpTabs()
                }else {filterList.add("MINITES")
                setUpTabs()}
                true
            }
            else -> super.onOptionsItemSelected(item)
        }





    }


}