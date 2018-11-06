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

    @Column( name = "file_data" )
    @Lob
    private byte[] fileData;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public StoredFile() {

    }

    public StoredFile(Long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
