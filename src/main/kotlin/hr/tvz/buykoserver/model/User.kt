package hr.tvz.buykoserver.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

//TODO: add 2 methods

@Entity
@Table(name = "users")
class User(

    @Column(name = "username", nullable = false)
    var username: String = "",

    @Column(name = "first_name", nullable = false)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false)
    var lastName: String = "",

    @Column(name = "email", nullable = false)
    var email: String = "",

    @Column(name = "profile_picture", nullable = true)
    var profilePicture: String = "",

    @Column(name = "pass", nullable = false)
    var password: String= "",

    @Column(name = "phone_number", nullable = false)
    var phoneNumber: String = "",

    @Column(name = "balance_eur", nullable = false)
    var balanceEur: Double = 0.0,

    @JsonIgnore
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "posts_users",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")]
    )
    var posts: MutableList<Post> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

)