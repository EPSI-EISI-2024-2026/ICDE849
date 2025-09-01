package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator JUnit 5 Tests")
class CalculatorTest {

    @Test
    @Tag("fast")
    void testAdd() {
        assertEquals(5, Calculator.add(2,3));
    }

 /*    @ParameterizedTest
    @ValueSource(ints = {0,1,5,10})
    @Tag("fast")
    void testAddParam(int x) {
        assertEquals(x + x, Calculator.add(x,x));
    }
 */
/*     @ParameterizedTest
    @CsvSource({
            "1,2,0",
            "9,3,3",
            "10,5,2"
    })
    @Tag("fast")
    void testDivIntCsv(int a, int b, int expected) {
        assertEquals(expected, Calculator.divInt(a,b));
    } */

    @Test
    void testDivisionParZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.divInt(10,0));
    }

  /*   @Test
    void testAvecTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // quick operation under 100ms
            for (int i=0;i<10000;i++) Math.sqrt(i);
        });
    } */

    @Disabled("À implémenter plus tard")
    @Test
    void testNonImplemente() {
        // TODO
    }

/*     @Nested
    @DisplayName("Division réelle")
    class RealDivision {
        @Test
        void testDivReal() {
            assertAll(
                    () -> assertEquals(0.5, Calculator.divReal(1,2), 1e-9),
                    () -> assertEquals(2.0, Calculator.divReal(10,5), 1e-9)
            );
        }
    } */
}
