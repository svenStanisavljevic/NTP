package hr.tvz.buykoserver.model

import javax.persistence.*



@Entity
@Table (name = "locations")
class Location {

    @Column
    var country: String = ""

    @Column
    var region: String = ""

    @Column
    var city: String = ""

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

}