package org.max.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class TriangleTest {

    private static final Logger logger
            = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void testWithoutMock() throws NotTriangleException {
        //given
        Triangle triangle = new Triangle();
        //when
        //then
        Assertions.assertEquals(6,triangle.square(3,4,5));
        Assertions.assertThrows(NotTriangleException.class, () -> triangle.square(0,4,5));
        Assertions.assertThrows(NotTriangleException.class, () -> triangle.square(2,-2,5));
        Assertions.assertThrows(NotTriangleException.class, () -> triangle.square(2,4,100));
    }

    @Mock
    Triangle triangleMock = new Triangle();

    @Test
    void testMockWhen() {
        //given
        Mockito.when(triangleMock.getSquare(anyInt(),anyInt(),anyInt())).thenReturn(100d);
        //when
        //then
        Assertions.assertEquals(100d, triangleMock.getSquare(100,100,100));
        Assertions.assertEquals(100d, triangleMock.getSquare(2,4,100));
        Assertions.assertEquals(100d, triangleMock.getSquare(0,-2,5));

        Mockito.verify(triangleMock, times(3)).getSquare(anyInt(),anyInt(),anyInt());
        Mockito.verifyNoMoreInteractions(triangleMock);
    }

    @Test
    void testMockThrow() throws NotTriangleException {
        //given
        Mockito.doThrow(NotTriangleException.class).when(triangleMock).square(anyInt(),anyInt(),anyInt());
        //when
        //then
       Assertions.assertThrows(NotTriangleException.class, () -> triangleMock.square(0,4,5));

    }

    @Test
    void testMockAnswer(){
        //given
        Mockito.doAnswer(invocation -> {
            double result = (Integer)invocation.getArgument(0) *
                    (Integer)invocation.getArgument(1) *
                    (Integer)invocation.getArgument(2);
            return result;
        }).when(triangleMock).getSquare(3,4,5);
        //when
        //then
        Assertions.assertEquals(60, triangleMock.getSquare(3,4,5));
    }
}
