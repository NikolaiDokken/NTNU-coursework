import dyrehage.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testklient {
    private static Testklient instance;

    public static Rovdyrfabrikk rovFab;
    public static SkandinaviskeRovdyr[] dyr;

    @BeforeAll
    public static void setupClass() throws Exception {
        rovFab = new Rovdyrfabrikk();
        dyr = new SkandinaviskeRovdyr[4];
        dyr[0] = rovFab.nyBinne(2003, "Hakkebakkeskogen 3", "Helenebjønn", 1950, 4);
        dyr[1] = rovFab.nyHannbjorn(2010, "Nedre singsaker 19B", "Niko", 1999);
        dyr[2] = rovFab.nyUlvehann(2002, "Ulvegata 69", "Ulven per", 1973);
        dyr[3] = rovFab.nyUlvetispe(2019, "Ulvegata 69", "Ulven bertine", 1980, 3);
    }

    @BeforeEach
    public void setUp() throws Exception {
        instance = new Testklient();
    }

    @Test
    public void getNavnTest() {
        String res = dyr[0].getNavn();
        String exp = "Helenebjønn";
        assertEquals(exp, res);
    }

    @Test
    public void getFdatoTest() {
        int res = dyr[1].getFdato();
        int exp = 1999;
        assertEquals(exp, res);
    }

    @Test
    public void getAdresseTest() {
        String res = dyr[2].getAdresse();
        String exp = "Ulvegata 69";
        assertEquals(exp, res);
    }

    @Test
    public void getAlderTest() {
        int res = dyr[3].getAlder();
        int exp = 39;
        assertEquals(exp, res);
    }

    @Test
    public void flyttTest() {
        dyr[3].flytt("Bjørnegata 3");
        String res = dyr[3].getAdresse();
        String exp = "Bjørnegata 3";
        assertEquals(exp, res);
    }

    @Test
    public void getAntKullTest() {
        int res = dyr[0].getAntKull();
        int exp = 4;
        assertEquals(exp, res);
    }
}