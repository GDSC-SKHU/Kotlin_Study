package com.example.post.Entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
class Comment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false)
        var content : String? = null,

        @ManyToOne
        @JoinColumn(name = "post_id")
        @JsonIgnore
        var post: Post? = null
) : BaseTimeEntity() {
}