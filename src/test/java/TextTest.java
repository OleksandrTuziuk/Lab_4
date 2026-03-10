import static org.junit.jupiter.api.Assertions.*;

class TextTest {
    @org.junit.jupiter.api.Test
    public void sortTest() {
        Text text = new Text("A calm captain navigated across a vast ocean, while sailors repaired sails and prepared supplies. Another adventurous mariner analyzed maps carefully, awaiting a favorable wind and a safe arrival.");
        assertEquals("while supplies wind A calm across a vast ocean sailors repaired sails and prepared Another adventurous mariner maps carefully a and a safe captain navigated analyzed awaiting favorable arrival.", text.sort('a').toString());
    }
}