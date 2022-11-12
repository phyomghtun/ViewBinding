package apk.testing.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import apk.testing.viewbinding.databinding.ActivityMainBinding
import apk.testing.viewbinding.databinding.DialogActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dialogBinding: DialogActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener(){
            binding.tv.text = "This is Binding Text"
            binding.btn.text = "Clicked"
            openDialog()
        }
    }

    private fun openDialog(){
        dialogBinding = DialogActivityBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogBinding.root)
        val dialog = builder.create()
        dialog.show()

        dialogBinding.btnOk.setOnClickListener {
            Toast.makeText(this,"Ok Clicked",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialogBinding.btnCancel.setOnClickListener {
            Toast.makeText(this,"Cancel Clicked",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }


    }
}
