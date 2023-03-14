package util

import android.app.Activity
import android.content.res.Configuration
import com.bumptech.glide.Glide.init
import main.ApplicationClass
import java.security.AccessController.getContext
import javax.inject.Inject

class ThemeManager @Inject constructor(private val app: ApplicationClass, private val prefManager: PrefManager) {
    val themeIsDark
        get() = currentTheme.value.contains("DARK")
    val currentThemeName  = prefManager.getStringPref(Constant.PREF_THEME)
    var currentTheme = if (currentThemeName != null )Constant.Themes.valueOf( currentThemeName) else Constant.Themes.DEFAULT_THEME

    init {
        if (currentTheme == Constant.Themes.DEFAULT_THEME){
            val nightModeFlags: Int = app.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK
            when (nightModeFlags) {
                Configuration.UI_MODE_NIGHT_YES       -> currentTheme = Constant.Themes.DARK_BLUE
                Configuration.UI_MODE_NIGHT_NO        -> currentTheme = Constant.Themes.LIGHT_PINK
                Configuration.UI_MODE_NIGHT_UNDEFINED -> currentTheme = Constant.Themes.DEFAULT_THEME
            }
        }

    }

    fun changeTheme(activity: Activity, theme: Constant.Themes) {
        prefManager.setPref(Constant.PREF_THEME, theme.value)
        currentTheme = theme
        activity.recreate()
    }
}