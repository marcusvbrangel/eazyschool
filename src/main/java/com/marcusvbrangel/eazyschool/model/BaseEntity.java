package com.marcusvbrangel.eazyschool.model;

import com.marcusvbrangel.eazyschool.constants.EazySchoolEnum;

import java.time.LocalDateTime;

public class BaseEntity {

    private LocalDateTime createdAt;
    private EazySchoolEnum createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EazySchoolEnum getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(EazySchoolEnum createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
