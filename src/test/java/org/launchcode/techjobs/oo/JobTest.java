package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

    Job job;
    Job job1;
    Job job2;

    @Test
    public void testSettingJobId(){
         job1 = new Job();
         job2 = new Job();
       Assert.assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
      job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName().equals("Product tester"));
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        job1 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
      // Assert.assertNotEquals(job1, job2);
        //   assertEquals(job1.equals(job2),false);
    }

   @Test
    public void testToStringStartsAndEndsWithNewLine(){
        job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.toString().startsWith(System.lineSeparator()));
        assertTrue(job.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job.toString(), System.lineSeparator()+"ID: "+job.getId()+ "\nName: "+job.getName()+"\nEmployer: "+job.getEmployer().getValue()+"\nLocation: "+job.getLocation().getValue()+"\nPosition Type: "+job.getPositionType().getValue()+"\nCore Competency: "+job.getCoreCompetency().getValue()+System.lineSeparator());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        assertEquals(job.toString(), System.lineSeparator()+"ID: "+job.getId()+ "\nName: "
                +job.getName()+"\nEmployer: Data not available"+
                "\nLocation: "+job.getLocation().getValue()+"\nPosition Type: Data not available"+"\nCore Competency: "
                +job.getCoreCompetency().getValue()+System.lineSeparator());
    }

    @Test
    public void testToStingHanldesOnlyIdField(){
        job = new Job();

        assertEquals(job.toString(), "OOPS! This job does not seem to exist.");
    }

}
