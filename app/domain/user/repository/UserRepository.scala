package domain.user.repository

import domain.BaseRepository
import domain.user.value_obj.User

import scala.concurrent.Future

trait UserRepository extends BaseRepository[User] {

  def findByUsername(username: String): Future[Option[User]]

  def changeRole(user: User): Future[Unit]

}