package hr.tvz.buykoserver.model

import javax.persistence.*

@Entity
@Table(name = "posts")
class Post (

    @Column (name = "title", nullable = false)
    var title: String = "",

    @Column (name = "description", nullable = false)
    var description: String = "",

    @Column (name = "price", nullable = false)
    var price: Double = 0.0,

    @Column (name = "category", nullable = false)
    var category: String = "",

    @OneToOne(cascade = [CascadeType.DETACH])
    @JoinTable(name = "posts_users",
        joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")]
    )
    var user: User,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

)