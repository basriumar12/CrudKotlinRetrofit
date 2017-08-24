package id.co.imastudio.santri.kotlin2retrofit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate.PresenterModel
import id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate.PresenterUpadateHapus
import kotlinx.android.synthetic.main.activity_tambah.*

class TambahActivity : AppCompatActivity(), PresenterModel {

    var name1: String?=null
    var nis1: String?=null
    var presenter : PresenterUpadateHapus?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        presenter= PresenterUpadateHapus(this)
        tambahsiswa.setOnClickListener{


            name1 = nama.text.toString()
            nis1 = nis.text.toString()

            presenter!!.Input(name1.toString(),nis1.toString())

            /*if (name1.isNotEmpty()&& nis.isNotEmpty()){
                //get inisialisasi
                var getInit = IniRetrofit().getInitInstance()
               //get request
                var request = getInit.request_insert(name1,nis.toInt(),1)
                var proggres = ProgressDialog(applicationContext)
               *//* proggres.setMessage("Loading")
                proggres.show()*//*
                //get response
                request.enqueue(object : retrofit2.Callback<ResponseInsert> {
                    override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

                        Log.d("Error insert", t.toString())

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {

                        Log.d("Resposnse insert :",response?.message())
                        if (response != null){
                            if ( response.isSuccessful && response.body()?.status.equals("true")){

                                startActivity(Intent(applicationContext,MainActivity::class.java))
                                finish()
                            }
                        }

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }*/
        }
    }
        //panggilan dari this
    override fun Hasil(result: String, msg: String, status : Int) {
        if(status==0){

        }else{

        }
        if (result.equals("true")){
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
        }



        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
        Log.e("error update",error.toString())
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
