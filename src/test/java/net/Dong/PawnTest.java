package net.Dong;

import net.Dong.chess.Pawn;
import net.Dong.chess.Pawn.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {



    @Test
    @DisplayName("Color Test")
    public void create() {

        verifyPawn(Color.WHITE);
        verifyPawn(Color.BALCK);

    }

    void verifyPawn(Color c) {
        Pawn p = new Pawn(c);
        assertThat(p.color()).isEqualTo(c);
    }
}

