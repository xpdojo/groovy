package recursion

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class HanoisTowerTest {

    /**
     * By GitHub Copilot
     */
    class HanoisTower {
        def solve(int n, String from, String to, String buffer) {
            if (n == 1) {
                return ["${from} -> ${to}"]
            }
            def moves = solve(n - 1, from, buffer, to)
            moves << "${from} -> ${to}"
            moves + solve(n - 1, buffer, to, from)
        }
    }

    @Test
    void "should solve hanois tower"() {
        given:
        def hanoisTower = new HanoisTower()

        when:
        def moves = hanoisTower.solve(3, 'A', 'B', 'C')

        then:
        moves.size() == 7
        assertEquals(moves[0].toString(), "A -> B")
        assertEquals(moves.get(1).toString(), "A -> C")
        assertEquals(moves.get(2).toString(), "B -> C")
        assertEquals(moves.get(3).toString(), "A -> B")
        assertEquals(moves.get(4).toString(), "C -> A")
        assertEquals(moves.get(5).toString(), "C -> B")
        assertEquals(moves.get(6).toString(), "A -> B")
    }

}
