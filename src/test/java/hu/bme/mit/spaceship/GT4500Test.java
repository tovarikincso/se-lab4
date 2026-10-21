package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }
    @Test
    void fireTorpedo_Single_PrimaryFiredLast_SecondaryEmpty_PrimaryNotEmpty() {
        // Arrange
        // Létrehozunk egy űrhajót, ahol a primary tárban 2 torpedó van, a secondary viszont üres (0)
        GT4500 customShip = new GT4500(2, 0.0, 0, 0.0);
        
        // Act
        // 1. lövés: Mivel wasPrimaryFiredLast = false, a primary tár lő.
        // Eredmény: wasPrimaryFiredLast = true lesz, primary tárban marad 1 torpedó.
        boolean firstShot = customShip.fireTorpedo(FiringMode.SINGLE);
        
        // 2. lövés: wasPrimaryFiredLast = true, így a secondary-t próbálja.
        // Mivel a secondary üres, átugrik a 61. sorra, és a primary-ből lő újra.
        boolean secondShot = customShip.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, firstShot);
        assertEquals(true, secondShot);
    }
}
