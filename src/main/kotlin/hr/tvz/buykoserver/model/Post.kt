package hr.tvz.buykoserver.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "posts")
class Post (

    @Column (name = "title", nullable = false)
    val title: String,

    @Column (name = "description", nullable = false)
    val description: String,

    @Column (name = "price", nullable = false)
    val price: Double,

    @Column (name = "category", nullable = false)
    val category: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinTable(name = "post_user",
        joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")]
    )
    var user: User,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int

)