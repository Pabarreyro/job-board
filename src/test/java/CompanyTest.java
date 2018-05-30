import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompanyTest {
    @Test
    public void newCompany_instantiatesCorrectly_true() {
        Company testCompany = new Company("Test Company");
        assertEquals(true, testCompany instanceof Company);
    }

    @Test
    public void newJob_instantiatesWithTitle_true() {
        Company testCompany = new Company("Test Company");
        assertEquals("Test Company", testCompany.getName());
    }

    @Test
    public void getId_companyInstantiateWithAnID_1() throws Exception{
        Company.clearAll();
        Company oneCompany = new Company("School: Epicodus");
        assertEquals(1, oneCompany.getId());
    }

    @Test
    public void findById_findReturnsCorrectCompany() throws Exception {
        Company company = setupNewCompany();
        assertEquals(1, Company.findById(company.getId()).getId());
    }

    @Test
    public void setOpenings_addsJobToCompany_1() {
        Company company = setupNewCompany();
        Job jobToAdd = new Job("Test Job", new ArrayList<>(), new Company("test company"), 60);
        company.setOpenings(jobToAdd);
        assertEquals(1, company.getOpenings().size());
    }

    private Company setupNewCompany() {
        return new Company("School: Epicodus");
    }



}