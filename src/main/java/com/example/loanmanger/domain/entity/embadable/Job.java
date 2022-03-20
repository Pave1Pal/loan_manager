package com.example.loanmanger.domain.entity.embadable;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Job {

    @Column(name = "job_start")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start;

    @Column(name = "job_finish")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate finish;

    @Column(name = "job_organization")
    private String organization;

    @Column(name = "job_position")
    private String position;

    @Column(name = "job_is_work")
    private boolean work;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate startDate) {
        this.start = startDate;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finishDate) {
        this.finish = finishDate;
    }
}
