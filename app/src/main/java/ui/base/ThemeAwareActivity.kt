package ui.base

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.xodus.traveli.R
import dagger.hilt.android.AndroidEntryPoint
import main.ApplicationClass
import util.Constant
import javax.inject.Inject

@AndroidEntryPoint
open class ThemeAwareActivity : AppCompatActivity() {
    @Inject
    lateinit var app: ApplicationClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(getCurrentThemeId())
        AppCompatDelegate.setDefaultNightMode(if (app.themeManager.themeIsDark) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //            window.navigationBarColor = ContextCompat.getColor(baseContext, if (themeManager.themeIsDark) R.color.md_black_1000 else R.color.md_white_1000)
        //        }
        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                windowInsetsController?.let {
                    it.hide(android.view.WindowInsets.Type.statusBars())
                    it.hide(WindowInsets.Type.navigationBars())
                }
            } else {
                systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }





        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.navigationBarDividerColor = ContextCompat.getColor(baseContext, if (app.themeManager.themeIsDark) R.color.md_white_1000 else R.color.md_black_1000)
        }
    }

    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        if (this::app.isInitialized)
            theme.applyStyle(getCurrentThemeId(), true)
        return theme
    }

    private fun getCurrentThemeId(): Int {
        //todo
        return when (app.themeManager.currentTheme) {
            Constant.Themes.LIGHT_PINK -> R.style.AppTheme_Light_Pink
            Constant.Themes.DARK_BLUE  -> R.style.AppTheme_Dark_Blue
            else                       -> R.style.AppTheme_Light_Pink
        }
    }
}