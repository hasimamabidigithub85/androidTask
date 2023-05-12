package com.example.androidtask.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.androidnewproject.databinding.GridViewItemsBinding
import com.example.androidtask.Model.LanguageModel
import com.squareup.picasso.Picasso
import java.util.ArrayList


class MyAdapter(context: Context?, textViewResourceId: Int, objects: ArrayList<LanguageModel.Search>) :
    ArrayAdapter<LanguageModel.Search?>(context!!, textViewResourceId,
        objects as List<LanguageModel.Search?>
    ) {
    var birdList: java.util.ArrayList<LanguageModel.Search> = java.util.ArrayList<LanguageModel.Search>()

    init {
        birdList = objects
    }

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v = convertView
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val binding = GridViewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        binding.titleText.text=birdList.get(position).title
        //add thumbnail
        Picasso.with(context)
            .load(birdList[position].poster)
            .into(binding.imageView)

        return binding.root
    }
}