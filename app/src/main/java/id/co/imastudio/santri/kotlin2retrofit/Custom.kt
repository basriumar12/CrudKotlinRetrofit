package id.co.imastudio.santri.kotlin2retrofit

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Server on 23/08/2017.
 */
class Custom : RecyclerView.Adapter<Custom.MyHolder> {

    var c : Activity?=null
    var data2 : List<Datum>?=null

    constructor(c: Activity?, data2: List<Datum>?) {
        this.c = c
        this.data2 = data2
    }

    override fun getItemCount(): Int {
        return data2?.size!!
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {

        holder?.txtnis?.text = data2?.get(position)!!.nama
        holder?.txtnm?.text= data2?.get(position)!!.nis.toString()

        holder?.txtupdate?.setOnClickListener {
            var intent = Intent (c,UpdateDelete::class.java)
            intent.putExtra("id",data2?.get(position)?.id)
            intent.putExtra("nama",data2?.get(position)?.nama)
            intent.putExtra("nis",data2?.get(position)?.nis)
            c?.startActivity(intent)


        }

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var view = LayoutInflater.from(c).inflate(R.layout.custom_list,parent,false)
        return MyHolder(view)

       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


        //jika masih merah kita extend MyHolder sperti ini
    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var txtnis : TextView?=itemView?.findViewById(R.id.listnis)
        var txtnm : TextView?=itemView?.findViewById(R.id.listname)
        var txtupdate : TextView?=itemView?.findViewById(R.id.linkupdate)

    }
}