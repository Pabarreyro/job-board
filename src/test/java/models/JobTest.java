package models;

import models.Company;
import models.Job;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void newJob_instantiatesCorrectly_true() {
        Job testJob = setupNewJob();
        assertEquals(true, testJob instanceof Job);
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Job oneJob = setupNewJob();
        assertEquals(false, oneJob.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Job oneJob = setupNewJob();
        assertEquals(LocalDateTime.now().getDayOfWeek(), oneJob.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void newJob_instantiatesWithTitle_true() {
        Job testJob = setupNewJob();
        assertEquals("Chemistry: Teacher", testJob.getTitle());
    }

    @Test
    public void setCompany_addsCompanyObject_company() {
        Job testJob = setupNewJob();
        Company newCompany = new Company("Test Company");
        testJob.setCompany(newCompany);
        assertEquals(newCompany, testJob.getCompany());
    }

    @Test
    public void setDescription_addsJobDescriptionCorrectly_description() {
        Job testJob = setupNewJob();
        testJob.setDescription("test Description");
        assertEquals("test Description", testJob.getDescription());
    }

    @Test
    public void setQualification_addsJobQualificationCorrectly_qualification() {
        Job testJob = setupNewJob();
        testJob.setQualifications("test Qualification");
        assertEquals("test Qualification", testJob.getQualifications().get(0));
    }

    @Test
    public void setSalary_addsSalaryCorrectly_60() {
        Job testJob = setupNewJob();
        testJob.setSalary(60);
        assertEquals(60, testJob.getSalary());
    }

    @Test
    public void getAll_returnsAllJobInstances_2() {
        Job testJob = setupNewJob();
        Job testJob2 = new Job("Test Job 2", new ArrayList<>(), new Company("test company"), 50);
        assertEquals(2, Job.getAll().size());
    }

    @Test
    public void clearAll_deletesAllJobInstances_0() {
        Job testJob = setupNewJob();
        Job testJob2 = new Job("Test Job 2", new ArrayList<>(), new Company("test company"), 50);
        Job.clearAll();
        assertEquals(0, Job.getAll().size());
    }

    @Test
    public void getId_jobInstantiateWithAnID_1() throws Exception{
        Job.clearAll();
        Job oneJob = setupNewJob();
        assertEquals(1, oneJob.getId());
    }

    @Test
    public void findById_findReturnsCorrectJob() throws Exception {
        Job.clearAll();
        Job job = setupNewJob();
        assertEquals(1, Job.findById(job.getId()).getId());
    }

    private Job setupNewJob() {
        return new Job("Chemistry: Teacher", new ArrayList<>(), new Company("Epicodus"), 60);
    }

    @Test
    public void name() {
    }
}