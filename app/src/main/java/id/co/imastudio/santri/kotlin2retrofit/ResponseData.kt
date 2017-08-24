package id.co.imastudio.santri.kotlin2retrofit

import com.google.gson.annotations.SerializedName


class ResponseData {

    @SerializedName("data")
    var data: List<Datum>? = null

}
