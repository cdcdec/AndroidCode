package com.cdc.keyboard.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cdc.keyboard.R
import com.cdc.keyboard.util.DensityUtil
import com.cdc.keyboard.util.Logs
import kotlinx.android.synthetic.main.activity_main_0.*

class MainActivity0 : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAbout -> {
                goToPage(AboutActivity::class.java)
            }
            R.id.btnAgreement -> {
                goToPage(AgreementActivity::class.java)
            }
            R.id.btnAliOrder -> {
                goToPage(AliOrderActivity::class.java)
            }
            R.id.btnWelcome -> {
                goToPage(WelcomeActivity::class.java)
            }
            R.id.btnBlueToothPrinterEdit -> {
                goToPage(BlueToothPrinterEditActivity::class.java)
            }
            R.id.btnLogin ->{
                goToPage(LoginActivity::class.java)
            }
            R.id.btnAfterLogin ->{
                goToPage(PosDownLoaderAfterLoginActivity::class.java)
            }
            R.id.btnAppIntro ->{
                goToPage(AppIntroActivity::class.java)
            }
            R.id.btnOrderOperation ->{
                goToPage(OrderOperationActivity::class.java)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_0)
        btnAbout.setOnClickListener(this)
        btnAgreement.setOnClickListener(this)
        btnAliOrder.setOnClickListener(this)
        btnWelcome.setOnClickListener(this)
        btnBlueToothPrinterEdit.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnAfterLogin.setOnClickListener(this)
        btnAppIntro.setOnClickListener(this)
        btnOrderOperation.setOnClickListener(this)

        DensityUtil.getResolution(this)
        Logs.E("1235")
        Logs.D("12345D")
        Logs.e("123","321")


    }

    private fun <T> goToPage(cls: Class<T>) {
        var intent = Intent(this, cls)
        startActivity(intent)
    }
}
