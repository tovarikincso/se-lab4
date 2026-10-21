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
        // Túl sok torpedó kérése esetén IllegalArgumentException-t kell dobnia
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(15);
        });
    }

    @Test
    void testTorpedoStore_FailureRate() {
        // 100%-os hibaráta esetén a tüzelésnek fel kell mondania a szolgálatot
        TorpedoStore faultyStore = new TorpedoStore(10, 1.0);
        boolean result = faultyStore.fire(1);
        
        assertFalse(result);
        assertEquals(10, faultyStore.getTorpedoCount());
    }
}