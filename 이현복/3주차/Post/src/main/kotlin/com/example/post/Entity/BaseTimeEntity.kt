package com.example.post.Entity

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
// abstract class는 abstract class를 여러 클래스에서 공통으로 쓰는 프로퍼티와 메서드를 모아놓는 용도
// 출처 : https://kotlinworld.com/226
abstract class BaseTimeEntity {
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime? = null

    @CreationTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}