package common

import play.api.mvc
import play.api.mvc.Results
import play.api.mvc.Results.{Status, _}

trait Errors {

  val code: Int

  val message: String

  val httpStatus: Status = BadRequest
}

case object NO_USER extends Errors { val code = 10000; val message = "用户不存在" }

case object LOGIN_FAILED extends Errors { val code = 10001; val message = "登录失败，请检查用户名或密码！" }

case object TOKEN_CHECK_ERROR extends Errors {
  val code = 10004; val message = "登录状态校验失败，请重新登录！"; override val httpStatus: Results.Status = Unauthorized
}

case object PERMISSION_DENIED extends Errors {
  val code = 10004; val message = "权限不足"; override val httpStatus: Results.Status = Unauthorized
}

case object USER_EXIST extends Errors { val code = 10005; val message = "用户名已存在"; override val httpStatus: mvc.Results.Status = Conflict }

case object FILE_EMPTY extends Errors { val code = 10006; val message = "上传文件为空" }

case object OLD_PWD_ERROR extends Errors { val code = 10007; val message = "旧密码错误" }

case object LOGIC_CODE_ERR extends Errors { val code = 10008; val message = "登陆验证码错误" }

case object CAN_NOT_DEL_SUPER_ADMIN extends Errors { val code = 10009; val message = "不能删除超级管理员" }

case object NO_ROLE extends Errors { val code = 10010; val message = "角色不存在" }

case object ROLE_CODE_EXIST extends Errors {
  val code = 10011; val message = "角色 code 已经存在"; override val httpStatus: Results.Status = Conflict
}
