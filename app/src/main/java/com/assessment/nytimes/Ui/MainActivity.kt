package com.assessment.nytimes.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.assessment.nytimes.Adapter.NewsAdapter

import com.assessment.nytimes.Model.News
import com.assessment.nytimes.Model.Result
import com.assessment.nytimes.R
import com.assessment.nytimes.Listener.Listener
import com.assessment.nytimes.Network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),Listener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var articlesList: ArrayList<Result>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
        fetchData()
    }



    private fun setUpUi() {
        recyclerView=findViewById(R.id.recyclerView)
        newsAdapter= NewsAdapter(this,ArrayList<Result>(),this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=newsAdapter
        }
    }
    //https://newsapi.org/v2/everything?q=bitcoin&apiKey=6c5056fa50ac45bea2b1d2423bac290d
    private fun fetchData() {
        val call:Call<News> = RetrofitBuilder.newApi.getNews("qLV02TGybZY2SY84ALpcW52IqDMdax7q")
        call.enqueue(object :Callback<News> {

            override fun onResponse(call: Call<News>, response: Response<News>) {
                if(response.isSuccessful)
                {
                    val listArticles=response.body()?.results
                    if(listArticles!=null && listArticles.isNotEmpty()){
                        newsAdapter.setData(listArticles as ArrayList<Result>)
                        progressBar.visibility=View.GONE
                        recyclerView.visibility= View.VISIBLE
                    }
                    articlesList= response.body()?.results as ArrayList<Result>
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("main", "onFailure: ${t.message}")
            }

        })
    }

    override fun onItemClickListener(position: Int) {
        val intent= Intent(this, WebActivity::class.java)
        intent.putExtra("url",articlesList[position].url)
        startActivity(intent)
    }
}