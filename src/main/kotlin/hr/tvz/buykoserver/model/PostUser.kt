package hr.tvz.buykoserver.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Table

@Entity
@Table(name = "posts_users")
class PostUser (

    @JoinColumn(table = "users", name = "id", nullable = false)
    var userId: Int,

    @Id
    @JoinColumn (table = "posts", name = "id", nullable = false)
    var postId: Int,

) {

}