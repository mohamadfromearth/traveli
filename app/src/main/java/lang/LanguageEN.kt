package lang

import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.xodus.traveli.R
import main.ApplicationClass

class LanguageEN(private val app: ApplicationClass) : LanguageInterface {
    override val fontLight: Typeface? get() = ResourcesCompat.getFont(app, R.font.sf_pro_text_light)
    override val fontMedium: Typeface? get() = ResourcesCompat.getFont(app, R.font.sf_pro_text_medium)
    override val fontBold: Typeface? get() = ResourcesCompat.getFont(app, R.font.sf_pro_text_bold)
    override val locale = "EN"
    override val appName = "Template Five"
    override val openUrl = "Open URL"
    override val nothingToShow = "Nothing To Show!"
    override val checkConnectionAndTryAgain = "Please check your internet connection and try again."
    override val retry = "Retry"
    override val id = "ID"
    override val albumId = "Album ID"
    override val title = "Title"
    override val languageUpdated = "Language Updated"
    override val somethingWentWrong = "Something Went Wrong"
    override val pressBackAgainToExit = "Press back again to exit"
    override val loading = "Loading..."
    override val download = "Download"
    override val price: String = "Price"
    override val searchCity: String = "Search city"
    override val selectTag: String = "Select tag"
    override val publish: String = "Publish"
    override val next: String = "Next"
    override val addPreview: String = "Add preview"
    override val yes: String = "Yes"
    override val no: String = "No"
    override val search: String = "Search"
    override val trending: String = "Trending"
    override val countries: String = "Countries"
    override val cities: String = "Cities"
    override val home: String = "Home"
    override val new: String = "New"
    override val travel: String = "Travel"
    override val user: String = "User"
    override val travelTo: String = "Travel to"
    override val tags: String = "Tags"
    override val owned: String = "Owned"
    override val marked: String = "Marked"

    //Profile
    override val confirm: String = "Confirm"
    override val cancel: String = "Cancel"
    override val noTravels: String = "No Travels"
    override val fromTraveli: String = "From Traveli"
    override val travels: String = "Travels"
    override val stats: String = "Stats"
    override val contact: String = "Contact"
    override val add: String = "Add"
    override val phoneNumber: String = "Phone Number"
    override val emailAddress: String = "Email Address"
    override val twitterUsername: String = "Twitter Username"
    override val instagramUsername: String = "Instagram Username"
    override val websiteUrl: String = "Website Url"
    override val crop: String = "Crop"
    override val pleaseLoginToDoThisAction: String = "Please login to do this action."
    override val fileIsInvalid: String = "File is invalid."
    override val drafts: String = "Drafts"

    //Profile Edit
    override val name: String = "Name"
    override val hometown: String = "Hometown"
    override val bio: String = "Bio"
    override val logout: String = "Logout"
    override val deleteAccount: String = "Delete account"
    override val logoutDesc: String = "Are you sure you want to logout?"
    override val deleteAccountDesc: String = "Are you sure you want to delete your account permanently?\nAll your data will be lost.\nThis action cannot be undone."

    //Transaction
    override val balance: String = "Balance"
    override val checkout: String = "Checkout"
    override val yourTransactionDetailWillBeHere: String = "Your transactions' details will be here"
    override val confirmCheckout: String = "Confirm checkout"
    override val confirmCheckoutDesc1: String = "Are you sure you want to checkout"
    override val confirmCheckoutDesc2: String = "to your account?"
    override val checkoutComplete: String = "Checkout complete!"
    override val chargeAccount: String = "Charge Account"
    override val customAmount: String = "Custom amount"
    override val priceCannotBeLowerThanX1: String = "Price cannot be lower than"
    override val priceCannotBeLowerThanX2: String = ""
    override val priceCannotBeHigherThanX1: String = "Price cannot be higher than"
    override val priceCannotBeHigherThanX2: String = ""

    //country
    override val searchCountry: String = "Search country"
    override val image: String = "Image"
    override val video: String = "Video"
    override val description: String = "Description"
    override val link: String = "Link"
    override val addSomeThing: String = "Please add something to continue"
    override val enterLink: String = "Please enter your link"
    override val linkError: String = "Invalid link"
    override val pleaseEnterThePrice: String = "Please enter the price"
    override val payed: String = "Payed"
    override val uploadFailed: String = "Upload failed"
    override val doYouWannaDeleteThisItem: String = "Do you wanna delete this item?"
    override val deleteItem: String = "Delete item"
    override val someFilesAreBeingUploadedPleaseWait: String = "Some files are being uploaded please wait"

    // common
    override val skip: String = "Skip"
    override val seeAll: String = "See All"

    // OnBoarding
    override val firstSlideTitle1: String = "Expectacular"
    override val firstSlideTitle2: String = "Experiences"
    override val firstSlideDescription: String = "It's been six days since last time I saw your face"
    override val secondSlideTitle1: String = "Expectacular"
    override val secondSlideTitle2: String = "Experiences"
    override val secondSlideDescription: String = "It's been six days since last time I saw your face"
    override val thirdSlideTitle1: String = "Expectacular"
    override val thirdSlideTitle2: String = "Experiences"
    override val thirdSlideDescription: String = "It's been six days since last time I saw your face"
    override val forthSlideTitle1: String = "Let's get"
    override val forthSlideTitle2: String = "Started"
    override val continueToApp: String = "Continue to app >"

    // Travels screen
    override val mostPopular: String = "Most popular"
    override val whatOthersHaveEnjoyed: String = "What others have enjoyed"
    override val topGuides: String = "Top Guides"
    override val justArrived: String = "Just Arrived"
    override val theLatestExperiencesOutThere: String = "The latest experiences out there"
}
