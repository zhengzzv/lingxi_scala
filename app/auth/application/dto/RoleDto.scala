package auth.application.dto

import auth.domain.Role
import play.api.libs.json.Json

import java.time.LocalDateTime
import scala.language.implicitConversions

case class RoleDto(
  id: Long,
  code: String,
  name: String,
  createBy: Long = 0L,
  updateBy: Long = 0L,
  createAt: LocalDateTime = LocalDateTime.now(),
  updateAt: LocalDateTime = LocalDateTime.now()
)

object RoleDto {

  implicit val format = Json.format[RoleDto]

  implicit def formDo(role: Role): RoleDto =
    RoleDto(role.id, role.code, role.name, role.createBy, role.updateBy, role.createAt, role.updateAt)

  implicit def fromDoOpt(roleOpt: Option[Role]): Option[RoleDto] =
    roleOpt.map(d => RoleDto.formDo(d))
}
