package id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate

import android.util.Log
import id.co.imastudio.santri.kotlin2retrofit.ResponseInsert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Server on 23/08/2017.
 */
class PresenterUpadateHapus {
    var presenterView : PresenterModel?=null

    constructor(presenterView: PresenterModel?) {
        this.presenterView = presenterView
    }

            fun Hapus(id :String) {
                //get inisialisasi
                var getInit = IniRetrofit().getInitInstance()
                //get request
                var request = getInit.request_delete(id)

                /* proggres.setMessage("Loading")
                 proggres.show()*/
                //get response
                request.enqueue(object : Callback<ResponseInsert> {
                    override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

                        Log.d("Error insert", t.toString())

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {

                        Log.d("Resposnse insert :", response?.message())
                        if (response != null) {
                            if (response.isSuccessful && response.body()?.status.equals("true")) {
                                var result = response.body()?.status
                                var msg = response.body()?.mas
                                presenterView?.Hasil(result!!, msg!!,1)


                            }
                        }

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })




            }

            fun Edit(id: String,nama: String, nis :String) {


                //get inisialisasi
                var getInit = IniRetrofit().getInitInstance()
                //get request
                var request = getInit.request_update(id,nama,nis)

                /* proggres.setMessage("Loading")
             proggres.show()*/
                //get response
                request.enqueue(object : Callback<ResponseInsert> {
                    override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

                        Log.d("Error insert", t.toString())

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {

                        Log.d("Resposnse insert :", response?.message())
                        if (response != null) {
                            if (response.isSuccessful && response.body()?.status.equals("true")) {
                                var result = response.body()?.status
                                var msg = response.body()?.mas
                                presenterView?.Hasil(result!!, msg!!,0)


                            }
                        }

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }

            fun Input(nama: String, nis :String) {
                        if (nama.isNotEmpty()&&nis.isNotEmpty()){

                    //get inisialisasi
                    var getInit = IniRetrofit().getInitInstance()
                    //get request
                    var request = getInit.request_insert(nama, nis.toInt(), 1)

                    /* proggres.setMessage("Loading")
             proggres.show()*/
                    //get response
                    request.enqueue(object : Callback<ResponseInsert> {
                        override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

                            Log.d("Error insert", t.toString())

                            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {

                            Log.d("Resposnse insert :", response?.message())
                            if (response != null) {
                                if (response.isSuccessful && response.body()?.status.equals("true")) {
                                    var result = response.body()?.status
                                    var msg = response.body()?.mas
                                    presenterView?.Hasil(result!!, msg!!, 0)


                                }
                            }

                            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                }


            }
}