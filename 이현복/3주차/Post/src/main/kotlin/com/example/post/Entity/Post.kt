package com.example.post.Entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
class Post (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false)
        var title : String? = null,

        @Column(nullable = false)
        var content: String? = null,

        @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL])
        val comments: MutableList<Comment> = mutableListOf()

) : BaseTimeEntity() {
}