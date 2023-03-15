package lang

import android.graphics.Typeface

interface LanguageInterface {
    val fontLight: Typeface?
    val fontMedium: Typeface?
    val fontBold: Typeface?
    val locale: String
    val appName: String
    val openUrl: String
    val nothingToShow: String
    val checkConnectionAndTryAgain: String
    val retry: String
    val id: String
    val albumId: String
    val title: String
    val languageUpdated: String
    val somethingWentWrong: String
    val pressBackAgainToExit: String
    val loading: String
    val download: String
    val price: String
    val searchCity: String
    val selectTag: String
    val publish: String
    val next: String
    val addPreview: String
    val yes: String
    val no: String
    val search: String
    val trending: String
    val countries: String
    val cities: String
    val new: String
    val travel: String
    val user: String
    val travelTo: String
    val tags: String

    //navigation
    val home: String

    //Profile
    val confirm: String
    val cancel: String
    val noTravels: String
    val fromTraveli: String
    val travels: String
    val stats: String
    val contact: String
    val add: String
    val phoneNumber: String
    val emailAddress: String
    val twitterUsername: String
    val instagramUsername: String
    val websiteUrl: String
    val crop: String
    val pleaseLoginToDoThisAction: String
    val fileIsInvalid: String
    val drafts: String

    //Profile Edit
    val name: String
    val hometown: String
    val bio: String
    val logout: String
    val deleteAccount: String
    val logoutDesc: String
    val deleteAccountDesc: String

    //Transaction
    val balance: String
    val checkout: String
    val yourTransactionDetailWillBeHere: String
    val confirmCheckout: String
    val confirmCheckoutDesc1: String
    val confirmCheckoutDesc2: String
    val checkoutComplete: String
    val chargeAccount: String
    val customAmount: String
    val priceCannotBeLowerThanX1: String
    val priceCannotBeLowerThanX2: String
    val priceCannotBeHigherThanX1: String
    val priceCannotBeHigherThanX2: String

    //selectCountry
    val searchCountry: String

    //addTravel
    val image: String
    val video: String
    val description: String
    val link: String
    val addSomeThing: String
    val enterLink: String
    val linkError: String
    val pleaseEnterThePrice: String
    val payed: String
    val uploadFailed: String
    val doYouWannaDeleteThisItem: String
    val deleteItem: String
    val someFilesAreBeingUploadedPleaseWait: String

    // Favorite
    val owned: String
    val marked: String

    // Common
    val skip: String
    val seeAll: String

    // OnBoarding
    val firstSlideTitle1: String
    val firstSlideTitle2: String
    val firstSlideDescription: String
    val secondSlideTitle1: String
    val secondSlideTitle2: String
    val secondSlideDescription: String
    val thirdSlideTitle1: String
    val thirdSlideTitle2: String
    val thirdSlideDescription: String
    val forthSlideTitle1: String
    val forthSlideTitle2: String
    val continueToApp: String

    //Travels screen
    val mostPopular: String
    val whatOthersHaveEnjoyed: String
    val topGuides: String
    val justArrived: String
    val theLatestExperiencesOutThere: String

    //  profile
    val guides: String

    // destinations
    val destinations: String

    //Auth
    val enterYourEmail: String
    val email: String
    val `continue`: String
    val or: String
    val hiThere: String
    val getEmailHint: String
    val continueWithGoogle: String
    val password: String
    val enterYourPassword: String
    val forgotPassword: String
    val changeEmail: String
    val awesome: String
    val getPasswordDescription: String

    fun priceCannotBeLowerThanX(value: String) = "$priceCannotBeLowerThanX1 $value $priceCannotBeLowerThanX2"
    fun priceCannotBeHigherThanX(value: String) = "$priceCannotBeHigherThanX1 $value $priceCannotBeHigherThanX2"
    fun confirmCheckoutDesc(value: String) = "$confirmCheckoutDesc1 $value $confirmCheckoutDesc2"
    fun paramString(param: String) = "$appName $param"
}