package hr.tvz.buykoserver.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

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

    @Column(name = "role", nullable = false)
    var role: Int = 1,

    @JsonIgnore
    @Column(name = "creation_ts", nullable = false)
    var creationTS: String = "",

    @JsonIgnore
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "posts_users",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
    )
    var posts: MutableList<Post> = mutableListOf(),

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinTable(name = "users_locations",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "location_id", referencedColumnName = "id")]
    )
    var location: Location?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long

)