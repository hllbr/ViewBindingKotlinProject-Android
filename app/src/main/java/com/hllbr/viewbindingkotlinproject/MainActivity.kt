package com.hllbr.viewbindingkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.hllbr.viewbindingkotlinproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   // private lateinit var textView : TextView//lateinit var = sonradan bu ifadeyi tanımlayacağım sorun çıkarma olarak ifade edebilirim

    //3.yöntem View Binding
    private lateinit var binding :ActivityMainBinding//Activite adına özel bir binding oluşturuluyor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //global textView tanımlanması = initialize && Defining
       // textView = findViewById<TextView>(R.id.textView)//artık textView heryerde kullanılabilir bir pozisyona gelmiş oldu
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root//görünüm artık burada oluşturduğum değişkenden alınıyor.Bunu her activity açtığımda yapmam gerekiyor.
        setContentView(view)

    }
   fun ismiDegistir(view : View){
        //Yapının buton tarafından çağrılabilmesi için bir görünüm tarafından kotrol edileceğini ifade etmem gerekiyor bunu view : View ile yapıyorum
        println("Değiştirildi/Changed")
        //textView.text = "Hello HLLBR"Yöntem 1
        //Yöntem 2 =
        val textView = findViewById<TextView>(R.id.textView)//Tanımlamada TextView = sınıf olandan yararlandığım için bu şekilde ifade etmem gerekiyor
        textView.text = "Hİ HLLBR"//Bu tanımlama kapsamı sadece ismiDegistir içerisinde geçerli yerel bir ifade yeryerde kullanmak için global bir alanda tanımlamam gerekiyor.

        //xxx
        binding.textView.text = "Hi/Hello Kotlin"

        //view binding jet pack ile gelen yeniliklerden biri android-extension için oluşturulmuş alternatiftir.Modern store için yazılmış yazılacak uygulamalara eklemek doğru olacaktır.

    }
}