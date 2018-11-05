package ru.geekbrains.cloud.storage.persistance.entity;

import javax.persistence.*;

@Entity
@Table(name = StoredFile.TABLE_NAME)
public class StoredFile implements OrmEntity<Long> {

    static final String TABLE_NAME = "stored_files";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", unique = true, nullable = false)
    private String fileName;

    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "student_name", nullable = false)
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public StoredFile setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
