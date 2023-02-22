package data.remote.dto

import com.google.gson.Gson
import domain.model.TravelItem
import domain.model.TravelItem.Companion.VIEW_TYPE_COVER
import domain.model.TravelItem.Companion.VIEW_TYPE_DESCRIPTION
import domain.model.TravelItem.Companion.VIEW_TYPE_IMAGE
import domain.model.TravelItem.Companion.VIEW_TYPE_LINK
import domain.model.TravelItem.Companion.VIEW_TYPE_VIDEO
import util.EntityMapper
import util.extension.log
import javax.inject.Inject

class TravelDetailMapper @Inject constructor(val gson: Gson) : EntityMapper<TravelItemDto, TravelItem> {

    override fun toDomainModel(dto: TravelItemDto): TravelItem {

        return when (dto.type) {
            VIEW_TYPE_COVER       -> TravelItem.Cover("", "")
            VIEW_TYPE_IMAGE       -> {
                val data = gson.fromJson(dto.data, ImageDto::class.java)
                TravelItem.Image(dto.id, data.title, data.image, data.localImage)
            }
            VIEW_TYPE_DESCRIPTION -> {
                val data = gson.fromJson(dto.data, DescriptionDto::class.java)
                TravelItem.Description(dto.id, dto.title, data.description)
            }
            VIEW_TYPE_LINK        -> {
                val data = gson.fromJson(dto.data, LinkDto::class.java)
                TravelItem.Link(dto.id, data.title, data.url)
            }
            VIEW_TYPE_VIDEO       -> {
                val data = gson.fromJson(dto.data, VideoDto::class.java)
                TravelItem.Video(dto.id, data.title, data.video, data.frame)
            }
            else                  -> {
                TravelItem.Cover("", "")
            }
        }
    }

    override fun toEntity(model: TravelItem): TravelItemDto {
        return when (model) {
            is TravelItem.Cover       -> TravelItemDto(model.id, model.viewType, model.position, model.title, gson.toJson(CoverDto(model.title, model.cover)))
            is TravelItem.Description -> {
                val data = gson.toJson(DescriptionDto(model.title, model.description))
                log("TravelDetailMapper:data:$data")
                TravelItemDto(model.id, model.viewType, model.position, model.title, data)
            }
            is TravelItem.Image       -> TravelItemDto(model.id, model.viewType, model.position, model.title, gson.toJson(ImageDto(model.title, model.imageUrl, model.localImagePath)))
            is TravelItem.Link        -> TravelItemDto(model.id, model.viewType, model.position, model.title, gson.toJson(LinkDto(model.title, model.url)))
            is TravelItem.Video       -> TravelItemDto(model.id, model.viewType, model.position, model.title, gson.toJson(VideoDto(model.title, model.video, model.image)))
            else                      -> TravelItemDto(model.id, model.viewType, model.position, "", "")

        }
    }

}





