package util

object Constant {
    //========================== P R E F E R E N C E S ==========================//
    const val PREF_LANGUAGE = "PREF_LANGUAGE"
    const val PREF_THEME = "PREF_THEME"
    const val PREF_LOG = "PREF_LOG"
    const val PREF_TOKEN = "PREF_TOKEN"

    //========================== C O N S T A N T S ==========================//
    //    const val CON_BASE_TEMPLATE_URL = "https://jsonplaceholder.typicode.com/"
    const val CON_BASE_TEMPLATE_URL = "https://traveli2.gcoapps.com"
    const val CON_PREF_NAME = "com.xodus.traveli"
    const val CON_AES_KEY = "dde717bc4fd78bbbd98ccc7d8516ba79"
    const val CON_AES_IV = "a3da2dab4e2b44d1"
    const val CON_TRANS_ID = "CON_TRANS_ID_"
    const val CON_TRANS_PHOTO = "CON_TRANS_PHOTO_"
    const val USER_INVALID_ID = -1L
    const val USER_TAB = 0
    const val TRAVEL_TAB = 1
    const val CON_PAGINATE_OFFSET = 100
    const val CON_ADAPTER_NORMAL = 1
    const val CON_ADAPTER_LOADING = 2
    const val CON_ADAPTER_FAILURE = 3
    const val CON_ADAPTER_ADD = 4
    const val CON_TRAVEL_TYPE_TRENDING = "trending"
    const val CON_TRAVEL_TYPE_NEW = "new"
    const val CON_TRAVEL_TYPE_OWNED = "owned"
    const val CON_TRAVEL_TYPE_MARKED = "marked"
    const val CON_NO_ITEM_ADDED = 3

    //======================KEYS=========================//
    const val KEY_CITY = "KEY_CITY"
    const val KEY_TAG = "KEY_TAG"


    //======================DATA BASE=========================//
    const val CON_TRAVELI_DATA_BASE_NAME = "TRAVELI_DATA_BASE"


    //AddTravel sheet item
    const val CON_ADD_TRAVEL_IMAGE = 0
    const val CON_ADD_TRAVEL_DESCRIPTION = 2
    const val CON_ADD_TRAVEL_VIDEO = 3
    const val CON_ADD_TRAVEL_LINK = 1


    //OnBoarding
    const val CON_ON_BOARDING_SLIDES_COUNT = 4


    enum class Languages(val value: String) {
        FA("FA"),
        EN("EN"),
        DEFAULT_LANGUAGE("EN"),
    }

    enum class Themes(val value: String) {
        DARK_BLUE("DARK_BLUE"),
        LIGHT_PINK("LIGHT_PINK"),
        DEFAULT_THEME("LIGHT_PINK"),
    }

    enum class ContactType {
        Phone,
        Email,
        Twitter,
        Instagram,
        Website,
    }

    enum class SetUpTravelMode {
        Add,
        Edit,
        AddPreview
    }
}