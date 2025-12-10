package pl.beaution.beaution_manager_server

import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class Customer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
        @Column(name = "firstname", nullable = false, length = 100) val firstName: String = "",
        @Column(name = "lastname", nullable = false, length = 100) val lastName: String = ""
)
