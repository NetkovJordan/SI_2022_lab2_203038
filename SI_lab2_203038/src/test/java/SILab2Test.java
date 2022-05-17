import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<String> createList(String... strings){
        return new ArrayList<>(Arrays.asList(strings));
    }

    @BeforeAll
    static void globalCheck() {
        System.out.println("Running before test to check if everything is okay");
    }
@AfterAll
static void globalEnd(){
        System.out.println("Testing complete");
}
    @Test
    void everyStatementAndEveryBranchThreeTestCases(){ //first three equal test cases for every branch and statement methods
        RuntimeException ex = null;
        ex = assertThrows(RuntimeException.class, ()-> SILab2.function(createList()));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));
        System.out.println("First test throws exception if list length is 0 or less");
        ex = assertThrows(RuntimeException.class, ()-> SILab2.function(createList("0","#","#")));
        System.out.println("Second test throws exception if list length is not a perfect square");
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));
        assertEquals(createList("0","0","0","0","0","0","0","0","0"),SILab2.function(createList("0","0","0","0","0","0","0","0","0")));
    }
    @Test
    void everyStatementFourthTestCase(){
        assertEquals(createList("1","#","2","1","2","#","#","2","#"),SILab2.function(createList("0","#","0","0","0","#","#","0","#")));
    }
    @Test
    void everyBranchFourthTestCase(){
        assertEquals(createList("1","0","1","#","3","#","2","#","#"),SILab2.function(createList("0","0","0","#","0","#","0","#","#")));
    }

}