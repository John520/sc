package com.john.sc.easymock.test;

import com.john.sc.easymock.ifc.Collaborator;
import com.john.sc.easymock.service.ClassUnderTest;
import org.easymock.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
@RunWith(EasyMockRunner.class)
public class TestClassUnderTest {
    @TestSubject
    private ClassUnderTest classUnderTest = new ClassUnderTest(); // 2

    @Mock
    private Collaborator mock; // 1

    @Rule
    public EasyMockRule mocks = new EasyMockRule(this);
    @Before
    public void setup(){
        Collaborator mock = EasyMock.mock(Collaborator.class);
        EasyMock.expect(mock.documentRemoved("msg")).andReturn("hahh");
        classUnderTest.setListener(mock);
    }

    @Test
    public void testRemoveNonExistingDocument() {
        Collaborator mock = EasyMock.mock(Collaborator.class);
        EasyMock.expect(mock.documentRemoved("msg")).andReturn("hahh");
        classUnderTest.setListener(mock);
        // 2 (we do not expect anything)
        replay(mock); // 3
        System.out.println(classUnderTest.removeDocument("msg"));
        EasyMock.verify(mock);
    }
}
