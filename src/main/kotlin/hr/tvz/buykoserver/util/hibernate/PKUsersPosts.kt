package hr.tvz.buykoserver.util.hibernate

import java.io.Serializable

data class PKUsersPosts (
    val postId: Int = 0,
    val userId: Int = 0
): Serializable