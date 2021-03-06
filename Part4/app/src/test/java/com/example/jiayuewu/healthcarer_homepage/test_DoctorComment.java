package com.example.jiayuewu.healthcarer_homepage;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_DoctorComment {

    @Test
    /* This test will check if a doctor comment is created correctly. */
    public void test_createComment() {
        Doctor_Comment testDoctorComment = new Doctor_Comment();
        Calendar currentTime = Calendar.getInstance();

        testDoctorComment.setName("FinalTest");
        testDoctorComment.setComment("Please");
        testDoctorComment.setTitle("GERGREEG");
        testDoctorComment.setDate(currentTime);

        // Make sure created doctor object has values in correct positions.
        assertEquals("FinalTest", testDoctorComment.getName());
        assertEquals("Please", testDoctorComment.getComment());
        assertEquals("GERGREEG", testDoctorComment.getTitle());
        assertEquals(currentTime, testDoctorComment.getDate());
    }

    @Test
    /* This test will check if a doctor comment is created correctly. */
    public void test_createCommentConstuctor() {
        Calendar currentTime = Calendar.getInstance();
        Doctor_Comment testDoctorComment = new Doctor_Comment(123 , 123 ,"GERGREEG", "FinalTest"
                , currentTime, "Please");

        assertEquals("FinalTest", testDoctorComment.getName());
        assertEquals("Please", testDoctorComment.getComment());
        assertEquals("GERGREEG", testDoctorComment.getTitle());
        assertEquals(currentTime, testDoctorComment.getDate());
    }

    @Test
    /* Testing is to make sure that a title less than or equal to 30 characters is permissible*/
    public void test_titleLengthMinimum() {
        Doctor_Comment testDoctorComment = new Doctor_Comment();
        String failString = new String();

        for (Integer i = 0; i < 31; i++) {
            failString += "E";
        }

        // Idea here is to test setting a below the minimum required characters. (This should throw
        // an exception. The try statement is because Junit3 doesn't assertNotException (Junit4 can))
        testDoctorComment.setTitle(failString);


        assertEquals("", testDoctorComment.getTitle());

        Calendar currentTime = Calendar.getInstance();
        Doctor_Comment testDoctorComment2 = new Doctor_Comment(123, 123 ,"GERGREEG", "FinalTest"
                , currentTime, "Plase");

        // Test to make sure that the created doctorComment object has a title less than 30 chars.
        assertTrue(testDoctorComment2.getTitle().length() <= 30);

    }

    @Test
    /* Test to make sure that a doctor_comment cannot be longer than 300 characters*/
    public void test_commentLengthMaximum() {
        Doctor_Comment testDoctorComment = new Doctor_Comment();
        String failString = new String();

        for (Integer i = 0; i < 301; i++) {
            failString += "D";
        }

        testDoctorComment.setComment(failString);

        // If comment is longer than 300 characters, this test should be True.
        assertEquals("", testDoctorComment.getComment());

        Calendar currentTime = Calendar.getInstance();
        Doctor_Comment testDoctorComment2 = new Doctor_Comment(213 , 123 , "GERGREEG", "FinalTest"
                , currentTime, "Plase");

        // Test to make sure that the doctor object has a character length below 300.
        assertTrue(testDoctorComment2.getTitle().length() <= 300);

    }
}
