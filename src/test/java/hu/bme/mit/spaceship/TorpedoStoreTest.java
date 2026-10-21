package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach
    public void init() {
        store = new TorpedoStore(10);
    }

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void testTorpedoStore_Init() {
        assertEquals(10, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void testTorpedoStore_Fire() {
        boolean result = store.fire(1);
        assertTrue(result);
        assertEquals(9, store.getTorpedoCount());
    }

    @Test
    void testTorpedoStore_IsEmpty() {
        boolean result = store.fire(10);
        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void testTorpedoStore_FireWithException() {
        // Ellenőrizzük, hogy túl sok torpedó kérése esetén kivételt dob-e a megvalósítás
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(15);
        });
    }
}