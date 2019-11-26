package com.moodanlayser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Sad Mood");
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_WhenAnyMood_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNull_WhenProper_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNull_WhenNullWithCustomException_ShouldReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            moodAnalyser.analyserMood();
        }catch (MoodAnalyserException e){
            Assert.assertEquals("please Enter proper Mood",e.getMessage());
        }
    }

    @Test
    public void givenEmpty_WhenENTERED_EMPTY_ShouldReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
             moodAnalyser.analyserMood();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalyserException {
        MoodAnalyser realMoodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in the happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in the happy mood"), realMoodAnalyser);
    }

}
