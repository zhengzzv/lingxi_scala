package interfaces.dto

import domain.user.entity.User
import infra.db.po.UserPo
import play.api.libs.json.{Json, OFormat}

import java.time.LocalDateTime
import scala.language.implicitConversions

case class UserDto(
  id: Long,
  username: String,
  password: String,
  avatar: String,
  nickName: String,
  phone: String,
  email: String,
  role: Option[RoleDto] = None,
  createBy: Long = 0L,
  updateBy: Long = 0L,
  createAt: LocalDateTime = LocalDateTime.now(),
  updateAt: LocalDateTime = LocalDateTime.now()
)

object UserDto {

  implicit val format: OFormat[UserDto] = Json.format[UserDto]

  implicit def fromDo(user: User): UserDto =
    UserDto(
      user.id,
      user.username,
      "",
      user.avatar,
      user.nickName,
      user.phone,
      user.email,
      user.role,
      user.createBy,
      user.updateBy,
      user.createAt,
      user.updateAt
    )

  implicit def fromPo(user: UserPo): UserDto =
    UserDto(
      user.id,
      user.username,
      "",
      user.avatar,
      user.nickName,
      user.phone,
      user.email,
      None,
      user.createBy,
      user.updateBy,
      user.createAt,
      user.updateAt
    )
}
