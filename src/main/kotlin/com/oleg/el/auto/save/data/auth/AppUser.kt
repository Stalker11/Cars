package com.oleg.el.auto.save.data.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections
import javax.persistence.*

//https://www.youtube.com/watch?v=QwQuro7ekvc
@Entity
//@Table(name = "app_user")
data class AppUser(
    @Id
    /*@SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )*/
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        //generator = "user_sequence"
    )
    private var id: Long? = -1,
    private var name: String = "",
    private var userName: String = "",
    private var email: String = "",
    private var password: String = "",
    @Enumerated(EnumType.STRING)
    private var role: AppUserRole,
    private var accountLocked: Boolean = false,
    private var enabled: Boolean = false
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authority = SimpleGrantedAuthority(role.name)
        return Collections.singletonList(authority)
    }

    override fun getPassword() = password

    override fun getUsername() = email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = !accountLocked

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = enabled

}