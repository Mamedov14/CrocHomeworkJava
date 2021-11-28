package departments;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void getServiceTime_defaultTest() {
        A a = new A(1, Arrays.asList(
                /*B1*/
                new B(3, Arrays.asList(
                        /*C11*/
                        new C(1, null),
                        /*C12*/
                        new C(1, null))
                ),
                /*B2*/
                new B(1, List.of(
                        /*C21*/
                        new C(4, null))
                ),
                /*B3*/
                new B(2, List.of(
                        /*C31*/
                        new C(1, List.of(
                                new D(1, null))
                        ))
                ))
        );
        assertEquals(6, a.getServiceTime());
    }

    @Test
    void getServiceTime_defaultTest2() {
        A a = new A(1, Arrays.asList(
                /*B1*/
                new B(3, Arrays.asList(
                        /*C11*/
                        new C(110, null),
                        /*C12*/
                        new C(110, null))
                ),
                /*B2*/
                new B(1, List.of(
                        /*C21*/
                        new C(400, null))
                ),
                /*B3*/
                new B(2, List.of(
                        /*C31*/
                        new C(11, List.of(
                                new D(1, null),
                                new D(2, null),
                                new D(3, null),
                                new D(4, null),
                                new D(5, null),
                                new D(6, null),
                                new D(7, null),
                                new D(8, null),
                                new D(9, null),
                                new D(10, null))
                        ))
                ))
        );
        assertEquals(402, a.getServiceTime());
    }

}