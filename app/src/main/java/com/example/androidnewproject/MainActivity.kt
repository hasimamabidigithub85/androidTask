package com.example.androidtask


import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aankalan.utils.TouchDetectableScrollView
import com.example.androidnewproject.R
import com.example.androidnewproject.databinding.ActivityMainBinding
import com.example.androidtask.Adapter.MyAdapter
import com.example.androidtask.Model.LanguageModel
import com.example.androidtask.Utility.Resource
import com.example.androidtask.Utility.ViewModelFactory
import com.example.androidtask.ViewModel.VideoViewActivityViewModel
import org.json.JSONException
import java.util.*


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var rewardScrollView: TouchDetectableScrollView? = null
    var myAdapter: MyAdapter? = null
    var arrayList: java.util.ArrayList<LanguageModel.Search> =
        java.util.ArrayList<LanguageModel.Search>()
    private lateinit var viewModel: VideoViewActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)




        setupViewModel()
        LoginApi()

        binding!!.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {


                val liveTestListback: java.util.ArrayList<LanguageModel.Search>? =
                    searchKeywordInExam(
                        query!!
                    )

                setData(liveTestListback!!)


//                for (i in 0 until arrayList.size) {
//                    if (arrayList.get(i).title != null && arrayList.get(i).title!!.toLowerCase()
//                            .contains(query!!)) {
//                        myAdapter!!.getFilter().filter(query)
//                        myAdapter!!.notifyDataSetChanged()
//                    } else {
//                        Toast.makeText(this@MainActivity, "No Match found", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                val liveTestListback: java.util.ArrayList<LanguageModel.Search>? =
                    searchKeywordInExam(
                        newText!!
                    )
                setData(liveTestListback!!)
//                myAdapter!!.notifyDataSetChanged()
//                  val liveTestListback: ArrayList<LanguageModel.Search>? =
//                    searchKeywordInExam(newText)
                return false
            }
        })




    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this, ViewModelFactory()
        ).get(VideoViewActivityViewModel::class.java)
    }

    private fun searchKeywordInExam(search: String): ArrayList<LanguageModel.Search>? {
        var search = search
        search = search.lowercase(Locale.getDefault())
        val liveTestListback: ArrayList<LanguageModel.Search> =
            ArrayList<LanguageModel.Search>()
        val searchListLength: Int = arrayList.size
        for (i in 0 until searchListLength) {
            //teacher name, exam name, question paper name
            if (arrayList.get(i).title != null && arrayList.get(i).title!!.toLowerCase()
                    .contains(search)) {
                liveTestListback.add(arrayList.get(i))
            }
        }
        return liveTestListback
    }

    private fun LoginApi() {
        binding!!.relativeProgressDialog.progressCircular.visibility= View.VISIBLE
        viewModel.getMovieListApi()!!
            .observe(this) { finalData ->
                if(finalData!=null){
                    when (finalData.status) {
                        Resource.Status.SUCCESS -> {

                            if (finalData.data != null) {
                                binding!!.relativeProgressDialog.progressCircular.visibility= View.GONE
//                                Prefs.instanceOf(applicationContext).token=finalData.data.get(0).token

//                                if(finalData.data.get(0).data!=null){
//                                    Prefs.instanceOf(applicationContext).userId= finalData.data.get(0).data!!.id.toString()
//                                    Prefs.instanceOf(applicationContext).userName= finalData.data.get(0).data!!.firstName.toString()
//                                }

                                arrayList.clear()
                                arrayList.addAll(finalData.data.search!!)

                                setData(arrayList)
//                                Snackbar.make(
//                                    binding!!.constLayout1,
//                                    finalData.data.search.toString()+"",
//                                    Snackbar.LENGTH_SHORT
//                                ).setBackgroundTint(Color.BLACK)
//                                    .setTextColor(Color.WHITE)
//                                    .setDuration(1000)
//                                    .show()

                            }
                        }
                        Resource.Status.LOADING -> {
                            binding!!.relativeProgressDialog.progressCircular.visibility= View.GONE
                        }
                        Resource.Status.ERROR -> {
                            try {

                                binding!!.relativeProgressDialog.progressCircular.visibility= View.GONE

//                                Snackbar.make(
//                                    binding!!.relativeLayoutSnackBar,
//                                    finalData.jsonObject!!.getString("message")+"",
//                                    Snackbar.LENGTH_SHORT
//                                ).setBackgroundTint(Color.BLACK)
//                                    .setTextColor(Color.WHITE)
//                                    .setDuration(1000)
//                                    .show()

                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }

                        }
                    }
                }

            }
    }

    fun setData(arrayList: java.util.ArrayList<LanguageModel.Search>){

         myAdapter = MyAdapter(this,R.layout.grid_view_items, arrayList)
         binding!!.gridviewLayout.setAdapter(myAdapter)

    }
}