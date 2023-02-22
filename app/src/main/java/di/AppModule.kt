package di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.xodus.traveli.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.local.TraveliDataBase
import data.remote.dto.TravelMapper
import data.remote.dto.TravelPreviewMapper
import domain.repository.*
import domain.usecase.city.GetCitiesOfCountryUseCase
import domain.usecase.city.SearchCityUseCase
import domain.usecase.country.CountryUseCases
import domain.usecase.country.GetCountryListUseCase
import domain.usecase.country.GetPopularCountryListUseCase
import domain.usecase.country.SearchCountryUseCase
import domain.usecase.photo.*
import domain.usecase.tag.CreateTagUseCase
import domain.usecase.tag.GetTagsUseCase
import domain.usecase.template.Template
import domain.usecase.template.TemplateUseCases
import domain.usecase.transaction.*
import domain.usecase.travel.*
import domain.usecase.user.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import lang.LanguageManager
import main.ApplicationClass
import util.Constant.CON_TRAVELI_DATA_BASE_NAME
import util.PrefManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplicationClass(@ApplicationContext app: Context): ApplicationClass =
        app as ApplicationClass

    @Singleton
    @Provides
    fun providePrefManager(app: ApplicationClass): PrefManager =
        PrefManager(app)

    @Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext app: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                app.preferencesDataStoreFile(BuildConfig.APPLICATION_ID)
            }
        )

    @Singleton
    @Provides
    fun provideLanguageManager(app: ApplicationClass, prefManager: PrefManager): LanguageManager =
        LanguageManager(app, prefManager)


    @Singleton
    @Provides
    fun provideTraveliDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TraveliDataBase::class.java,
            CON_TRAVELI_DATA_BASE_NAME,
        ).build()


    @Singleton
    @Provides
    fun provideTravelDao(traveliDataBase: TraveliDataBase) = traveliDataBase.getTravelDao()


    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun providePhotoUseCases(photoRepository: PhotoRepository): PhotoUseCases {
        return PhotoUseCases(
            DownloadUseCase(photoRepository),
            GetPhoto(photoRepository),
            GetPhotoList(photoRepository),
            GetClientList(photoRepository),
            GetRoomList(photoRepository),
            GetRoomUserList(photoRepository),
        )
    }

    @Singleton
    @Provides
    fun provideTemplateUseCases(photoRepository: PhotoRepository): TemplateUseCases {
        return TemplateUseCases(
            Template(photoRepository),
        )
    }

    @Singleton
    @Provides
    fun provideTravelUseCase(traveliRepository: TraveliRepository, userRepository: UserRepository, travelPreviewMapper: TravelPreviewMapper, travelMapper: TravelMapper): TravelUseCases {
        return TravelUseCases(
            GetTrendingListUseCase(traveliRepository),
            GetBannerUseCase(traveliRepository),
            GetNewTravelListUseCase(traveliRepository),
            SearchTravelsUseCase(traveliRepository),
            GetTravelDetailUseCase(traveliRepository, userRepository),
            GetSelectedTravelUseCase(traveliRepository),
            CreateTravelUseCase(traveliRepository),
            UpdateTravelUseCase(traveliRepository),
            DeleteTravelUseCase(traveliRepository),
            PublicTravelUseCase(traveliRepository),
            GetTravelSummaryUseCase(traveliRepository),
            CreateTravelItemUseCase(traveliRepository),
            UpdateTravelItemUseCase(traveliRepository),
            DeleteTravelItemUseCase(traveliRepository),
            UploadFileUseCase(traveliRepository),
            CreateLocalTravelUseCase(traveliRepository),
            CreateLocalTravelItemUseCase(traveliRepository),
            GetLocalTravelPreviewListUseCase(traveliRepository),
            GetLocalTravelItemListUseCase(traveliRepository),
            UpdateLocalTravelUseCase(traveliRepository),
            UpdateLocalTravelItemUseCase(traveliRepository),
            DeleteLocalTravelUseCase(traveliRepository),
            DeleteLocalTravelItemUseCase(traveliRepository),
            AddCitiesToTravelUseCase(traveliRepository),
            DeleteTravelCitiesUseCase(traveliRepository),
            AddTagsToTravelUseCase(traveliRepository),
            DeleteTravelTagsUseCase(traveliRepository),
            ToggleBookmarkUseCase(traveliRepository)
        )
    }

    @Singleton
    @Provides
    fun providesCountryUseCases(miscRepository: MiscRepository): CountryUseCases {
        return CountryUseCases(
            GetCountryListUseCase(miscRepository),
            GetPopularCountryListUseCase(miscRepository),
            SearchCountryUseCase(miscRepository)
        )
    }

    @Singleton
    @Provides
    fun provideUserUseCases(app: ApplicationClass, userRepository: UserRepository, prefManager: PrefManager): UserUseCases {
        return UserUseCases(
            SearchUserUseCase(userRepository),
            GetUserStatUseCase(userRepository),
            GetMeUseCase(app, userRepository, prefManager),
            GetUserUseCase(userRepository),
            GetUserTravelListUseCase(userRepository),
            UpdateUserInfoUseCase(app, userRepository, prefManager),
            UpdateCoverUseCase(app, userRepository, prefManager),
            UpdateAvatarUseCase(app, userRepository, prefManager),
            UpdateContactUseCase(app, userRepository, prefManager),
            LogoutUseCase(app, prefManager),
            DeleteAccountUseCase(app, userRepository, prefManager),
            GetDraftUseCase(userRepository),
            GetMyTravelUseCase(userRepository)
        )
    }

    @Singleton
    @Provides
    fun provideTransactionUseCases(app: ApplicationClass, transactionRepository: TransactionRepository, prefManager: PrefManager): TransactionUseCases {
        return TransactionUseCases(
            GetTransactionListUseCase(app, transactionRepository, prefManager),
            ChargeUseCase(app, transactionRepository, prefManager),
            CheckoutUseCase(app, transactionRepository, prefManager),
            GetBalanceUseCase(app, transactionRepository, prefManager),
            GetChargePriceListUseCase(app, transactionRepository),
        )
    }

    @Singleton
    @Provides
    fun provideSearchCityUseCase(miscRepository: MiscRepository): SearchCityUseCase {
        return SearchCityUseCase(miscRepository)
    }


    @Singleton
    @Provides
    fun provideGetCitiesOfCountryUseCase(miscRepository: MiscRepository) = GetCitiesOfCountryUseCase(miscRepository)

    @Singleton
    @Provides
    fun provideSearchTagUseCase(traveliRepository: TraveliRepository): GetTagsUseCase {
        return GetTagsUseCase(traveliRepository)
    }

    @Singleton
    @Provides
    fun createTagUseCase(miscRepository: MiscRepository): CreateTagUseCase {
        return CreateTagUseCase(miscRepository)
    }
}
