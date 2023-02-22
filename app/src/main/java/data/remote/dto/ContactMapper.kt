package data.remote.dto

import com.xodus.traveli.R
import domain.model.Contact
import domain.model.ContactItem
import main.ApplicationClass
import util.Constant
import util.EntityMapper
import javax.inject.Inject

class ContactMapper @Inject constructor(val app: ApplicationClass) : EntityMapper<ContactDto, Contact> {
    override fun toDomainModel(dto: ContactDto): Contact {
        return Contact(
            ContactItem(app.m.phoneNumber, dto.phone, Constant.ContactType.Phone, 0, 0),
            ContactItem(app.m.emailAddress, dto.email, Constant.ContactType.Email, 0, 0),
            ContactItem(app.m.twitterUsername, dto.twitter, Constant.ContactType.Twitter, 0, 0),
            ContactItem(app.m.instagramUsername, dto.instagram, Constant.ContactType.Instagram, 0, 0),
            ContactItem(app.m.websiteUrl, dto.website, Constant.ContactType.Website, 0, 0),
        )
    }

    override fun toEntity(model: Contact): ContactDto =
        ContactDto(
            model.phone.value,
            model.email.value,
            model.twitter.value,
            model.instagram.value,
            model.website.value,
        )

    fun fromEntityList(dtoList: ArrayList<ContactDto>): ArrayList<Contact> =
        ArrayList(dtoList.map { toDomainModel(it) })
}