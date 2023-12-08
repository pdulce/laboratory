package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TareaComparatorDiffblueTest {
    /**
     * Method under test: {@link TareaComparator#compare(Tarea, Tarea)}
     */
    @Test
    void testCompare() throws UnsupportedEncodingException {
        TareaComparator tareaComparator = new TareaComparator();

        Tarea o1 = new Tarea();
        o1.setArguments("Arguments");
        o1.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        o1.setChildren(new ArrayList<>());
        o1.setClassName("Class Name");
        o1.setContents("Not all who wander are lost");
        o1.setCoverage(true);
        o1.setFolderName("Folder Name");
        o1.setImports(new ArrayList<>());
        o1.setLevel("Level");
        o1.setMemberDeclarations(new ArrayList<>());
        o1.setMethodName("Method Name");
        o1.setName("Name");
        o1.setNumDependencies(3);
        o1.setNumLines(2);
        o1.setPackageName("java.text");
        o1.setReturnType("Return Type");
        o1.setSourceScanned("Source Scanned");
        o1.setTest("Test");

        Tarea o2 = new Tarea();
        o2.setArguments("Arguments");
        o2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        o2.setChildren(new ArrayList<>());
        o2.setClassName("Class Name");
        o2.setContents("Not all who wander are lost");
        o2.setCoverage(true);
        o2.setFolderName("Folder Name");
        o2.setImports(new ArrayList<>());
        o2.setLevel("Level");
        o2.setMemberDeclarations(new ArrayList<>());
        o2.setMethodName("Method Name");
        o2.setName("Name");
        o2.setNumDependencies(3);
        o2.setNumLines(2);
        o2.setPackageName("java.text");
        o2.setReturnType("Return Type");
        o2.setSourceScanned("Source Scanned");
        o2.setTest("Test");
        assertEquals(0, tareaComparator.compare(o1, o2));
    }

    /**
     * Method under test: {@link TareaComparator#compare(Tarea, Tarea)}
     */
    @Test
    void testCompare2() throws UnsupportedEncodingException {
        TareaComparator tareaComparator = new TareaComparator();

        Tarea o1 = new Tarea();
        o1.setArguments("Arguments");
        o1.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        o1.setChildren(new ArrayList<>());
        o1.setClassName("Class Name");
        o1.setContents("Not all who wander are lost");
        o1.setCoverage(true);
        o1.setFolderName("Folder Name");
        o1.setImports(new ArrayList<>());
        o1.setLevel("Level");
        o1.setMemberDeclarations(new ArrayList<>());
        o1.setMethodName("Method Name");
        o1.setName("Name");
        o1.setNumDependencies(3);
        o1.setNumLines(2);
        o1.setPackageName("Package Name");
        o1.setReturnType("Return Type");
        o1.setSourceScanned("Source Scanned");
        o1.setTest("Test");

        Tarea o2 = new Tarea();
        o2.setArguments("Arguments");
        o2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        o2.setChildren(new ArrayList<>());
        o2.setClassName("Class Name");
        o2.setContents("Not all who wander are lost");
        o2.setCoverage(true);
        o2.setFolderName("Folder Name");
        o2.setImports(new ArrayList<>());
        o2.setLevel("Level");
        o2.setMemberDeclarations(new ArrayList<>());
        o2.setMethodName("Method Name");
        o2.setName("Name");
        o2.setNumDependencies(3);
        o2.setNumLines(2);
        o2.setPackageName("java.text");
        o2.setReturnType("Return Type");
        o2.setSourceScanned("Source Scanned");
        o2.setTest("Test");
        assertEquals(-26, tareaComparator.compare(o1, o2));
    }
}
