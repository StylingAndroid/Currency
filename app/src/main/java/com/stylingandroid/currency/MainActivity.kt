package com.stylingandroid.currency

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1.text = formatCurrency(1f, CURRENCY_US_DOLLARS, LANGUAGE_ENGLISH, COUNTRY_US)
        textView2.text = formatCurrency(1f, CURRENCY_US_DOLLARS, LANGUAGE_ENGLISH, COUNTRY_CANADA)
        textView3.text = formatCurrency(1f, CURRENCY_US_DOLLARS, LANGUAGE_ENGLISH, COUNTRY_AUSTRALIA)
    }

    private fun formatCurrency(amount: Float, currency: String, language: String, country: String) =
            currencyInLocale(currency, language, country).format(amount)

    private fun currencyInLocale(
            currencyCode: String,
            language: String,
            country: String = "",
            variant: String = ""): NumberFormat =
            Locale(language, country, variant).let {
                NumberFormat.getCurrencyInstance(it).apply {
                    currency = Currency.getInstance(currencyCode)
                }
            }

    companion object {
        private const val CURRENCY_US_DOLLARS: String = "USD"
        private const val LANGUAGE_ENGLISH: String = "EN"
        private const val COUNTRY_US: String = "US"
        private const val COUNTRY_CANADA: String = "CA"
        private const val COUNTRY_AUSTRALIA: String = "AU"
    }
}
