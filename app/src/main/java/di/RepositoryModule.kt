package di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.local.dao.TravelDao
import data.remote.*
import data.remote.dto.*
import data.repository.*
import domain.repository.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import main.ApplicationClass
import util.PrefManager
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideTemplateRepository(app: ApplicationClass, api: PhotoApi, photoMapper: PhotoMapper, networkErrorMapper: NetworkErrorMapper): PhotoRepository =
        PhotoRepositoryImpl(app, api, networkErrorMapper, photoMapper)

    @Provides
    @Singleton
    fun providesTraveliRepository(
        app: ApplicationClass,
        api: TravelApi,
        networkErrorMapper: NetworkErrorMapper,
        travelMapper: TravelMapper,
        travelPreviewMapper: TravelPreviewMapper,
        videoUrlMapper: VideoUrlMapper,
        tagMapper: TagMapper,
        travelDetailMapper: TravelDetailMapper,
        searchedTravelMapper: SearchedTravelsMapper,
        travelDao: TravelDao,
        gson: Gson
    ): TraveliRepository = TravelRepositoryImpl(
        api,
        app,
        networkErrorMapper,
        travelPreviewMapper,
        travelMapper,
        travelDetailMapper,
        searchedTravelMapper,
        videoUrlMapper,
        tagMapper,
        travelDao,
        gson
    )

    @Provides
    @Singleton
    fun providesUserRepository(
        app: ApplicationClass,
        prefManager: PrefManager,
        api: UserApi,
        networkErrorMapper: NetworkErrorMapper,
        userPreviewMapper: UserPreviewMapper,
        userMapper: UserMapper,
        statMapper: StatMapper,
        travelPreviewMapper: TravelPreviewMapper,
        searchedUsersMapper: SearchedUsersMapper
    ): UserRepository = UserRepositoryImpl(
        api,
        app,
        prefManager,
        networkErrorMapper,
        userPreviewMapper,
        userMapper,
        statMapper,
        travelPreviewMapper,
        searchedUsersMapper
    )

    @Provides
    @Singleton
    fun providesTransactionRepository(
        app: ApplicationClass,
        networkErrorMapper: NetworkErrorMapper,
        transactionApi: TransactionApi,
        balanceMapper: BalanceMapper,
        transactionDataMapper: TransactionDataMapper,
        chargePriceMapper: ChargePriceMapper,
    ): TransactionRepository = TransactionRepositoryImpl(
        app,
        networkErrorMapper,
        transactionApi,
        balanceMapper,
        transactionDataMapper,
        chargePriceMapper,
    )

    @Provides
    @Singleton
    fun provideMiscRepository(
        app: ApplicationClass,
        miscApi: MiscApi,
        networkErrorMapper: NetworkErrorMapper,
        countryMapper: CountryMapper,
        cityMapper: CityMapper,
        tagMapper: TagMapper
    ): MiscRepository = MiscRepositoryImpl(miscApi, app, networkErrorMapper, countryMapper, cityMapper, tagMapper)
}