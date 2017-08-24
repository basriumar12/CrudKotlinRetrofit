package id.co.imastudio.santri.kotlin2retrofit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate.PresenterModel
import id.co.imastudio.santri.kotlin2retrofit.MPVDeleteUpdate.PresenterUpadateHapus
import kotlinx.android.synthetic.main.activity_update_delete.*

class UpdateDelete : AppCompatActivity(), PresenterModel {


    //deklarasi variabel penampung index
    var id : Long? = null
    var nama : String? = null
    var nis : Long? =null
    var presenter : PresenterUpadateHapus? = null
    var presenter1 : PresenterUpadateHapus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

    id= intent.getLongExtra("id",0)
    nama = intent.getStringExtra("nama")
        nis = intent.getLongExtra("nis",0)

        presenter = PresenterUpadateHapus(this)

        edtnis.setText(nis.toString())
        edtnama.setText(nama)

        //update
        updatesiswa.setOnClickListener {
           presenter!!.Edit(id.toString(),edtnama.text.toString(),edtnis.text.toString())
        }
        //button delete
        deletesiswa.setOnClickListener {

            presenter!!.Hapus(id.toString())
        }

    }
    override fun Hasil(result: String, msg: String, status : Int) {
        if(status==0){

        }else{

        }
        if (result.equals("true")){
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
        }



        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
        Log.e("error update",error.toString())
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
