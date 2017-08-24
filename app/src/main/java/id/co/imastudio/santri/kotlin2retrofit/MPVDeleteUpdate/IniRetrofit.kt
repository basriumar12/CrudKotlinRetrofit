package id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate

import id.co.imastudio.santri.kotlin2retrofit.ResponseData
import id.co.imastudio.santri.kotlin2retrofit.ResponseInsert
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by Server on 22/08/2017.
 */
class IniRetrofit {
    //function untuk inisialisa retrofit
    fun getInitRetrofit () : Retrofit{
        return Retrofit.Builder().
                baseUrl("http://192.168.20.174/crudKotlin/lumen-api24/public/").
                addConverterFactory(GsonConverterFactory.create()).
                build()


    }
    //
    public fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }
}

interface ApiService{
    //insert sisswwa
    @GET("input-siswa")
    fun request_insert (
            @Query("nama")name : String,
            @Query("nis")nis:Int,
            @Query("status")status :Int ) : Call<ResponseInsert>
    //menagkap siswa
    @GET("get-siswa")
    fun request_getdata():Call<ResponseData>
    //UPDATE SISWA
    @FormUrlEncoded
    @POST("update-siswa")
    fun  request_update(@Field("id")id :String,
                        @Field("nama")name: String,
                        @Field("nis")nis: String):Call<ResponseInsert>
    //hapus siswa
    @FormUrlEncoded
    @POST("delete-siswa")
    fun  request_delete(@Field("id")id :String)
            :Call<ResponseInsert>

}