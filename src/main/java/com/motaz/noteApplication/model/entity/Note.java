package com.motaz.noteApplication.model.entity;

import com.motaz.noteApplication.model.dto.NoteDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "title_ar")
    private String titleAr;

    @Column(name = "content")
    private String content;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public NoteDto toDto() {
        return new NoteDto(
                this.id,
                this.titleEn,
                this.titleAr,
                this.content,
                this.creationDate
        );




        public Note toEntity(NoteDto dto) {

            Note note = new Note();

            note.setId(toDto().getId());
            note.setTitleEn(toDto().getTitleEn());
            note.setTitleAr(toDto().getTitleAr());
            note.setContent(toDto().getContent());
            note.setCreationDate(toDto().getCreationDate());

            return note.toDto();
        }

    }
}

