package domain.auth.repository

import domain.AggregateRepository
import domain.auth.entity.Role

import scala.concurrent.Future

/** ๆ้ไปๅจ
 */
trait RoleRepository extends AggregateRepository[Role] {

  def getByUser(userId: Long): Future[Option[Role]]
}
