package data.remote.dto


import com.google.gson.annotations.SerializedName
import data.remote.dto.TravelPreviewDto.Companion.carabianSeeImage
import kotlin.random.Random

data class TravelDto(
    val id: Long,
    val name: String,
    val cover: String,
    val country: CountryDto,
    val price: Long,
    @SerializedName("contents")
    var details: List<TravelItemDto>,
    @SerializedName("cities")
    val cityList: List<CityDto>,
    @SerializedName("tags")
    val tagList: List<TagDto>,
    val user: UserPreviewDto,
    @SerializedName("is_bookmarked")
    val isBookmarked: Boolean,
    @SerializedName("is_owned")
    val isOwned: Boolean
) {
    companion object {
        fun getFake() = TravelDto(
            Random.nextLong(1000), "Caribbean Sea", carabianSeeImage, CountryDto(0, "Iran", "", ""), 0, TravelItemDto.getFakes(), CityDto.getFakes(), listOf(TagDto(0L, "tehran"), TagDto(0L, "tehran"), TagDto(0L, "tehran"), TagDto(0L, "tehran")), UserPreviewDto.getFake(), false, false,
        )


        fun getFake(size: Int = 10): ArrayList<TravelDto> {
            val list = arrayListOf<TravelDto>()
            repeat(size) {
                list.add(getFake())
            }
            return list
        }

        fun getFakeForCreate() = TravelDto(
            Random.nextLong(1000), "Caribbean Sea", carabianSeeImage, CountryDto(0, "Iran", "", ""), 0, TravelItemDto.getFakes(), CityDto.getFakes(), listOf(TagDto(0L, "tehran"), TagDto(0L, "tehran"), TagDto(0L, "tehran"), TagDto(0L, "tehran")), UserPreviewDto.getFake(), false, false,
        )
    }

}
