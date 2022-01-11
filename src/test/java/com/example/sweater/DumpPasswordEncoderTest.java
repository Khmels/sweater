package com.example.sweater;

import com.example.sweater.service.DumpPasswordEncoder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class DumpPasswordEncoderTest {
    @Test
    public void encode() {
        DumpPasswordEncoder encoder = new DumpPasswordEncoder();
        Assert.assertEquals("secret: 'myPwd'", encoder.encode("myPwd"));
        Assert.assertThat(encoder.encode("myPwd"), Matchers.containsString("myPwd"));
        assertThat(encoder.encode("myPwd"), Matchers.allOf(Matchers.startsWith("s"), Matchers.endsWith("Pwd'")));
    }
}