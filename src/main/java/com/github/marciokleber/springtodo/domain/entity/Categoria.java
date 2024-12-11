package com.github.marciokleber.springtodo.domain.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_CATEGORIA")
    @SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "SEQ_CATEGORIA")
    private Long id;

    @Column(nullable = false)
    @Comments(@Comment("CAMPO DESCRITOR DO NOME DA CATEGORIA"))
    private String nome;

    @Comments(@Comment("CAMPO DESCRITOR DA DESCRIÇÃO DA CATEGORIA"))
    private String descricao;

    @CreationTimestamp
    private LocalDateTime criado_em;
}
