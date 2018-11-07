package ru.geekbrains.cloud.storage.persistance.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = StoredFile.TABLE_NAME)
public class StoredFile implements OrmEntity<Long> {

    static final String TABLE_NAME = "stored_files";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", unique = true, nullable = false)
    private String fileName;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

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

    public StoredFile(Long id, String fileName, Date createDate, Date updateDate) {
        this.id = id;
        this.fileName = fileName;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public StoredFile setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public StoredFile setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
