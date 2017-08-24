package id.co.imastudio.santri.kotlin2retrofit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate.IniRetrofit
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dapatData()


        img.setOnClickListener{
            startActivity(Intent(applicationContext,TambahActivity::class.java))
        }
    }

    private fun dapatData() {
        //get init
        var api = IniRetrofit().getInitInstance()
                //get req
        var call = api.request_getdata()
        call.enqueue(object : retrofit2.Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {
                Log.d("error get data :" , t.toString())

                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<ResponseData>?, response: Response<ResponseData>?) {
                Log.d("response get data : ", response?.message())
                if (response != null){
                    if (response.isSuccessful){
                        //get json arrary
                        var data = response.body()?.data
                        //array kita pindahkan ke recylerview

                        var adapter = Custom(this@MainActivity,data)
                        recycler.adapter= adapter
                        var liner = LinearLayoutManager(applicationContext)
                        recycler.layoutManager=liner


                    }
                }

                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
